package application;

import consumers.ProdutoConsumer;
import entities.Produto;
import functions.ObterNomes;
import model.services.ProdutoService;
import predicates.ProdutoPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Programa {
    public static void main(String[] args) {

        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("IPHONE", 7600.00));
        produtos.add(new Produto("TV", 4500.00));
        produtos.add(new Produto("Mouse Logitech Super", 900.00));
        produtos.add(new Produto("HD Case", 80.00));

        List<Produto> produtos2 = new ArrayList<>(produtos);

        // Predicados

        // Método 1
        produtos.removeIf(produto -> produto.getPreco() >= 100.00);
        // Método 2
        produtos.removeIf(new ProdutoPredicate());
        // Método 3
        produtos.removeIf(Produto::staticProdutoPredicate);
        // Método 4
        produtos.removeIf(Produto::nonStaticProdutoPredicate);
        // Método 5
        Predicate<Produto> predicate = p -> p.getPreco() >= 100.00;
        produtos.removeIf(predicate);

        produtos.forEach(System.out::println);

        // Consumers

        // Método 1
        produtos.forEach(new ProdutoConsumer());
        // Método 2
        produtos.forEach(Produto::staticAtualizarPreco);
        // Método 3
        produtos.forEach(Produto::nonStaticAtualizarPreco);
        // Método 4
        Consumer<Produto> consumer = p -> {
            p.setPreco(p.getPreco() * 1.1);
        };
        consumer = p -> p.setPreco(p.getPreco() * 1.1);
        produtos.forEach(consumer);
        // Método 5
        produtos.forEach(p -> p.setPreco(p.getPreco() * 1.1));

        // Functions

        // Método 1
        List<String> nomesProdutos = produtos.stream().map(new ObterNomes()).collect(Collectors.toList());
        nomesProdutos.forEach(System.out::println);
        // Método 2
        nomesProdutos = produtos.stream().map(Produto::staticObterNomes).collect(Collectors.toList());
        // Método 3
        nomesProdutos = produtos.stream().map(Produto::nonStaticObterNomes).collect(Collectors.toList());
        // Método 4
        Function<Produto, String> function = p -> p.getNome().toUpperCase();
        nomesProdutos = produtos.stream().map(function).collect(Collectors.toList());
        // Método 5
        nomesProdutos = produtos.stream().map(p -> p.getNome().toUpperCase()).collect(Collectors.toList());

        // Function como parâmetro de chamada de método

        ProdutoService produtoService = new ProdutoService();
        Double soma = produtoService.somaPrecoPorCriterio(produtos2, p -> p.getNome().charAt(0) == 'T');
        System.out.println("Soma dos preços = " + soma);
    }
}
