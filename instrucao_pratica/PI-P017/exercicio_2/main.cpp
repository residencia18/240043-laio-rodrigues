#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include "Ponto.hpp"

using namespace std;

int main(){
    Ponto pontos[3];
    pontos[0].setCoordenadas(2, 2);
    pontos[1].setCoordenadas(-1, 5);
    pontos[2].setCoordenadas(0, 0);
    
    for (int i = 0; i < 3; ++i) {
    double distancia = pontos[i].calcularDistancia();
    cout << "Distância do ponto " << i + 1 << " até a origem: " << distancia << endl;
    }

    return 0;
}