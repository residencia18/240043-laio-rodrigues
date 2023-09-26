#if !defined(PONTO_HPP)
#define PONTO_HPP

#include<iostream>
#include<vector>
#include<string>
#include<cmath>

using namespace std;

class Ponto
{
private:
    double x;
    double y;
public:
    Ponto();
    Ponto(double x, double y);
    double calcularDistancia();
    string dispPonto();
    void setCoordenadas(double x, double y);
    ~Ponto();
};

Ponto::Ponto(double x, double y){
    this->x = x;
    this->y = y;
}

Ponto::Ponto(){
}

void Ponto::setCoordenadas(double x, double y){
    this->x = x;
    this->y = y;
    return;
}

double Ponto::calcularDistancia(){
    return sqrt(pow(x,2) + pow(y,2));
}

string Ponto::dispPonto(){
    string ponto = "(";
    ponto.push_back(this->x);
    ponto += (", ");
    ponto.push_back(this->y);
    ponto += ")";
    return ponto;
}

Ponto::~Ponto(){
    // cout << "Ponto removido!" << endl;
}


#endif // PONTO_HPP
