#include"Retangulo.hpp"
#include"Circulo.hpp"
#include<vector>

int main(){
    vector<Forma*> formas;

    Retangulo r1(2, 5);
    Retangulo r2(1.45, 3.79);
    Circulo c1(2.23);
    Circulo c2(3);

    formas.push_back(&r1);
    formas.push_back(&r2);
    formas.push_back(&c1);
    formas.push_back(&c2);

    for(Forma* f : formas){
        f->calcularArea();
        f->calcularPerimetro();
        cout << f->toString() << endl;
    }
}