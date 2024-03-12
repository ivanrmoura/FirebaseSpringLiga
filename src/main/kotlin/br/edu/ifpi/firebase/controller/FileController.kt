package br.edu.ifpi.firebase.controller

import br.edu.ifpi.firebase.service.FileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("api/v1/files")
class FileController {

    @Autowired
    private lateinit var fileService: FileService


    @PostMapping("upload")
    fun uploadFile(
            @RequestParam file: MultipartFile
    ): ResponseEntity<String>{
        val retorno = fileService.uploadFile(file)
        return ResponseEntity.ok(retorno)
    }



}