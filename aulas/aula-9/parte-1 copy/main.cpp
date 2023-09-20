// Incluindo bibliotecas com funções que serão utilizadas

// Incluindo bibliotecas próprias com funções criadas para o devido objetivo proposto
#include "Cliente.hpp"
#include "Menu.hpp"

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