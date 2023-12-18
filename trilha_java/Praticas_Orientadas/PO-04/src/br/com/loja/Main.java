package br.com.loja;

public class Main {
	public static void main(String[] args) {
        // Exemplo de pedido com desconto à vista
        Pedido pedidoDesconto = new Pedido(1, "123.456.789-01");
        pedidoDesconto.adicionarItem("Produto1", 50.0);
        pedidoDesconto.adicionarItem("Produto2", 30.0);
        
        System.out.println("Total do Pedido com Desconto à Vista: R$" + pedidoDesconto.calcularTotal(10));
        pedidoDesconto.exibirInformacoes();

        // Exemplo de pedido a prazo com parcelamento e juros
        Pedido pedidoPrazo = new Pedido(2, "987.654.321-00");
        pedidoPrazo.adicionarItem("Produto3", 40.0);
        pedidoPrazo.adicionarItem("Produto4", 25.0);

        System.out.println("\nTotal do Pedido a Prazo: R$" + pedidoPrazo.calcularTotal(3, 5));
        pedidoPrazo.exibirInformacoes();
    }
}
