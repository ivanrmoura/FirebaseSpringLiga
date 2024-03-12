package br.edu.ifpi.firebase.controller

import br.edu.ifpi.firebase.model.Usuario
import br.edu.ifpi.firebase.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

@RestController
@RequestMapping("api/v1/usuario")
class UsuarioController {

    @Autowired
    private lateinit var userService: UserService


    @PostMapping("/salvar")
    fun salvarUsuario(
            @RequestBody usuario: Usuario
    ): ResponseEntity<String> {
        usuario.codigo = UUID.randomUUID().toString()
        val retorno = userService.salvarUsuario(usuario)
        return ResponseEntity.ok(retorno)
    }

    @GetMapping
    fun buscarUsuario(
            @PathVariable codigo: String
    ): ResponseEntity<Usuario>{
        val user = userService.buscarUsuarios(codigo)
        return ResponseEntity.ok(user)
    }




}