#if !defined(ANIMAL_HPP)
#define ANIMAL_HPP

#include<string>
#include<iostream>

using namespace std;

class Animal {
    protected:
        string nome;
        int idade;
        
    public:
        Animal(string nome, int idade){
            this->nome = nome;
            this->idade = idade;
        }

        virtual void fazerSom(){
            cout << "Som indefinido" << endl;
        }

        ~Animal(){}
};


#endif // ANIMAL_HPP
