#include"Funcionario.hpp"

void Funcionario::addAluguel(Aluguel* novo){
    this->historicoAlugueis.push_back(novo);
}

vector<Aluguel*> Funcionario::getHistoricoAlugueis(){
    return this->historicoAlugueis;
}