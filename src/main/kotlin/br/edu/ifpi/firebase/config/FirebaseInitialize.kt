package br.edu.ifpi.firebase.config

import com.google.auth.Credentials
import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class FirebaseInitialize {

    @Autowired
    private lateinit var resourceLoader: ResourceLoader

    @Value("\${firebase.private.key}")
    lateinit var PRIVATE_KEY: String

    @PostConstruct
    fun initialize(){

        val resource = resourceLoader.getResource(PRIVATE_KEY)

        val options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(resource.inputStream))
                //.setDatabaseUrl()
                .build()

        FirebaseApp.initializeApp(options)
    }

}