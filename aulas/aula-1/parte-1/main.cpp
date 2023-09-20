// Incluindo bibliotecas com funções que serão utilizadas
#include<iostream>
#include<string>
#include<vector>

// Incluindo bibliotecas próprias com funções criadas para o devido objetivo proposto
#include "Veiculo.hpp"
#include "Cliente.hpp"
#include "Locacao.hpp"
#include "Menu.hpp"
#include "Data.hpp"
#include "Utilitarios.hpp"

using namespace std;

int main(){
    int op; // Opção do usuário referente ao menu principal.
    vector<Cliente> listaClientes; // vetor que armazenará os clientes
    vector<Veiculo> listaVeiculos; // vetor que armazenará os veículos
    vector<Locacao> listaLocacao; // vetor que armazenará as alocações

    do{
        limpaTela();
        op = menuPrincipal();
        switch(op){
            case 0:
                cout << "Encerrando programa..." << endl;
                break;
            case 1:
                menuCliente(&listaClientes);
                break;
            case 2:
                menuVeiculos(&listaVeiculos);
                break;
            case 3:
                menuLocacao(&listaLocacao);
                break;
            case 4:
                menuOcorrencia(&listaLocacao);
                break;
            default:
                break;
        }
    }while(op != 0);
    return 0;
}