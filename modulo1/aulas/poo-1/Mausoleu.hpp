#if !defined(MAUSOLEU_HPP)
#define MAUSOLEU_HPP

#include "Paciente.hpp"
#include <vector>

using namespace std;

class Mausoleu
{
private:
    string id;
    int qtd;
    vector<Paciente> defuntos;
public:
    Mausoleu(string id){
        this->id = id;
        this->qtd = 0;
    }

    void setLoc(string id){
        this->id = id;
        return;
    }

    string getLoc(){
        return this->id;
    }

    int getQTD(){
        return this->qtd;
    }

    void recepciona(Paciente novo){
        this->defuntos.push_back(novo);
        this->qtd = defuntos.size();
        return;
    }

    void listaPacientes(){
        for (int i = 0; i < this->qtd; i++){
            cout << this->defuntos[i].getNome() << endl;
        }
        return;
    }

    ~Mausoleu();
};

#endif