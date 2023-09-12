#if !defined(DATA_HPP)
#define DATA_HPP

#include<iostream>
#include<string>
#include "struct.hpp"

using namespace std;

void getData(Data *nova_data){
    cout << "Digite o dia: ";
    cin >> nova_data->dia;
    cout << "Digite o mes: ";
    cin >> nova_data->mes;
    cout << "Digite o ano: ";
    cin >> nova_data->ano;
    return;
}

void dispData(Data mostra_data){
    string data = "";

    if (mostra_data.dia < 10)
        data += "0";
    
    data += to_string(mostra_data.dia) + "/";
    if (mostra_data.mes < 10)
        data += "0";

    data += to_string(mostra_data.mes) + "/";
    data += to_string(mostra_data.ano);

    cout << data << endl;
}

int anosCompletos(Data fim, Data inicio){
    int x = fim.ano - inicio.ano;
    if(fim.mes < inicio.mes)
        x--;
    else if(fim.mes == inicio.mes && fim.dia < inicio.dia)
        x--;
    return x;
}

#endif // DATA_HPP
