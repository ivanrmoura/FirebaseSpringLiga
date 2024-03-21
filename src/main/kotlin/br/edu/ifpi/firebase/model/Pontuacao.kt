package br.edu.ifpi.firebase.model

data class Pontuacao(
        val codigoPontuacao: String? = null,
        val modalidade: String? = null,
        val pontuacao: Int = 0,
        val codigoInscricao: String? = null
)
