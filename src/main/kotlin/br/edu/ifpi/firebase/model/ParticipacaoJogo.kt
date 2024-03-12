package br.edu.ifpi.firebase.model

data class ParticipacaoJogo(
        val ligaNomeId: Liga? = null,
        val modalidade: Modalidade? = null,
        val quantidade: Int = 0
)
