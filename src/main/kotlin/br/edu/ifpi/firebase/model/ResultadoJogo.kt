package br.edu.ifpi.firebase.model

data class ResultadoJogo(
        val codigoResultadoJogo: String? = null,
        val codigoJogo: String? = null,
        val codigoEquipe: String? = null,
        val isVencedor: Boolean = false,
        val posicao: Int = 0,
        val pontuacao: Int = 0,
        val jogo: Jogo? = null,
        val Equipe: Equipe? = null
)
