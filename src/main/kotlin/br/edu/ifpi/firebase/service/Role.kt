package br.edu.ifpi.firebase.service

import org.springframework.security.core.GrantedAuthority

data class Role (
        val name: String = ""
): GrantedAuthority {
    override fun getAuthority(): String {
        return name
    }
}