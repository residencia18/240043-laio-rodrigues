#include"Produto.hpp"
#include "Carrinho.hpp"

using namespace std;

int Produto::cont = 0;
vector<Produto> Estoque::estoque;

int main(){

    Produto p1("Maca", 2.5);
    Produto p2("Arroz", 10.0);
    Produto p3("Leite", 4.0);
    Estoque::reabastecimento(p1, 5);
    Estoque::reabastecimento(p2, 5);
    Estoque::reabastecimento(p3, 5);
    CarrinhoDeCompras carrinho;
    
    carrinho.adicionarProduto(p1, 3);
    carrinho.adicionarProduto(p2, 2);
    carrinho.adicionarProduto(p3, 1);
    double valorTotal = carrinho.calcularValorTotal();
    cout << "Valor total da compra: " << valorTotal << endl;
    // Resposta: Valor total da compra: 31.5

    carrinho.removerProduto(p2, 1);
    valorTotal = carrinho.calcularValorTotal();
    cout << "Valor total apos remocao: " << valorTotal << endl;
    // Resposta: Valor total após remoção: 21.5

    Produto p4("Chocolate", 3.0);
    Estoque::reabastecimento(p4, 5);
    carrinho.adicionarProduto(p4, 10); // Supondo estoque limitado a 5 unidades
    cout << "Quantidade de chocolates no carrinho: " << carrinho.getQuantidadeProduto(p4) << endl;
    // Resposta: Quantidade de chocolates no carrinho: 5

    
    carrinho.esvaziarCarrinho();
    valorTotal = carrinho.calcularValorTotal();
    cout << "Valor total apos esvaziar o carrinho: " << valorTotal << endl;
    // Resposta: Valor total após esvaziar o carrinho: 0.0

    carrinho.adicionarProduto(p1, 2);
    carrinho.adicionarProduto(p2, 3);
    carrinho.adicionarProduto(p3, 1);
    carrinho.adicionarProduto(p4, 2);

    carrinho.exibirCarrinho();
    // Resposta: Carrinho de Compras:
    // - Maçã (2.5) x 2
    // - Arroz (10.0) x 3
    // - Leite (4.0) x 1
    // - Chocolate (3.0) x 2

    return 0;
}