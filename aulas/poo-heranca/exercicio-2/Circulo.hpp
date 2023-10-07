#if !defined(CIRCULO_HPP)
#define CIRCULO_HPP

#include"Forma.hpp"
#include<cmath>

class Circulo: public Forma{
    private:
        float raio;

    public:
        Circulo(float raio){
            this->raio = raio;
        }

        void calcularArea() override {
            this->area = pow(this->raio, 2) * 3.14152;
        }

        void calcularPerimetro() override {
            this->perimetro = 2 * 3.14152 * this->raio;
        }

        string toString(){
            string texto;
            texto = "Circulo com area de " + to_string(this->area)
                    + ", e perimetro de " + to_string(this->perimetro);
            return texto;
        }

        ~Circulo(){}
};


#endif // RETANGULO_HPP
