#include"InteCliente.hpp"

InteCliente::InteCliente(Cliente* _cliente, vector<Veiculo*> _veiculos, vector<Aluguel*> _alugueis){
    this->cliente = _cliente;
    this->veiculos = _veiculos;
    this->alugueis = _alugueis;
}

float InteCliente::cotarAluguel(Veiculo* _veiculo, Data* _dt_inicio, Data* _dt_termino){
    for(Aluguel* a : _veiculo->getAlugueis()){
        if(!(_dt_inicio->diaEntre(a->getDt_termino()) < 0 || _dt_termino->diaEntre(a->getDt_inicio()) > 0)){
            return -1;
        }
    }

    return _dt_inicio->diaEntre(*_dt_termino) * _veiculo->getPrecoDiario();
}

Aluguel InteCliente::solicitaAluguel(Veiculo* _veiculo, Data* _dt_inicio, Data* _dt_termino){
    
}