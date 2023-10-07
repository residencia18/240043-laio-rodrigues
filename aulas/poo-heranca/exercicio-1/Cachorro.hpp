#if !defined(CACHORRO_HPP)
#define CACHORRO_HPP

#include"Animal.hpp"

class Cachorro: public Animal{
    public:
        Cachorro(string nome, int idade): Animal(nome, idade){}

        void fazerSom() override {
            cout << "woof woof" << endl;
        }
        
        ~Cachorro(){}
};


#endif // CACHORRO_HPP
