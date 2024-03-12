package br.edu.ifpi.firebase.model

data class Modalidade (
        val codigo: String? = null,
        val nome: String = "",
        val tipo: TipoModalidade? = null,
        val quatidadeAtletas: Int = 0
)