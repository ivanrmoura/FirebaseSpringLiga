package br.edu.ifpi.firebase.model

data class Equipe(
        val codigo: String? = null,
        val nome: String = "",
        val tecnico: Usuario? = null,
        val jogadores: List<Usuario> = mutableListOf(),
        val ligas: List<Liga> = mutableListOf()
)
