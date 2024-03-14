package br.edu.ifpi.firebase.controller

import br.edu.ifpi.firebase.model.Usuario
import br.edu.ifpi.firebase.repository.UsuarioRepository
import br.edu.ifpi.firebase.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
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
    private lateinit var usuarioRepository: UsuarioRepository


    @PostMapping("/salvar")
    fun salvarUsuario(
            @RequestBody usuario: Usuario
    ): ResponseEntity<String> {

        val retorno = usuarioRepository.createOrUpdateUser(usuario)
        return ResponseEntity.ok(retorno)
    }

    @GetMapping("/buscar")
    fun buscarUsuario(
            @RequestParam codigo: String
    ): ResponseEntity<Usuario>{
        val user = usuarioRepository.getUser(codigo)
        return ResponseEntity.ok(user)
    }

    @GetMapping("/buscar/todos")
    fun buscarTodosUsuario(
    ): ResponseEntity<List<Usuario>>{
        val users = usuarioRepository.buscarTodosUsuarios()
        return ResponseEntity.ok(users)
    }


    @DeleteMapping("/delete")
    fun deleteUsuario(
            @RequestParam codigo: String
    ): ResponseEntity<String>{
        val user = usuarioRepository.deleteUser(codigo)
        return ResponseEntity.ok(user)
    }


    @GetMapping("/buscar/modalidade")
    fun buscarUsuarioPorModalidade(
            @RequestParam modalidade: String
    ): ResponseEntity<List<Usuario>>{
        val users = usuarioRepository.buscarPorModalidade(modalidade)
        return ResponseEntity.ok(users)
    }

}