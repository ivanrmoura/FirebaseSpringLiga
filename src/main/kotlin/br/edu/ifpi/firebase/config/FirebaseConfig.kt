package br.edu.ifpi.firebase.config

import com.google.cloud.firestore.Firestore
import com.google.cloud.storage.Storage
import com.google.firebase.cloud.FirestoreClient
import com.google.firebase.cloud.StorageClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FirebaseConfig {

    @Bean
    fun getDb(): Firestore = FirestoreClient.getFirestore()

}