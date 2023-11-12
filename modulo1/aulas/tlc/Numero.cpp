#include "Numero.hpp"

Numero::Numero(int tam){
    this->tam = tam;
}

float Numero::getNumero(float i) {
    return this->numeros[i];
}

void Numero::setNumero(float _num) {
    this->numeros.push_back(_num);
}

void Numero::preencherVetor(int min, int max) {
    srand(time(NULL));
    for(int i = 0; i < this->tam; i++){
        this->setNumero(rand()%max+min);
    }
}

void Numero::TLCpreencherVetor(int min, int max) {
    float soma = 0;
    srand(time(NULL));
    for(int i = 0; i < this->tam; i++){
        for (int i = 0; i < 100; i++){
            soma += rand()%max+min;
        }
        this->setNumero(soma/100);
        soma = 0;
    }
}

float Numero::media(){
    float soma = 0;
    for(int i = 0; i < this->tam; i++){
        soma += this->getNumero(i);
    }
    return soma/this->tam;
}

float Numero::somatorio(){
    float soma = 0;
    for(int i = 0; i < this->tam; i++){
        soma += this->getNumero(i);
    }
    return soma;
}

float Numero::variacia(){
    float soma = 0;
    for(int i = 0; i < this->tam; i++){
        soma += pow(this->getNumero(i)-media(), 2);
    }
    return soma/this->tam;
}

float Numero::desvio(){
    return sqrt(variacia());
}



