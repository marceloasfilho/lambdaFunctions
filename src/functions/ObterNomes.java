package functions;

import entities.Produto;

import java.util.function.Function;

public class ObterNomes implements Function<Produto, String> {
    @Override
    public String apply(Produto produto) {
        return produto.getNome().toUpperCase();
    }
}
