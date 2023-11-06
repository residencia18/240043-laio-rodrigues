#if !defined(FORMA_HPP)
#define FORMA_HPP

#include<iostream>

using namespace std;

class Forma{
    protected:
        float area;
        float perimetro;
        
    public:
        Forma(){}

        virtual void calcularArea(){
            this->area = -1;
        }

        virtual void calcularPerimetro(){
            this->perimetro = -1;
        }

        virtual string toString(){
            return "Figura indefinida!";
        }
        
        ~Forma(){}
};


#endif // FORMA_HPP
