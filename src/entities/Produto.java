package entities;

public class Produto {
    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto: {" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    public static boolean staticProdutoPredicate(Produto p) {
        return p.getPreco() >= 100.00;
    }

    public boolean nonStaticProdutoPredicate() {
        return this.preco >= 100.00;
    }

    public static void staticAtualizarPreco(Produto p) {
        p.setPreco(p.getPreco() * 1.1);
    }

    public void nonStaticAtualizarPreco() {
        this.preco = this.preco * 1.1;
    }
}
