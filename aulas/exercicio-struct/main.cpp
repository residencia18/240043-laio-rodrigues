#include<iostream>
#include<string>
#include<vector>
#include "veiculo.hpp"
#include "data.hpp"
#include "menu.hpp"
#include "cliente.hpp"

using namespace std;

int main(){
    int op;
    vector<Cliente> lista;
    Cliente cliente;

    do{
        op = dispMenu();
        switch (op){
        case 1:
            setCliente(&lista);
            break;
        case 2:
            findCliente(lista);
            break;
        case 3:
            deleteCliente(&lista);
            break;
        case 4:
            listaClientes(lista);
            break;
        case 5:
            alteraNome(&lista);
            break;
        case 6:

            break;
        default:
            break;
        }
    } while (op != 0);
    



    return 0;
}