#if !defined(CIDADE_HPP)
#define CIDADE_HPP

#include<iostream>
#include<string>

using namespace std;

class Cidade{
    private:
        string nome;
    public:
        Cidade(string nome){
            this->nome = nome;
        }
        string toString(){
            return this->nome;
        }
        ~Cidade(){}
};


#endif // CIDADE_HPP
