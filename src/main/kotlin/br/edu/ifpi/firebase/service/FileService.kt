package br.edu.ifpi.firebase.service

import com.google.auth.Credentials
import com.google.auth.oauth2.GoogleCredentials
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
import java.time.LocalDateTime


@Service
class FileService {

    @Autowired
    private lateinit var resourceLoader: ResourceLoader

    private val BUCKET_NAME = "liga-app-b5c72.appspot.com"

    private val DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/$BUCKET_NAME/o/%s?alt=media"

    @Value("\${firebase.private.key}")
    lateinit var PRIVATE_KEY: String

    fun uploadFile(file: MultipartFile): String {
        val fileName = "${LocalDateTime.now()}_${file.originalFilename}"
        val blobId = BlobId.of(BUCKET_NAME, fileName)
        //val blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build()

        val blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType(file.contentType).build()

        val resource = resourceLoader.getResource(PRIVATE_KEY)
        val credentials: Credentials = GoogleCredentials.fromStream(resource.inputStream)
        val storage: Storage = StorageOptions.newBuilder().setCredentials(credentials).build().service
        storage.create(blobInfo, file.bytes)
        return String.format(DOWNLOAD_URL, URLEncoder.encode(fileName, StandardCharsets.UTF_8))
    }







}