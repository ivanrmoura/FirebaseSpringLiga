package br.edu.ifpi.firebase.model

data class ResultadoEquipe (
        val equipe: Equipe? = null,
        val posicao: Int = 0,
        val pontuacao: Int = 0,
        val vencedor: Boolean = false
)