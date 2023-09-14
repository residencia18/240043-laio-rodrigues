#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include "Ponto.hpp"

using namespace std;

int main(){
    Ponto p1(3,4);
    double distancia = p1.calcularDistancia();

    cout << "A distancia do ponto " << p1.dispPonto();

    return 0;
}