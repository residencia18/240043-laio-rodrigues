#if !defined(UTILITARIOS_HPP)
#define UTILITARIOS_HPP

#include<iostream>
#include<vector>
#include<string>

using namespace std;

// Esta biblioteca foi criada para conter funções uteis para o funcionamento do código


// A função limpaTela identifica se o sistema operacional é linux ou windows e executa a função system com o parâmetro correspondente para limpar o terminal.
void limpaTela(){
    #ifdef _WIN32
        system("cls");
    #else
        system("clear");
    #endif
}

// A função limpaBuffer executa uma limpeza no buffer, ignorando quaisquer resíduos que tenham permanecidos após uma captura da entrada de um usuário.
void limpaBuffer(){
    int ch;
    while ( ( ch = fgetc ( stdin ) ) != EOF && ch != '\n' );
}

#endif