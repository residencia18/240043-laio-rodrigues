#include"Menu.hpp"

void Menu::limpaTela(){
    #ifdef _WIN32
        system("cls");
    #elif linux
        system("clear");
    #endif
}

void Menu::limpaBuffer(){
    while (cin.get() != '\n') {
        continue;
    }
}

void Menu::pausaTela(){
    cout << "Pressione Enter para continuar...";
    cin.get();
}

void Menu::success(string msg){
    limpaTela();
    cout << "*************** XWITTER ***************" << endl;
    cout << "********* SUCESSO NA OPERACAO *********" << endl << end;
    cout << msg << endl << endl;
    cout << "*************** XWITTER ***************" << endl;
    pausaTela();
}

void Menu::error(string msg){
    limpaTela();
    cout << "*************** XWITTER ***************" << endl;
    cout << "********* ERRO NA OPERACAO *********" << endl << end;
    cout << msg << endl << endl;
    cout << "*************** XWITTER ***************" << endl;
    pausaTela();
}