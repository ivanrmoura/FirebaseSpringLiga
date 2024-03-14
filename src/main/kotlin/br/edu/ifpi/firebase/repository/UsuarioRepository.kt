package br.edu.ifpi.firebase.repository

import br.edu.ifpi.firebase.model.Usuario
import com.google.cloud.firestore.CollectionReference
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.SetOptions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UsuarioRepository {

    @Autowired
    private lateinit var firestorage: Firestore

    private fun getUserCollection(): CollectionReference = firestorage
            .collection("usuarios")

    fun createOrUpdateUser(user: Usuario): String{
        if (user.codigo == null || user.codigo.equals("")){
            user.codigo = UUID.randomUUID().toString()
        }
        val collectionApiFuture = getUserCollection()
                .document(user.codigo.toString())
                .set(user, SetOptions.merge())
        return collectionApiFuture.get().updateTime.toString()
    }

    fun getUser(codigo: String): Usuario?{
        val documentRef = getUserCollection().document(codigo)
        val future = documentRef.get()
        val document = future.get()
        if (document.exists()){
            return document.toObject(Usuario::class.java)
        }else{
            return null
        }
    }


    fun buscarTodosUsuarios():List<Usuario>{
        val usuariosList = mutableListOf<Usuario>()
        val future = getUserCollection().get()
        val documents = future.get().documents
        for (doc in documents){
            usuariosList.add(doc.toObject(Usuario::class.java))
        }
        return usuariosList
    }

    fun deleteUser(codigo: String): String{
        val result = getUserCollection().document(codigo).delete()
        return "Documento ${codigo} deletado com sucesso!"
    }



    fun buscarPorModalidade(modalidade: String): List<Usuario>{
        val users = mutableListOf<Usuario>()

        /*val queryNomeEmail = getUserCollection()
                .whereEqualTo("nome", "Ivan Rodrigues")
                .whereEqualTo("email", "ivan@gmail.com")
                .get()
        */

        val t = getUserCollection()
                .whereIn("codigo", listOf("" +
                        "d733066c-6173-4a44-983c-52f60b88a336",
                        "d8437ce2-f8be-4b5d-9c11-569871a63ebd"))
                .get()

        val documents = t.get().documents
        for (doc in documents){
            users.add(doc.toObject(Usuario::class.java))
        }
        return users
    }



}