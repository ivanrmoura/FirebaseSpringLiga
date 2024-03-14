package br.edu.ifpi.firebase.model

data class ParticipacaoJogo(
        val usuarioCodigo: String? = null,
        val ligaNomeId: Liga? = null,
        val modalidade: String? = null,
        val quantidade: Int = 0
)
