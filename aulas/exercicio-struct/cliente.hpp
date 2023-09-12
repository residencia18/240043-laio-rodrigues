#if !defined(CLIENTE_HPP)
#define CLIENTE_HPP

#include<iostream>
#include<string>
#include<vector>
#include "struct.hpp"
#include "data.hpp"

using namespace std;

void setCliente(vector<Cliente> *lista){
    Cliente cliente;
    cin.ignore();
    system("clear");
    cout << "********* Cadastro de Cliente *********" << endl << endl;
    cout << "Informe o nome do cliente: ";
    getline(cin, cliente.nome);
    cout << "Informe o CPF (Ex.: 123.456.789-10):";
    getline(cin, cliente.cpf);
    (*lista).push_back(cliente);
    system("clear");
    cout << "********* Cadastro de Cliente *********" << endl << endl;
    cout << "Cliente cadastrado com sucesso!" << endl;
    cin.ignore();
    getchar();
}

void dispCliente(Cliente cliente){
    system("clear");
    cout << "********* Dados do Cliente *********" << endl << endl;
    cout << "Nome completo: " << cliente.nome << endl
         << "CPF: " << cliente.cpf << endl;
    cin.ignore();
    getchar();
}

void dispCliente(Cliente cliente, int id){
    system("clear");
    cout << "********* Dados do Cliente #" << id
         << " *********" << endl << endl;
    cout << "Nome completo: " << cliente.nome << endl
         << "CPF: " << cliente.cpf << endl;
    cin.ignore();
    getchar();
}

int indexCliente(string CPF, vector<Cliente> lista){
    for (size_t i = 0; i < lista.size(); i++){
        if (lista[i].cpf == CPF){
            return i;
        }
    }
    system("clear");
    cout << "CPF informado nao encontrado!" << endl
         << "(Pressione qualquer tecla para continuar...)";
    cin.ignore();
    getchar();
    return -1;
}

void findCliente(vector<Cliente> lista){
    string cpf;
    
    system("clear");
    cin.ignore();
    cout << "Informe o CPF do cliente (Ex.: 123.456.789-10):" << endl << "> ";
    cin >> cpf;
    int idCliente = indexCliente(cpf, lista);
    if(idCliente < 0){
        return;
    }
    dispCliente(lista[idCliente]);
}

void deleteCliente(vector<Cliente> *lista){
    string cpf;
    char op;
    system("clear");
    cout << "Informe o CPF do cliente (Ex.: 123.456.789-10):" << endl << "> ";
    cin >> cpf;
    int idCliente = indexCliente(cpf, *lista);
    if(idCliente < 0){
        return;
    }
    dispCliente((*lista)[idCliente], idCliente+1);
    cout << "Deseja remover este cliente? ([S]im / [N]ao)" << endl << "> ";
    cin >> op;
    if(toupper(op) == 'S'){
        (*lista).erase((*lista).begin()+idCliente);
        cout << "Cliente removido com sucesso!";
    }
    return;
}

void listaClientes(vector<Cliente> lista){
    system("clear");
    for (int i = 0; i < lista.size(); i++){
        dispCliente(lista[i], i+1);
    }
    cin.ignore();
    getchar();
}

void alteraNome(vector<Cliente> *lista){
    string cpf, nome;
    
    system("clear");
    cin.ignore();
    cout << "Informe o CPF do cliente (Ex.: 123.456.789-10):" << endl << "> ";
    cin >> cpf;
    int idCliente = indexCliente(cpf, *lista);
    if(idCliente < 0){
        return;
    }
    dispCliente((*lista)[idCliente]);

    cout << "Informe o novo nome do cliente:" << endl << "> ";
    cin.ignore();
    getline(cin, nome);
    (*lista)[idCliente].nome = nome;
    
    cout << "Nome alterado com sucesso!";
        cin.ignore();
        getchar();   
}

void limpaTela(){
    #ifdef _WIN32
        system("cls");
    #else
        system("clear");
    #endif
}

#endif // CLIENTE_HPP
