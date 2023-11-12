#if !defined(ESTADO_HPP)
#define ESTADO_HPP

#include<iostream>
#include<string>

using namespace std;

class Estado{
    protected:
        string nome;
        string sigla;
    public:
        Estado(string nome, string sigla){
            this->nome = nome;
            this->sigla = sigla;
        }
        string toString(){
            string texto;
            texto = this->nome + " - " + this->sigla;
            return texto;
        }
        ~Estado(){}
};

#endif // ESTADO_HPP
