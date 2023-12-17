package br.com.loja;
import java.util.ArrayList;

public class Pedido {
	int numeroPedido;
    String cpfCliente;
    ArrayList<ItemPedido> itens;

    public Pedido(int numeroPedido, String cpfCliente) {
        this.numeroPedido = numeroPedido;
        this.cpfCliente = cpfCliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco) {
        itens.add(new ItemPedido(nome, preco));
    }

    public void adicionarItem(ArrayList<ItemPedido> novosItens) {
        itens.addAll(novosItens);
    }

    public double calcularTotal(double percentualDesconto) {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.preco;
        }
        return total * (1 - percentualDesconto / 100);
    }

    public double calcularTotal(int numPrestacoes, double juros) {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.preco;
        }
        return total * (1 + (juros / 100) * numPrestacoes);
    }

    public void exibirInformacoes() {
        System.out.println("Número do Pedido: " + numeroPedido);
        System.out.println("CPF do Cliente: " + cpfCliente);
        System.out.println("Itens do Pedido:");
        for (ItemPedido item : itens) {
            System.out.println("- " + item.nome + ": R$" + item.preco);
        }
    }
}
