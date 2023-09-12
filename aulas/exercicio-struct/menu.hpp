#if !defined(MENU_HPP)
#define MENU_HPP

#include<iostream>
#include<string>
#include<vector>
#include "struct.hpp"

using namespace std;

int dispMenu(void){
    int op = 0;

    system("clear");
    cout << "********* Mecânica Resitic *********" << endl << endl
        << "Seja bem vindo(a)! O que deseja?" << endl << endl
        << "#1. Adicionar novo cliente" << endl
        << "#2. Encontrar um cliente" << endl
        << "#3. Excluir um cliente" << endl 
        << "#4. Listar todos os clientes" << endl 
        << "#0. Encerrar" << endl << endl
        << "> #";
    cin >> op;
        
    while (op < 0 || op > 4){
        system("clear");
        cout << "********* Mecânica Resitic *********" << endl << endl
            << "Seja bem vindo(a)! O que deseja?" << endl << endl
            << "#1. Adicionar novo cliente" << endl
            << "#2. Encontrar um cliente" << endl
            << "#3. Excluir um cliente" << endl 
            << "#4. Listar todos os clientes" << endl 
            << "#0. Encerrar" << endl << endl
            << endl << "Digite uma opcao valida!" << endl
            << "> #";
        cin >> op;
    }
    
    return op;
}

#endif // MENU_HPP
