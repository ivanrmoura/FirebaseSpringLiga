package br.edu.ifpi.firebase.model

import java.time.LocalDate

data class Inscricao(
        val codigoInscriao: String? = null,
        val dataInscricao: LocalDate = LocalDate.now(),
        val idLiga: String? = null,
        val idEquipe: String? = null,
        val equipe: Equipe? = null,
        val liga: Liga? = null
)
