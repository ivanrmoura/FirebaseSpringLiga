package br.edu.ifpi.firebase.model

import java.time.LocalDate
import java.time.LocalDateTime

data class Liga(
        var codigoLiga: String? = null,
        val dataCriacao: LocalDate = LocalDate.now(),
        val nome: String = "",
        val codigoCriador: String? = null,
        val criador: Usuario? = null,
        val modalidades: MutableList<String> = mutableListOf()
)
