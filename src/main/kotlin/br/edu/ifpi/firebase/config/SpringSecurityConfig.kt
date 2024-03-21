package br.edu.ifpi.firebase.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
class SpringSecurityConfig {



    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()


    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain{

        http.csrf { it.disable() }
                .authorizeHttpRequests { authorization ->
                    authorization
                            .requestMatchers("/api/v1/usuario/like/nome").permitAll()
                            .anyRequest().authenticated()

                }
                .formLogin { form ->
                    form.loginPage("/login")
                            .loginProcessingUrl("/login")
                            .defaultSuccessUrl("/welcome")
                            .permitAll()
                }

                .logout { logout ->
                    logout.logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                            .permitAll()
                }

        return http.build()

    }


    @Bean
    fun authenticationManager(configuration: AuthenticationConfiguration) : AuthenticationManager{
        return configuration.authenticationManager

    }


}