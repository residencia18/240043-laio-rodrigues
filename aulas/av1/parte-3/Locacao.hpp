#if !defined(LOCACAO_HPP)
#define LOCACAO_HPP

#include<iostream>
#include<vector>
#include<string>
#include "../parte-1/Data.hpp"
#include "../parte-1/Cliente.hpp"
#include "../parte-1/Veiculo.hpp"


using namespace std;

typedef struct T_locacao{
    char Realizada;
    Data Dt_HoraRetirada;
    Data Dt_HoraEntrega;
    Cliente cliente;
    Veiculo veiculo;
    Ocorrencia ocorrencia;
}Locacao;

#endif