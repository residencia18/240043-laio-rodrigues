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
#include "../parte-3/Ocorrencia.hpp"

using namespace std;

int main(){
    int op; // variável que irá receber a opção de escolha do usuário
    vector<Cliente> lista; // vetor que armazenará os clientes

    do{
        op = dispMenuCliente(); // chama o menu de clientes da biblioteca Menu e armazena a escolha do usuário
        switch (op){ // se o usuário escolher uma opção dentre as diponíveis abaixo, será chamada a função correspondente da biblioteca Cliente
        case 1:
            setCliente(&lista);
            break;
        case 2:
            deleteCliente(&lista);
            break;
        case 3:
            alteraCliente(&lista);
            break;
        case 4:
            listaClientes(lista);
            break;
        case 5:
            buscaCliente(lista);
            break;
        default:
            break;
        }
    } while (op != 0); // o programa irá encerrar caso o usuário escolha sair, selecionando 0
    
    return 0;
}