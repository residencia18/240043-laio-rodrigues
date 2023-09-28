#if !defined(PRODUTO_HPP)
#define PRODUTO_HPP

#include<iostream>
#include<string>

using namespace std;

class Produto{
    private:
        static int cont;
        string codigo;
        string nome;
        double preco;
        int qtd;
    public:
        Produto(){

        }
        Produto(string nome, double valor){
            this->nome = nome;
            this->preco = valor;
            cont++;
            this->codigo = 1000 + cont;
        }

        string getCodigo(){
            return this->codigo;
        }

        string getNome(){
            return this->nome;
        }

        double getPreco(){
            return this->preco;
        }

        void setQTD(int qtd){
            this->qtd = qtd;
        }

        int getQTD(){
            return this->qtd;
        }

        string toString(){
            string texto;
            texto = "#" + this->getCodigo() + " - " + this->getNome()
                    + " (R$" + to_string(this->getPreco()) + ") x " 
                    + to_string(this->getQTD());
            return texto;
        }

        ~Produto(){

        }
};

#endif // PRODUTO_HPP
