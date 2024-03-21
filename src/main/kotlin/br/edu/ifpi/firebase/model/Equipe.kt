package br.edu.ifpi.firebase.model

data class Equipe(
        val codigoEquipe: String? = null,
        val nome: String = "",
        val criadorEquipe: Usuario? = null,
)
