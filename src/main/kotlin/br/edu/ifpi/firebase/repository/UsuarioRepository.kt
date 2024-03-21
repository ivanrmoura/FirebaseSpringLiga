package br.edu.ifpi.firebase.repository

import br.edu.ifpi.firebase.model.Usuario
import com.google.cloud.firestore.CollectionReference
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.SetOptions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UsuarioRepository {

    @Autowired
    private lateinit var firestorage: Firestore

    @Autowired
    private lateinit var bCrypt: BCryptPasswordEncoder

    private fun getUserCollection(): CollectionReference = firestorage
            .collection("usuarios")

    // Criar ou atualizar usuario
    fun createOrUpdateUser(user: Usuario): String{
        if (user.codigo == null || user.codigo.equals("")){
            user.codigo = UUID.randomUUID().toString()
            user.senha = bCrypt.encode(user.senha)
        }
        val collectionApiFuture = getUserCollection()
                .document(user.codigo.toString())
                .set(user, SetOptions.merge())
        return collectionApiFuture.get().updateTime.toString()
    }

    // buscar usuario por ID
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


    // buscar todos usuarios
    fun buscarTodosUsuarios():List<Usuario>{
        val usuariosList = mutableListOf<Usuario>()
        val future = getUserCollection().get()
        val documents = future.get().documents
        for (doc in documents){
            usuariosList.add(doc.toObject(Usuario::class.java))
        }
        return usuariosList
    }

    // deletar usuario
    fun deleteUser(codigo: String): String{
        val result = getUserCollection().document(codigo).delete()
        return "Documento ${codigo} deletado com sucesso!"
    }


    //Buscar usuario por email
    fun findUserByEmail(email: String): Usuario?{
        val query = getUserCollection()
                .whereEqualTo("email", email)
                .get()
        val document = query.get().documents
        if (document.size > 0) {
           return document[0].toObject(Usuario::class.java)
        }else{
            return null
        }
    }


    // buscar usuario por palavra chave
    fun findUserLikeName(searchKey: String): List<Usuario>?{
        val users = mutableListOf<Usuario>()
        val query = getUserCollection()
                .whereGreaterThanOrEqualTo("nome", searchKey)
                .whereLessThan("nome", searchKey + 'z')
                .get()
        val documents = query.get().documents
        if (documents.size > 0) {
            for (doc in documents){
                users.add(doc.toObject(Usuario::class.java))
            }
        }else{
            return null
        }
        return users
    }


}