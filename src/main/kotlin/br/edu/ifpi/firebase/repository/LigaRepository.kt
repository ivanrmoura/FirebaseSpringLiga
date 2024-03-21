package br.edu.ifpi.firebase.repository

import br.edu.ifpi.firebase.model.Liga
import br.edu.ifpi.firebase.model.Usuario
import com.google.cloud.firestore.CollectionReference
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.SetOptions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class LigaRepository {

    @Autowired
    private lateinit var firestorage: Firestore

    private fun getLeagueCollection(): CollectionReference = firestorage
            .collection("ligas")

    // Cria ou atualiza uma liga
    fun createOrUpdateLeague(liga: Liga): String{
        if (liga.codigoLiga == null || liga.codigoLiga.equals("")){
            liga.codigoLiga = UUID.randomUUID().toString()
        }
        val collectionApiFuture = getLeagueCollection()
                .document(liga.codigoLiga.toString())
                .set(liga, SetOptions.merge())
        return collectionApiFuture.get().updateTime.toString()
    }



    // busca liga por id
    fun getLeague(codigoLiga: String): Liga?{
        val documentRef = getLeagueCollection().document(codigoLiga)
        val future = documentRef.get()
        val document = future.get()
        if (document.exists()){
            return document.toObject(Liga::class.java)
        }else{
            return null
        }
    }


    // busca liga por palavra chave
    fun findLigaLikeName(searchKey: String): List<Liga>?{
        val users = mutableListOf<Liga>()
        val query = getLeagueCollection()
                .whereGreaterThanOrEqualTo("nome", searchKey)
                .whereLessThan("nome", searchKey + 'z')
                .get()
        val documents = query.get().documents
        if (documents.size > 0) {
            for (doc in documents){
                users.add(doc.toObject(Liga::class.java))
            }
        }else{
            return null
        }
        return users
    }

}