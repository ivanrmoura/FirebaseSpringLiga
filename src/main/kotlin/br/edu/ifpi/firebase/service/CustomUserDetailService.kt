package br.edu.ifpi.firebase.service

import br.edu.ifpi.firebase.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailService (): UserDetailsService {

    @Autowired
    private lateinit var userRepository: UsuarioRepository

    override fun loadUserByUsername(userEmail: String): UserDetails {
        val user = userRepository.findUserByEmail(userEmail)
        //User
        return User(user?.email, user?.senha, user?.roles)
    }
}