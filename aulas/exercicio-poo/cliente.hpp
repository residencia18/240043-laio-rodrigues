#if !defined(CLIENTE_HPP)
#define CLIENTE_HPP

#include<iostream>
#include<string>
#include <vector>

using namespace std;

class Cliente
{
private:
    string nome;
    string sobrenome;
    string CPF;
public:
    Cliente(string nome, string sobrenome, string CPF);
    void setNome(string nome, string sobrenome);
    string getNome();
    
    ~Cliente();
};

Cliente::Cliente(string nome, string sobrenome, string CPF){
    this->nome = nome;
    this->sobrenome = sobrenome;
    this->CPF = CPF;
}

Cliente::~Cliente(){
    cout << "Cliente removido com sucesso!" << endl;
}

void setCliente(vector<Cliente> *lista){
    string nome, sobrenome, cpf;
    cin.ignore();
    system("clear");
    cout << "********* Cadastro de Cliente *********" << endl << endl;
    cout << "Informe o nome do cliente: ";
    cin >> nome;
    cin.ignore();
    getline(cin, sobrenome);
    cout << "Informe o CPF (Ex.: 123.456.789-10):";
    getline(cin, cpf);
    Cliente cliente = new Cliente(nome, sobrenome, cpf);
    (*lista).push_back(cliente);
    system("clear");
    cout << "********* Cadastro de Cliente *********" << endl << endl;
    cout << "Cliente cadastrado com sucesso!" << endl;
    getchar();
}

#endif