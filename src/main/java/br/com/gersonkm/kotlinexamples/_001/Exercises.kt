package br.com.gersonkm.kotlinexamples._001

interface Exercises {

    /**
     * Agrupa os [pedidos] pela quantidade de produtos que eles possuem.
     * @author Pedido
     * @since 1.2
     * @see 2sads
     */
    fun agrupaPedidosPorQtdeProduto(pedidos: List<Pedido>): Map<Int, List<Pedido>>;

    /**
     * Agrupa os [pedidos] que tenham pelo menos dois produtos pela quantidade de produtos.
     */
    fun agrupaPedidosComPeloMenosDoisProdutosPelaQtdeProdutos(pedidos: List<Pedido>): Map<Int, List<Pedido>>

    /**
     * Filtra os [pedidos] cujo valor é maior ou igual que [valorMinimo].
     */
    fun filtraPedidosComValorMinimo(pedidos: List<Pedido>, valorMinimo: Double): List<Pedido>

    /**
     * Extrai-se os produtos distintos de todos os [pedidos].
     */
    fun extraiTodosProdutosDistintos(pedidos: List<Pedido>): List<Produto>

    /**
     * Extrai-se os produtos de todos os [pedidos] e os agrupa pela sua quantidade de ocorrência.
     */
    fun agrupaProdutosPorQuantidadeOcorrencia(pedidos: List<Pedido>): Map<Produto, Long>

    /**
     * Extrai o produto mais caro entre os pedidos ou `null` caso [pedidos] esteja vazia.
     */
    fun extraiProdutoMaisCaroEntreOsPedidos(pedidos: List<Pedido>): Produto?

    /**
     * Particiona os [pedidos] em duas listas:
     * - lista de pedidos com total menor ou igual que o [valorLimite]
     * - lista de pedidos com total maior que o [valorLimite]
     */
    fun dividePedidosComLimiteValor(pedidos: List<Pedido>, valorLimite: Double): Pair<List<Pedido>, List<Pedido>>

    /**
     * Gera uma string contendo a descrição de todos os produtos distintos dos [pedidos], separados por ', '
     * (vírgula seguido de espaço), em ordem alfabética, com todos os caracteres em maiúsculo.
     */
    fun geraStringComDescricaoTodosProdutos(pedidos: List<Pedido>): String

}