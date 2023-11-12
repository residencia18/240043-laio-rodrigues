#include"Cliente.hpp"

Cliente::Cliente(string _cpf, string _nome, string _endereco, string _telefone, string _habilitacao): Usuario(_cpf, _nome, _endereco, _telefone){
            this->habilitacao = _habilitacao;
}

void Cliente::setHabilitacao(string _habilitacao){
    this->habilitacao = _habilitacao;
}

string Cliente::getHabilitacao(){
    return this->habilitacao;
}

void Cliente::addAluguel(Aluguel* novo){
    this->historicoAlugueis.push_back(novo);
}

vector<Aluguel*> Cliente::getHistoricoAlugueis(){
    return this->historicoAlugueis;
}