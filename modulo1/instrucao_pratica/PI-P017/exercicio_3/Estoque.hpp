#if !defined(ESTOQUE_HPP)
#define ESTOQUE_HPP

#include"Produto.hpp"
#include<vector>

using namespace std;

class Estoque
{
private:
    static vector<Produto> estoque;
    public:
        Estoque(){

        }

        static void reabastecimento(Produto novo, int qtd){
            int indice = indexProduto(novo);

            if(indice < 0){
                novo.setQTD(qtd);
                estoque.push_back(novo);
                return;
            }
            
            estoque[indice].setQTD(estoque[indice].getQTD() + qtd);
        }

        static void retirada(Produto _tira, int _qtd){
            int indice = indexProduto(_tira);
            int qtd = estoque[indice].getQTD();
            if(indice < 0){
                cout << "Produto nao cadastrado!" << endl;
                return;
            }
            
            if(qtd < _qtd){
                cout << "Nao ha a quantidade solicitada!" << endl;
                cout << "No momento ha apenas " << qtd << " unidades!" << endl;
                return;
            }

            estoque[indice].setQTD(qtd - _qtd);
            return;
        }

        static bool hasQTD(Produto produto, int qtd){
            for(Produto p : estoque){
                if(p.getCodigo() == produto.getCodigo() && p.getQTD() >= qtd)
                    return true;
            }
            return false;
        }

        static int getQTD(Produto produto){
            for(Produto p : estoque){
                if(p.getCodigo() == produto.getCodigo())
                    return p.getQTD();
            }
            return -1;
        }

        static bool hasProduto(Produto produto){
            for(Produto p: estoque){
                if(p.getCodigo() == produto.getCodigo())
                    return true;
            }
            return false;
        }

        static int indexProduto(Produto produto){
            for (size_t i = 0; i < estoque.size(); i++){
                if(estoque[i].getCodigo() == produto.getCodigo())
                    return i;
            }
            return -1;
        }

        ~Estoque(){

        }
};

#endif // ESTOQUE_HPP
