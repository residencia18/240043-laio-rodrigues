#if !defined(CARRINHO_HPP)
#define CARRINHO_HPP

#include "Estoque.hpp"

using namespace std;

class Carrinho{
    private:
        vector<Produto> produtos;
    public:
        Carrinho();
        
        void addProduto(Produto novo, int qtd){
            if(Estoque::hasQTD(novo, qtd)){
                novo.setQTD(qtd);
                produtos.push_back(novo);
                Estoque::retirada(novo, qtd);
            }else{
                cout << "Qtd insuficiente!" << endl;
            }
        }

        void removeProduto(Produto tira, int qtd){
            int indice;
            if(hasProduto(tira)){
                Estoque::reabastecimento(tira, qtd);
                indice = indexProduto(tira);
                produtos.erase(produtos.begin()+indice);
            }else{
                cout << "Produto nao existe no carrinho!" << endl;
            }
        }

        double getPrecoTotal(){
            double soma = 0;
            for(Produto p : produtos){
                soma += p.getPreco();
            }
            return soma;
        }

        void esvaziar(){
            for (size_t i = 0; i < produtos.size(); i++){
                Estoque::reabastecimento(produtos[i], produtos[i].getQTD());
                produtos.erase(produtos.begin()+i);
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

        ~Carrinho();
};

#endif // CARRINHO_HPP
