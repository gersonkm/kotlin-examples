package br.com.gersonkm.kotlinexamples._001

data class Pedido(val numero: Int, val produtos: List<Produto>) {
    fun total(): Double {
        return produtos.sumByDouble { it.preco }
    }
}
