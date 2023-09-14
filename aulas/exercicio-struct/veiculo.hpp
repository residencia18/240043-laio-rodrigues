#if !defined(VEICULO_HPP)
#define VEICULO_HPP

#include<iostream>
#include<string>
#include <vector>
#include "data.hpp"

using namespace std;

typedef struct T_veiculo{
    string marca;
    string cor;
    string placa;
    Data ult_revisao{
        ult_revisao.dia = 00,
        ult_revisao.mes = 00,
        ult_revisao.ano = 00
    };
    Data prox_revisao = ;
    string situacao = "Nao avaliado";

    void dispDadosVeiculo(){
        system("clear");
        cout << "********* Dados do Veiculo *********" << endl << endl;
        cout << "Marca: " << this->marca << endl
            << "Placa: " << this->placa << endl
            << "Cor: " << this->cor << endl;
        cin.ignore();
        getchar();
    }

    void dispListaVeiculos(int id){
        cout << endl << "********* Dados do Veiculo #" << id
            << " *********" << endl << endl;
        cout << "Marca: " << this->marca << endl
            << "Placa: " << this->placa << endl
            << "Cor: " << this->cor << endl;
    }

} Veiculo;

void setVeiculo(vector<Veiculo> *lista){
    Veiculo veiculo;
    cin.ignore();
    system("clear");
    cout << "********* Cadastro de Veiculo *********" << endl << endl;
    cout << "Informe a marca do veiculo: ";
    getline(cin, veiculo.marca);
    cout << "Informe a placa do veiculo:";
    getline(cin, veiculo.placa);
    cout << "Informe a cor do veiculo:";
    getline(cin, veiculo.cor);
    (*lista).push_back(veiculo);
    system("clear");
    cout << "********* Cadastro de Veiculo *********" << endl << endl;
    cout << "Veiculo cadastrado com sucesso!" << endl;
    getchar();
}



#endif
