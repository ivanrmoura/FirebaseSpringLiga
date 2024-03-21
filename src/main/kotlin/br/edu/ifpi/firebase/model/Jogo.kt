package br.edu.ifpi.firebase.model

import java.time.LocalDateTime

data class Jogo(
        val codigoJogo: String? = null,
        val codigoLiga: String? = null,
        val modalidade: String? = null,
        val data: LocalDateTime? = null,
        val local: String? = null,
        val liga: Liga? = null,
)
