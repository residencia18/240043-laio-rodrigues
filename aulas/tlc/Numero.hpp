#if !defined(NUMERO_HPP)
#define NUMERO_HPP

#include<iostream>
#include<string>
#include<vector>
#include<ctime>
#include<cmath>

using namespace std;

class Numero{
    private:
        vector<float> numeros;
        int tam;
    public:
        Numero(int);
        ~Numero(){}
        float getNumero(float);
        void setNumero(float);
        void preencherVetor(int, int);
        void TLCpreencherVetor(int, int);
        float media();
        float somatorio();
        float variacia();
        float desvio();

};  

#endif // NUMERO_HPP
