#if !defined(PRODUTO_HPP)
#define PRODUTO_HPP

#include<iostream>
#include<string>
#include<iomanip>

using namespace std;

class Produto{
    private:
        static int cont;
        int codigo;
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
            this->codigo = cont;
        }

        int getCodigo(){
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
            double preco = this->getPreco();

            stringstream stream;
            stream << fixed << setprecision(2) << preco;
            string precoFormatado = stream.str();

            texto = "#" + to_string(this->getCodigo()) + " - " + this->getNome()
                + " (R$" + precoFormatado + ") x " + to_string(this->getQTD());
            return texto;
        }

        ~Produto(){

        }
};

#endif // PRODUTO_HPP
