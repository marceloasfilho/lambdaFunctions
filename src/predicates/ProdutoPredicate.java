package predicates;

import entities.Produto;

import java.util.function.Predicate;

public class ProdutoPredicate implements Predicate<Produto> {

    @Override
    public boolean test(Produto produto) {
        return produto.getPreco() >= 100.00;
    }
}
