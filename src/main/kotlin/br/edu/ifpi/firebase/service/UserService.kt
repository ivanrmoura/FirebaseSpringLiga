package br.edu.ifpi.firebase.service

import br.edu.ifpi.firebase.model.Usuario
import com.google.auth.Credentials
import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.CollectionReference
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.SetOptions
import com.google.cloud.storage.BlobId
import com.google.cloud.storage.BlobInfo
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.FileInputStream
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@Service
class UserService {

    @Autowired
    private lateinit var firestorage: Firestore

    private fun getUserCollection(): CollectionReference = firestorage.collection("usuarios")

    fun salvarUsuario(usuario: Usuario): String {
        val collectionApiFuture = getUserCollection().document(usuario.codigo.toString()).set(usuario, SetOptions.merge())
        return collectionApiFuture.get().updateTime.toString()
    }

    fun buscarUsuarios(id: String): Usuario?{
        val documentRef = getUserCollection().document(id)
        val future = documentRef.get()
        val document = future.get()
        if (document.exists()){
            return document.toObject(Usuario::class.java)
        }else{
            return null
        }
    }




}