#if !defined(POLIGONO_HPP)
#define POLIGONO_HPP

#include "Ponto.hpp"
#include<vector>

using namespace std;

class Poligono{
private:
    vector<Ponto> pontos;
public:
    Poligono();
    
    void setPontos(Ponto novo){
        this->pontos.push_back(novo);
        return;
    }
    
    Poligono operator=(Poligono poli){
        Poligono novo;
        for(Ponto p : poli.pontos){
            novo.pontos.push_back(p);
        }
        return novo;
    }

    bool operator==(Poligono poli){
        Ponto p1, p2;
        vector<Ponto>::iterator it2;
        for(int i; i < poli.pontos.size(); i++){
            
        }
    }

    ~Poligono();
};

#endif