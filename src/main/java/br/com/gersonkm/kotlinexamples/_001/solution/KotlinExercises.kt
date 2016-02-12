package br.com.gersonkm.kotlinexamples._001.solution

import br.com.gersonkm.kotlinexamples._001.Exercises
import br.com.gersonkm.kotlinexamples._001.Pedido
import br.com.gersonkm.kotlinexamples._001.Produto

object KotlinExercises : Exercises {

    override fun agrupaPedidosPorQtdeProduto(pedidos: List<Pedido>): Map<Int, List<Pedido>> {
        return pedidos.groupBy { it.produtos.size }
    }

    override fun agrupaPedidosComPeloMenosDoisProdutosPelaQtdeProdutos(pedidos: List<Pedido>): Map<Int, List<Pedido>> {
        return pedidos.filter { it.produtos.size >= 2 }.groupBy { it.produtos.size }
    }

    override fun filtraPedidosComValorMinimo(pedidos: List<Pedido>, valorMinimo: Double): List<Pedido> {
        return pedidos.filter { it.total() >= valorMinimo }
    }

    override fun extraiTodosProdutosDistintos(pedidos: List<Pedido>): List<Produto> {
        return pedidos.flatMap { it.produtos }.distinct()
    }

    override fun agrupaProdutosPorQuantidadeOcorrencia(pedidos: List<Pedido>): Map<Produto, Long> {
        return pedidos.flatMap { it.produtos }.groupBy { it }.mapValues { it.value.count().toLong() }
    }

    override fun extraiProdutoMaisCaroEntreOsPedidos(pedidos: List<Pedido>): Produto? {
        return pedidos.flatMap { it.produtos }.maxBy { it.preco }
    }

    override fun dividePedidosComLimiteValor(pedidos: List<Pedido>, valorLimite: Double): Pair<List<Pedido>, List<Pedido>> {
        return pedidos.partition { it.total() < valorLimite }
    }

    override fun geraStringComDescricaoTodosProdutos(pedidos: List<Pedido>): String {
        return pedidos
                .flatMap { it.produtos }
                .map { it.descricao.toUpperCase() }
                .distinct()
                .sorted()
                .joinToString (separator = ", ")
    }

}