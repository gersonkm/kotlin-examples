package br.com.gersonkm.kotlinexamples._001

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.junit.MatcherAssert.assertThat
import org.junit.Test

abstract class TestsExercises(val exercises: Exercises) {

    val prod01 = Produto("prod01", 100.0)
    val prod02 = Produto("prod02", 200.0)
    val prod03 = Produto("prod03", 300.0)

    val pedido01 = Pedido(1, listOf(prod01, prod01, prod02)) // R$400,00
    val pedido02 = Pedido(2, listOf(prod02, prod03)) // R$500,00
    val pedido03 = Pedido(3, listOf(prod01, prod02, prod03)) // R$600,00
    val pedido04 = Pedido(4, listOf(prod01, prod02, prod02, prod03)) // R$800,00
    val pedido05 = Pedido(5, listOf(prod03)) // R$300,00
    val pedido06 = Pedido(6, listOf(prod02, prod02)) // R$400,00

    val todosPedidos = listOf(pedido01, pedido02, pedido03, pedido04, pedido05, pedido06)

    @Test
    fun agrupaPedidosPorQtdeProduto() {
        val agrupamento = exercises.agrupaPedidosPorQtdeProduto(todosPedidos)
        assertThat(agrupamento, `is`(
                mapOf(
                        1 to listOf(pedido05),
                        2 to listOf(pedido02, pedido06),
                        3 to listOf(pedido01, pedido03),
                        4 to listOf(pedido04)
                )
        ))
    }

    @Test
    fun agrupaPedidosComPeloMenosDoisProdutosPelaQtdeProdutos() {
        val agrupamento = exercises.agrupaPedidosComPeloMenosDoisProdutosPelaQtdeProdutos(todosPedidos)
        assertThat(agrupamento, `is`(
                mapOf(
                        2 to listOf(pedido02, pedido06),
                        3 to listOf(pedido01, pedido03),
                        4 to listOf(pedido04)
                )
        ))
    }

    @Test
    fun filtraPedidosComValorMinimo() {
        val pedidos = exercises.filtraPedidosComValorMinimo(todosPedidos, 600.0)
        assertThat(pedidos, `is`(listOf(pedido03, pedido04)))
    }

    @Test
    fun extraiTodosProdutosDistintos() {
        val produtos = exercises.extraiTodosProdutosDistintos(todosPedidos)
        assertThat(produtos, `is`(listOf(prod01, prod02, prod03)))
    }

    @Test
    fun agrupaProdutosPorQuantidadeOcorrencia() {
        val agrupamento = exercises.agrupaProdutosPorQuantidadeOcorrencia(todosPedidos)
        assertThat(agrupamento, `is`(
                mapOf(
                        prod01 to 4L,
                        prod02 to 7L,
                        prod03 to 4L
                )
        ))
    }

    @Test
    fun extraiProdutoMaisCaroEntreOsPedidos01() {
        val produto = exercises.extraiProdutoMaisCaroEntreOsPedidos(todosPedidos)
        assertThat(produto, `is`(prod03))
    }

    @Test
    fun extraiProdutoMaisCaroEntreOsPedidos02() {
        val produto = exercises.extraiProdutoMaisCaroEntreOsPedidos(listOf(pedido01, pedido06))
        assertThat(produto, `is`(prod02))
    }

    @Test
    fun extraiProdutoMaisCaroEntreOsPedidos03() {
        val produto = exercises.extraiProdutoMaisCaroEntreOsPedidos(listOf())
        assertThat(produto, `is`(nullValue()))
    }

    @Test
    fun dividePedidosComLimiteValor() {
        val (pedidosMenor500, pedidosAcima500) = exercises.dividePedidosComLimiteValor(todosPedidos, 499.99)
        assertThat(pedidosMenor500, `is`(listOf(pedido01, pedido05, pedido06)))
        assertThat(pedidosAcima500, `is`(listOf(pedido02, pedido03, pedido04)))
    }

    @Test
    fun geraStringComDescricaoTodosProdutos01() {
        val string = exercises.geraStringComDescricaoTodosProdutos(todosPedidos)
        assertThat(string, `is`("PROD01, PROD02, PROD03"))
    }

    @Test
    fun geraStringComDescricaoTodosProdutos02() {
        val string = exercises.geraStringComDescricaoTodosProdutos(listOf(pedido02))
        assertThat(string, `is`("PROD02, PROD03"))
    }
}