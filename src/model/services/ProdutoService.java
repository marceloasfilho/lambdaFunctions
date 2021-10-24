package model.services;

import entities.Produto;

import java.util.List;
import java.util.function.Predicate;

public class ProdutoService {

    public Double somaPrecoPorCriterio(List<Produto> produtos, Predicate<Produto> criterio) {
        Double soma = 0.00;
        for (Produto p : produtos) {
            if (criterio.test(p)) {
                soma += p.getPreco();
            }
        }
        return soma;
    }
}
