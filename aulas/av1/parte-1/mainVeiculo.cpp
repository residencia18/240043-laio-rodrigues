// Incluindo bibliotecas com funções que serão utilizadas
#include<iostream>
#include<string>
#include<vector>

// Incluindo bibliotecas próprias com funções criadas para o devido objetivo proposto
#include "Veiculo.hpp"
#include "Data.hpp"
#include "Menu.hpp"
#include "Cliente.hpp"
#include "Utilitarios.hpp"

using namespace std;

int main(){
    int op; // variável que irá receber a opção de escolha do usuário
    vector<Veiculo> lista; // vetor que armazenará os veículos

    do{
        op = dispMenuVeiculo(); // chama o menu de veiculos da biblioteca Menu e armazena a escolha do usuário
        switch (op){ // se o usuário escolher uma opção dentre as diponíveis abaixo, será chamada a função correspondente da biblioteca Veiculo
        case 1:
            setVeiculo(&lista);
            break;
        case 2:
            deleteVeiculo(&lista);
            break;
        case 3:
            alteraVeiculo(&lista);
            break;
        case 4:
            listaVeiculos(lista);
            break;
        case 5:
            buscaVeiculo(lista);
            break;
        default:
            break;
        }
    } while (op != 0); // o programa irá encerrar caso o usuário escolha sair, selecionando 0
    
    return 0;
}