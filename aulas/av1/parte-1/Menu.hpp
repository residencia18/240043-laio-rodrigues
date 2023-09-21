#if !defined(MENU_HPP)
#define MENU_HPP

#include<iostream>
#include<string>
#include<vector>
#include "Data.hpp"
#include "Utilitarios.hpp"

using namespace std;

// Esta biblioteca foi criada para conter funções relacionadas à manipulação de menu

/*  A função dispMenuCliente imprime na tela do usuário as opções disponíveis relacionadas ao cliente
    e solicita que o usuário escolha uma, caso o usuário digite uma opção não disponível é solicitado
    novamente ao usuário que escolha uma opção disponível, ao informar uma das opções a função retorna
    a escolha do usuário.
*/
int dispMenuCliente(void){
    int op = 0;
    Data data = getDataAtual();

    limpaTela();
    cout << "********* LocaFINA S/A *********" << endl;
    cout << "\t" << data.toString() << endl;
    cout << endl << "Seja bem vindo(a)! O que deseja?" << endl << endl
        << "#1. Incluir um novo cliente" << endl
        << "#2. Excluir um cliente" << endl
        << "#3. Alterar (apenas por CPF)" << endl 
        << "#4. Listar todos os clientes" << endl 
        << "#5. Localizar um cliente (por CPF)" << endl 
        << "#0. Sair" << endl << endl
        << "> #";
    cin >> op;
    limpaBuffer();
        
    while (op < 0 || op > 5){
        limpaTela();
        cout << "********* LocaFINA S/A *********" << endl;
        cout << "\t" << data.toString() << endl;
        cout << endl << "Seja bem vindo(a)! O que deseja?" << endl << endl
            << "#1. Incluir um novo cliente" << endl
            << "#2. Excluir um cliente" << endl
            << "#3. Alterar (apenas por CPF)" << endl 
            << "#4. Listar todos os clientes" << endl 
            << "#5. Localizar um cliente (por CPF)" << endl 
            << "#0. Sair" << endl << endl
            << endl << "Digite uma opcao valida!" << endl
            << "> #";
        cin >> op;
        limpaBuffer();
    }
    
    return op;
}

/*  A função dispMenuVeiculo imprime na tela do usuário as opções disponíveis relacionadas ao veículo
    e solicita que o usuário escolha uma, caso o usuário digite uma opção não disponível é solicitado
    novamente ao usuário que escolha uma opção disponível, ao informar uma das opções a função retorna
    a escolha do usuário.
*/
int dispMenuVeiculo(void){
    int op = 0;
    Data data = getDataAtual();

    limpaTela();
    cout << "********* LocaFINA S/A *********" << endl;
    cout << "\t" << data.toString() << endl;
    cout << endl << "Seja bem vindo(a)! O que deseja?" << endl << endl
        << "#1. Incluir um novo veiculo" << endl
        << "#2. Excluir um veiculo" << endl
        << "#3. Alterar (apenas por Placa)" << endl 
        << "#4. Listar todos os veiculos" << endl 
        << "#5. Localizar um veiculo (por Placa)" << endl 
        << "#0. Sair" << endl << endl
        << "> #";
    cin >> op;
    limpaBuffer();
        
    while (op < 0 || op > 5){
        limpaTela();
        cout << "********* LocaFINA S/A *********" << endl;
        cout << "\t" << data.toString() << endl;
        cout << endl << "Seja bem vindo(a)! O que deseja?" << endl << endl
            << "#1. Incluir um novo veiculo" << endl
            << "#2. Excluir um veiculo" << endl
            << "#3. Alterar (apenas por Placa)" << endl 
            << "#4. Listar todos os veiculos" << endl 
            << "#5. Localizar um veiculo (por Placa)" << endl 
            << "#0. Sair" << endl << endl
            << endl << "Digite uma opcao valida!" << endl
            << "> #";
        cin >> op;
        limpaBuffer();
    }
    
    return op;
}

/*  A função dispAlteraVeiculo imprime na tela do usuário as opções disponíveis relacionadas a alteração de veículo
    e solicita que o usuário escolha uma, caso o usuário digite uma opção não disponível é solicitado
    novamente ao usuário que escolha uma opção disponível, ao informar uma das opções a função retorna
    a escolha do usuário.
*/
int dispAlteraVeiculo(void){
    int op = 0;

    limpaTela();
    cout << endl << "O que deseja alterar?" << endl << endl
        << "#1. Renavam" << endl
        << "#2. Data e hora de retirada" << endl
        << "#3. Data e hora de entrega" << endl
        << "#4. Loja de retirada" << endl 
        << "#0. Sair" << endl << endl
        << "> #";
    cin >> op;
    limpaBuffer();
        
    while (op < 0 || op > 4){
        limpaTela();
        cout << "********* LocaFINA S/A *********" << endl << endl << "\t";
        cout << endl << "O que deseja alterar?" << endl << endl
            << "#1. Renavam" << endl
            << "#2. Data e hora de retirada" << endl
            << "#3. Data e hora de entrega" << endl
            << "#4. Loja de retirada" << endl 
            << "#0. Sair" << endl << endl
            << endl << "Digite uma opcao valida!" << endl
            << "> #";
        cin >> op;
        limpaBuffer();
    }
    
    return op;
}

/*  A função dispAlteraCliente imprime na tela do usuário as opções disponíveis relacionadas a alteração de cliente
    e solicita que o usuário escolha uma, caso o usuário digite uma opção não disponível é solicitado
    novamente ao usuário que escolha uma opção disponível, ao informar uma das opções a função retorna
    a escolha do usuário.
*/
int dispAlteraCliente(){
    int op = 0;

    limpaTela();
    cout << endl << "O que deseja alterar?" << endl << endl
        << "#1. Nome" << endl
        << "#2. Data de nascimento" << endl
        << "#3. CNH" << endl 
        << "#0. Sair" << endl << endl
        << "> #";
    cin >> op;
    limpaBuffer();
        
    while (op < 0 || op > 3){
        limpaTela();
        cout << "********* LocaFINA S/A *********" << endl << endl << "\t";
        cout << endl << "O que deseja alterar?" << endl << endl
            << "#1. Nome" << endl
            << "#2. Data de nascimento" << endl
            << "#3. CNH" << endl 
            << "#0. Sair" << endl << endl
            << endl << "Digite uma opcao valida!" << endl
            << "> #";
        cin >> op;
        limpaBuffer();
    }
    
    return op;
}

int dispAlteraOcorrencia(void){
    int op = 0;

    limpaTela();
    cout << endl << "O que deseja alterar?" << endl << endl
        << "#1. Data e hora da ocorrencia" << endl
        << "#2. Numero da apolice" << endl
        << "#3. Descricao da ocorrencia" << endl 
        << "#0. Sair" << endl << endl
        << "> #";
    cin >> op;
    limpaBuffer();
        
    while (op < 0 || op > 3){
        limpaTela();
        cout << endl << "O que deseja alterar?" << endl << endl
            << "#1. Data e hora da ocorrencia" << endl
            << "#2. Numero da apolice" << endl
            << "#3. Descricao da ocorrencia" << endl 
            << "#0. Sair" << endl << endl
            << endl << "Digite uma opcao valida!" << endl
            << "> #";
        cin >> op;
        limpaBuffer();
    }
    
    return op;
}

int dispMenuOcorrencia(void){
    int op = 0;
    Data data = getDataAtual();

    limpaTela();
    cout << "********* LocaFINA S/A *********" << endl;
    cout << "\t" << data.toString() << endl;
    cout << endl << "Seja bem vindo(a)! O que deseja?" << endl << endl
        << "#1. Incluir uma nova ocorrencia" << endl
        << "#2. Excluir uma ocorrencia" << endl
        << "#3. Alterar uma ocorrencia" << endl 
        << "#4. Listar todas as ocorrencias por cliente" << endl 
        << "#5. Listar todas as ocorrencias por veiculo" << endl 
        << "#0. Sair" << endl << endl
        << "> #";
    cin >> op;
    limpaBuffer();
        
    while (op < 0 || op > 5){
        limpaTela();
        cout << "********* LocaFINA S/A *********" << endl;
        cout << "\t" << data.toString() << endl;
        cout << endl << "Seja bem vindo(a)! O que deseja?" << endl << endl
            << "#1. Incluir uma nova ocorrencia" << endl
            << "#2. Excluir uma ocorrencia" << endl
            << "#3. Alterar uma ocorrencia" << endl 
            << "#4. Listar todas as ocorrencias por cliente" << endl 
            << "#5. Listar todas as ocorrencias por veiculo" << endl 
            << "#0. Sair" << endl << endl 
            << endl << "Digite uma opcao valida!" << endl
            << "> #";
        cin >> op;
        limpaBuffer();
    }
    
    return op;
}

#endif // MENU_HPP
