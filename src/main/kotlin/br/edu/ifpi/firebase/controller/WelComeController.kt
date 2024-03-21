package br.edu.ifpi.firebase.controller

import br.edu.ifpi.firebase.model.Usuario
import ch.qos.logback.core.net.LoginAuthenticator
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import java.security.Principal


@Controller
class WelComeController {
    @GetMapping("/welcome")
    fun greeting(): String {
        return "welcome"
    }

    @GetMapping("/login")
    fun login(request: HttpServletRequest): String {
        println(request.userPrincipal)
        if (request.userPrincipal != null){
            println(request.userPrincipal.name)
            return "welcome"

        }
        return "login"
    }


}