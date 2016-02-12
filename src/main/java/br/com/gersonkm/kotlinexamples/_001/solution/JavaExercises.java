package br.com.gersonkm.kotlinexamples._001.solution;

import br.com.gersonkm.kotlinexamples._001.Exercises;
import br.com.gersonkm.kotlinexamples._001.Pedido;
import br.com.gersonkm.kotlinexamples._001.Produto;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaExercises implements Exercises {

    public static JavaExercises INSTANCE = new JavaExercises();

    @NotNull
    @Override
    public Map<Integer, List<Pedido>> agrupaPedidosPorQtdeProduto(@NotNull List<Pedido> pedidos) {
        return pedidos.stream()
                .collect(Collectors.groupingBy(pedido -> pedido.getProdutos().size()));
    }

    @NotNull
    @Override
    public Map<Integer, List<Pedido>> agrupaPedidosComPeloMenosDoisProdutosPelaQtdeProdutos(@NotNull List<Pedido> pedidos) {
        return pedidos.stream()
                .filter(pedido -> pedido.getProdutos().size() >= 2)
                .collect(Collectors.groupingBy(pedido -> pedido.getProdutos().size()));
    }

    @NotNull
    @Override
    public List<Pedido> filtraPedidosComValorMinimo(@NotNull List<Pedido> pedidos, double valorMinimo) {
        return pedidos.stream()
                .filter(pedido -> pedido.total() >= valorMinimo)
                .collect(Collectors.toList());
    }

    @NotNull
    @Override
    public List<Produto> extraiTodosProdutosDistintos(@NotNull List<Pedido> pedidos) {
        return pedidos.stream()
                .flatMap(pedido -> pedido.getProdutos().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    @NotNull
    @Override
    public Map<Produto, Long> agrupaProdutosPorQuantidadeOcorrencia(@NotNull List<Pedido> pedidos) {
        return pedidos.stream()
                .flatMap(pedido -> pedido.getProdutos().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    @Nullable
    @Override
    public Produto extraiProdutoMaisCaroEntreOsPedidos(@NotNull List<Pedido> pedidos) {
        return pedidos.stream()
                .flatMap(pedido -> pedido.getProdutos().stream())
                .max((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()))
                .orElse(null);
    }

    @NotNull
    @Override
    public Pair<List<Pedido>, List<Pedido>> dividePedidosComLimiteValor(@NotNull List<Pedido> pedidos, double valorLimite) {
        Map<Boolean, List<Pedido>> pedidosParticionados = pedidos.stream()
                .collect(Collectors.partitioningBy(t -> t.total() < valorLimite));
        return new Pair<>(pedidosParticionados.get(true), pedidosParticionados.get(false));
    }

    @NotNull
    @Override
    public String geraStringComDescricaoTodosProdutos(@NotNull List<Pedido> pedidos) {
        return pedidos.stream()
                .flatMap(pedido -> pedido.getProdutos().stream())
                .map(produto -> produto.getDescricao().toUpperCase())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
    }
}
