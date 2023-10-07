#if !defined(RETANGULO_HPP)
#define RETANGULO_HPP

#include"Forma.hpp"

class Retangulo: public Forma{
    private:
        float base;
        float altura;
        
    public:
        Retangulo(float base, float altura){
            this->altura = altura;
            this->base = base;
        }

        void calcularArea() override {
            this->area = this->base*this->altura;
        }

        void calcularPerimetro() override {
            this->perimetro = this->base*2 + this->altura*2;
        }

        string toString(){
            string texto;
            texto = "Retangulo com area de " + to_string(this->area)
                    + ", e perimetro de " + to_string(this->perimetro);
            return texto;
        }

        ~Retangulo(){}
};


#endif // RETANGULO_HPP
