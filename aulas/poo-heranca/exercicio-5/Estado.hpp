#if !defined(ESTADO_HPP)
#define ESTADO_HPP

#include"Cidade.hpp"
#include<vector>

class Estado{
    protected:
        string nome;
        string sigla;
        vector<Cidade> cidades;
        
    public:
        Estado(string nome, string sigla){
            this->nome = nome;
            this->sigla = sigla;
        }
        void setCidade(Cidade c){
            cidades.push_back(c);
        }
        vector<Cidade> getCidades(){
            return this->cidades;
        }
        string toString(){
            string texto;
            texto = this->nome + " - " + this->sigla;
            return texto;
        }
        ~Estado(){}
};

#endif // ESTADO_HPP
