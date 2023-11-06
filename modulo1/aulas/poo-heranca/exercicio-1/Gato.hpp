#if !defined(GATO_HPP)
#define GATO_HPP

#include"Animal.hpp"

class Gato: public Animal{
    public:
        Gato(string nome, int idade): Animal(nome, idade){}

        void fazerSom() override {
            cout << "MIAU CARALHOOOO" << endl;
        }
        
        ~Gato(){}
};


#endif // GATO_HPP
