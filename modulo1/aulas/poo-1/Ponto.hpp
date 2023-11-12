#if !defined(PONTO_HPP)
#define PONTO_HPP

#include<iostream>
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
    Ponto(double x, double y){
        this->x = x;
        this->y = y;
    }

    void setX(double x){
        this->x = x;
        return;
    }

    double getX(){
        return this->x;
    }

    void setY(double y){
        this->y = y;
        return;
    }

    double getY(){
        return this->y;
    }

    double distOrigem(){
        return sqrt(pow(x,2) + pow(y,2));
    }

    double distTo(Ponto ponto){
        return sqrt(pow((this->x - ponto.x),2) + pow((this->y - ponto.y),2));
    }

    string dispPonto(){
        string ponto = "(";
        ponto.push_back(this->x);
        ponto += (", ");
        ponto.push_back(this->y);
        ponto += ")";
        return ponto;
    }

    void setCoordenadas(double x, double y){
        this->x = x;
        this->y = y;
        return;
    }

    bool operator==(Ponto p){
        return (p.getX() == this->getX() && p.getY() == this->getY());
    }

    ~Ponto();
};

#endif // PONTO_HPP
