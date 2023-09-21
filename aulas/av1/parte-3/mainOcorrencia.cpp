// Incluindo bibliotecas com funções que serão utilizadas
#include<iostream>
#include<string>
#include<vector>

// Incluindo bibliotecas próprias com funções criadas para o devido objetivo proposto
#include "../parte-1/Veiculo.hpp"
#include "../parte-1/Data.hpp"
#include "../parte-1/Menu.hpp"
#include "../parte-1/Cliente.hpp"
#include "../parte-1/Utilitarios.hpp"
#include "Ocorrencia.hpp"

using namespace std;

int main(){
    int op; // variável que irá receber a opção de escolha do usuário
    vector<Locacao> lista; // vetor que armazenará os clientes

    do{
        op = dispMenuOcorrencia(); // chama o menu de clientes da biblioteca Menu e armazena a escolha do usuário
        switch (op){ // se o usuário escolher uma opção dentre as diponíveis abaixo, será chamada a função correspondente da biblioteca Cliente
        case 1:
            setOcorrencia(&lista);
            break;
        case 2:
            deleteOcorrencia(&lista);
            break;
        case 3:
            alteraOcorrencia(&lista);
            break;
        case 4:
            listaOcorrenciaCliente(lista);
            break;
        case 5:
            listaOcorrenciaVeiculo(lista);
            break;
        default:
            break;
        }
    } while (op != 0); // o programa irá encerrar caso o usuário escolha sair, selecionando 0
    
    return 0;
}