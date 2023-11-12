#if !defined(CARRINHO_HPP)
#define CARRINHO_HPP

#include "Estoque.hpp"

using namespace std;

class CarrinhoDeCompras{
    private:
        vector<Produto> produtos;
    public:
        CarrinhoDeCompras(){

        }
        
        void adicionarProduto(Produto novo, int qtd){
            int indice = Estoque::indexProduto(novo);
            int _qtd = Estoque::getQTD(novo);
            if(indice == -1 || _qtd == -1)
                return;
            
            if(_qtd < qtd)
                qtd = _qtd;

            novo.setQTD(qtd);
            produtos.push_back(novo);
            Estoque::retirada(novo, qtd);
        }

        int getQuantidadeProduto(Produto produto){
            for(Produto p : produtos){
                if(p.getCodigo() == produto.getCodigo())
                    return p.getQTD();
            }
            return 0;
        }

        void removerProduto(Produto tira, int qtd){
            if(hasProduto(tira)){
                int indice = indexProduto(tira);
                int _qtd = produtos[indice].getQTD();

                if(_qtd - qtd < 0)
                    qtd = _qtd;
                Estoque::reabastecimento(tira, qtd);
                if(qtd == _qtd){
                    produtos.erase(produtos.begin()+indice);
                    return;
                }else{
                    produtos[indice].setQTD(_qtd - qtd);
                    return;
                }
            }else{
                cout << "Produto nao existe no carrinho!" << endl;
            }
        }

        double calcularValorTotal(){
            double soma = 0;
            for(Produto p : produtos){
                soma += (p.getPreco() * p.getQTD());
            }
            return soma;
        }

        void esvaziarCarrinho(){
            for (size_t i = produtos.size(); i > 0; i--){
                Estoque::reabastecimento(produtos[i-1], produtos[i-1].getQTD());
                produtos.erase(produtos.begin()+i-1);
            }
            
        }

        void exibirCarrinho(){
            for(Produto p : produtos){
                cout << p.toString() << endl;
            }
        }

        bool hasQTD(Produto produto, int qtd){
            for(Produto p : produtos){
                if(p.getCodigo() == produto.getCodigo() && p.getQTD() >= qtd)
                    return true;
            }
            return false;
        }

        bool hasProduto(Produto produto){
            for(Produto p: produtos){
                if(p.getCodigo() == produto.getCodigo())
                    return true;
            }
            return false;
        }

        int indexProduto(Produto produto){
            for (size_t i = 0; i < produtos.size(); i++){
                if(produtos[i].getCodigo() == produto.getCodigo())
                    return i;
            }
            return -1;
        }

        ~CarrinhoDeCompras(){

        }
};

#endif // CARRINHO_HPP
