package br.edu.ifpi.firebase.model

data class Classificacao(
        val codigo: String? = null,
        val liga: Liga? = null,
        val equipe: Equipe? = null,
        val modalidade: Modalidade? = null,
        val pontuacao: Int = 0
)