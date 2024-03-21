package br.edu.ifpi.firebase.model

import br.edu.ifpi.firebase.service.Role

data class Usuario (
        var codigo: String? = null,
        val nome: String = "",
        val email: String = "",
        var senha: String = "",
        val foto: String = "",
        val roles: List<Role> = mutableListOf()
)