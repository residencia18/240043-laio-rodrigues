#if !defined(LOCACAO_HPP)
#define LOCACAO_HPP

#include <iostream>
#include <string>
#include <vector>
#include "../parte-1/Data.hpp"
#include "../parte-1/Utilitarios.hpp"
#include "Ocorrencia.hpp"

using namespace std;

// Esta biblioteca foi criada para conter funções relacionadas à manipulação das Alocações

// Definiu-se a struct a Alocação contendo os atributos necessários a ela, além de algumas funções próprias da struct.
typedef struct T_locacao{
    char Realizada = 'n';
    char Entrega = 'n';
    Data Dt_HoraRetirada;
    Data Dt_HoraEntrega;
    Cliente cliente;
    Veiculo veiculo;
    Ocorrencia ocorrencia;

    void dispDadosOcorrencia(){
        limpaTela();
        cout << "********* Dados da Locacao *********" << endl << endl
            << "Data da retirada: " << this->Dt_HoraRetirada.getHora()
            << " " << this->Dt_HoraRetirada.toString() << endl
            << "Situacao da retirada: " << this->getRetirada() << endl << endl
            << "Data da entrega: " << this->Dt_HoraEntrega.getHora()
            << " " << this->Dt_HoraEntrega.toString() << endl
            << "Situacao da entrega: " << this->getEntrega() << endl << endl
            << "=========     Veiculo      =========" << endl
            << "Placa do veiculo: " << this->veiculo.Placa << endl
            << "Numero do renavan: " << this->veiculo.Renavan << endl
            << "Loja de retirada: " << this->veiculo.Loja_Retirada << endl << endl
            << "=========     Cliente      =========" << endl
            << "Nome do cliente: " << this->cliente.Nome << endl
            << "CPF: " << this->cliente.getCPF() << endl
            << "CNH: " << this->cliente.CNH << endl;
        getchar();
    }

    void dispListaOcorrencia(int id){
        cout << endl << "******* Dados da Ocorrencia #" << id << " ********" << endl << endl
            << "Data da retirada: " << this->Dt_HoraRetirada.getHora()
            << " " << this->Dt_HoraRetirada.toString() << endl
            << "Situacao da retirada: " << this->getRetirada() << endl << endl
            << "Data da entrega: " << this->Dt_HoraEntrega.getHora()
            << " " << this->Dt_HoraEntrega.toString() << endl
            << "Situacao da entrega: " << this->getEntrega() << endl << endl
            << "=========     Veiculo      =========" << endl
            << "Placa do veiculo: " << this->veiculo.Placa << endl
            << "Numero do renavan: " << this->veiculo.Renavan << endl
            << "Loja de retirada: " << this->veiculo.Loja_Retirada << endl << endl
            << "=========     Cliente      =========" << endl
            << "Nome do cliente: " << this->cliente.Nome << endl
            << "CPF: " << this->cliente.getCPF() << endl
            << "CNH: " << this->cliente.CNH << endl;
    }

    string getRetirada(){
        return (this->Realizada == 's') ? "REALIZADA" : "NAO REALIZADA";
    }

    string getEntrega(){
        return (this->Entrega == 's') ? "REALIZADA" : "NAO REALIZADA";
    }

} Locacao; // optou-se pela utilização de um typedef para definir o nome da struct como Alocacao

Cliente addCliente(string cpf, vector<Cliente> lista){
    int id = indexCliente(cpf, lista);
    return lista[id];
}

Veiculo addVeiculo(string placa, vector<Veiculo> lista){
    int id = indexVeiculo(placa, lista);
    return lista[id];
}

void setLocacao(vector<Locacao> *lista, vector<Cliente> clientes, vector<Veiculo> veiculos){
    string cpf, placa;
    Locacao novo;
    char op;
    
    limpaTela();
    cout << "********* Cadastro de Locacao *********" << endl << endl;
    cout << "Informe o CPF do cliente: ";
    getline(cin, cpf);
    while((cpf.size() > 11 || cpf.size() < 9) || !hasCPF(cpf, clientes)){
        cout << "CPF invalido ou nao cadastrado!" << endl;
        cout << "Deseja tentar novamente? ([S]im / [N]ao)" << endl << ">";
        cin >> op;
        limpaBuffer();
        if(toupper(op) != 'S')
            return;
        limpaTela();
        cout << "********* Cadastro de Locacao *********" << endl << endl;
        cout << "Informe o CPF do cliente: ";
        getline(cin, cpf);
    }

    limpaTela();
    cout << "********* Cadastro de Locacao *********" << endl << endl;
    cout << "Informe a placa do veiculo: ";
    getline(cin, placa);
    while(!hasPlaca(placa, veiculos)){
        cout << "Placa nao cadastrada no sistema!" << endl;
        cout << "Deseja tentar novamente? ([S]im / [N]ao)" << endl << ">";
        cin >> op;
        limpaBuffer();
        if(toupper(op) != 'S')
            return;
        limpaTela();
        cout << "********* Cadastro de Locacao *********" << endl << endl;
        cout << "Informe a placa do veiculo: ";
        getline(cin, placa);
    }

    novo.cliente = addCliente(cpf, clientes);
    novo.veiculo = addVeiculo(placa, veiculos);

    limpaTela();
    cout << "********* Cadastro de Locacao *********" << endl << endl;
    cout << "Informe a data da retirada:" << endl;
    setHora(&novo.Dt_HoraRetirada);
    while(!novo.Dt_HoraRetirada.isHora()){ // Caso o usuário informe uma hora inválida, será solicitado um novo horario
        cout << "Informe uma hora valida:" << endl;
        setHora(&novo.Dt_HoraRetirada);
    }
    setData(&novo.Dt_HoraRetirada);
    while(!novo.Dt_HoraRetirada.isData()){ // Caso o usuário informe uma data inválida, será solicitado uma nova data
        cout << "Informe uma data valida:" << endl;
        setData(&novo.Dt_HoraRetirada);
    }

    do{
        limpaTela();
        cout << "********* Cadastro de Locacao *********" << endl << endl;
        cout << "A retirada ja foi realizada? ([S]im / [N]ao)" << endl;
        cin >> op;
        limpaBuffer();
    } while (tolower(op) != 's' && tolower(op) != 'n');
    
    novo.Realizada = op;

    (*lista).push_back(novo);
    cout << "********* Cadastro de Locacao *********" << endl << endl;
    cout << "Locacao cadastrada com sucesso!" << endl;
    getchar();
}



#endif