package br.edu.ifpi.firebase.model

data class Liga(
        val codigo: String? = null,
        val nome: String = "",
        val criador: Usuario? = null,
        val modalidades: List<Modalidade> = mutableListOf(),
        val equipes: List<Equipe> = mutableListOf()
){
    fun getLigaNameId(): Liga{
        return Liga(
                codigo = this.codigo,
                nome = this.nome
                )
    }
}
