#if !defined(CIDADE_HPP)
#define CIDADE_HPP

#include"Estado.hpp"

class Cidade{
    private:
        string nome;
        Estado *estado;
    public:
        Cidade(string nome, Estado *estado){
            this->nome = nome;
            this->estado = estado;
        }
        string toString(){
            string texto;
            texto = this->nome + ", " + this->estado->toString();
            return texto;
        }
        ~Cidade(){}
};


#endif // CIDADE_HPP
