package br.edu.ifpi.firebase.model

import java.time.LocalDateTime

data class Jogo(
        val codigo: String? = null,
        val modalidade: String? = null,
        val data: LocalDateTime? = null,
        val local: String? = null,
        val liga: Liga? = null,
        val resultados: List<ResultadoEquipe> = mutableListOf()
)
