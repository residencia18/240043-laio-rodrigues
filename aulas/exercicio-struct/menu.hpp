#if !defined(MENU_HPP)
#define MENU_HPP

#include<iostream>
#include<string>
#include<vector>
#include "struct.hpp"

using namespace std;

int dispMenu(void){
    int op = 0;

    do{
        system("cls");
        cout << "********* Mecânica Resitic *********" << endl << endl
            << "Seja bem vindo(a)! O que deseja?" << endl << endl
            << "#1. Adicionar novo cliente" << endl
            << "#2. Encontrar um cliente" << endl
            << "#3. Excluir um cliente" << endl 
            << "> #";
        if (/* condition */){
            /* code */
        }
        cin >> op;
        
    } while (op != 1 && op != 2 && op != 3);
    

}

#endif // MENU_HPP
