package br.edu.ifpi.firebase.config

import com.google.cloud.firestore.Firestore
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.cloud.FirestoreClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FirebaseConfig {

    @Bean
    fun getDb(): Firestore = FirestoreClient.getFirestore()

    @Bean
    fun userAuthenticationServiceImpl(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    };

}