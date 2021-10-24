package consumers;

import entities.Produto;

import java.util.function.Consumer;

public class ProdutoConsumer implements Consumer<Produto> {

    @Override
    public void accept(Produto produto) {
        produto.setPreco(produto.getPreco() * 1.1);
    }
}
