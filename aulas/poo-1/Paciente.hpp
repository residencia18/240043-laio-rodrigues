#if !defined(PACIENTE_HPP)
#define PACIENTE_HPP

#include "data.hpp"

using namespace std;

class Paciente
{
private:
    string nome;
    Data obito;
    string id_mausoleu;
public:
    Paciente();
    Paciente(string nome, Data obito, string id_mausoleu){
        this->nome = nome;
        this->obito = obito;
        this->id_mausoleu = id_mausoleu;
    }

    void setNome(string nome){
        this->nome = nome;
        return;
    }

    string getNome(){
        return this->nome;
    }

    void setObito(Data obito){
        this->obito = obito;
        return;
    }

    string getData(){
        return this->obito.toString();
    }

    void setIdMausoleu(string id_mausoleu){
        this->id_mausoleu = id_mausoleu;
        return;
    }

    string getIdMausoleu(){
        return this->id_mausoleu;
    }


    ~Paciente(){

    }
};

#endif

