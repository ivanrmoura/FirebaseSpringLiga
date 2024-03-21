package br.edu.ifpi.firebase.model

import java.time.LocalDate

data class AssociacaoEquipeUsuario(
        val codigoAssociacao: String? = null,
        val dataAssociacao: LocalDate = LocalDate.now(),
        val isTecnico: Boolean = false,
        val codigoUsuario: String? = null,
        val codigoEquipe: String? = null,
        val equipe: Equipe? = null,
        val usuario: Usuario? = null
)
