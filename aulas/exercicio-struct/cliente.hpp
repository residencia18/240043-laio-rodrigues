#if !defined(CLIENTE_HPP)
#define CLIENTE_HPP

#include<iostream>
#include<string>
#include<vector>
#include "struct.hpp"
#include "data.hpp"

using namespace std;

void setCliente(Cliente *cliente){
    cin.ignore();
    system("cls");
    cout << "********* Cadastro de Cliente *********" << endl << endl;
    cout << "Informe o nome do cliente: ";
    getline(cin, cliente->nome);
    cout << "Informe o CPF (Ex.: 123.456.789-10):";
    getline(cin, cliente->cpf);

    system("cls");
    cout << "********* Cadastro de Cliente *********" << endl << endl;
    cout << "Cliente cadastrado com sucesso!" << endl;
    system("pause"); 
}

void dispCliente(Cliente cliente){
    system("cls");
    cout << "********* Dados do Cliente *********" << endl << endl;
    cout << "Nome completo: " << cliente.nome << endl
         << "CPF: " << cliente.cpf << endl;
    system("pause");
}

#endif // CLIENTE_HPP
