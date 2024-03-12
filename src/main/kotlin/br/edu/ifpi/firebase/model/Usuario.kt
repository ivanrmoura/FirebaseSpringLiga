package br.edu.ifpi.firebase.model

data class Usuario (
        var codigo: String? = null,
        val nome: String = "",
        val email: String = "",
        val senha: String = "",
        val foto: String = "",
        val papel: List<Papel> = mutableListOf(),
        val participacoes: List<ParticipacaoJogo> = mutableListOf()
)