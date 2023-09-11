#if !defined(ESTRUTURAS_HPP)
#define ESTRUTURAS_HPP

#include<iostream>
#include<string>

using namespace std;

typedef struct T_data{
    int dia, mes, ano;
} Data;

typedef struct T_titulo_eleitor{
    string nome;
    Data dt_nasc;
    string num_inscr;
    string zona, secao;
    string municipio, UF;
    Data dt_emiss;
} Titulo_Eleitor;

#endif // ESTRUTURAS_HPP
