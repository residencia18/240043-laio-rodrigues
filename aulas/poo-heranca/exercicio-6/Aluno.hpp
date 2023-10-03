#if !defined(ALUNO_HPP)
#define ALUNO_HPP

#include<iostream>
#include<string>

using namespace std;

class Aluno{
    protected:
        string nome;
        int id;
        
    public:
        Aluno(string nome, int id){
            this->id = id;
            this->nome = nome;
        }

        void setNome(string nome){
            this->nome = nome;
        }

        void setId(int id){
            this->id = id;
        }

        string getNome(){
            return this->nome;
        }

        int getId(){
            return this->id;
        }

        string toString(){
            string texto;
            texto = "#" + to_string(this->id) + " - " + this->nome;
            return texto;
        }

        ~Aluno(){}
};

#endif // ALUNO_HPP
