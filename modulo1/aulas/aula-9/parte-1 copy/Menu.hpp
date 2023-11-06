#if !defined(MENU_HPP)
#define MENU_HPP

// Incluindo bibliotecas próprias com funções criadas para o devido objetivo proposto
#include "Veiculo.hpp"
#include "Locacao.hpp"
// #include "Data.hpp"
#include "Cliente.hpp"
#include "Utilitarios.hpp"

using namespace std;

// Esta biblioteca foi criada para conter funções relacionadas à manipulação de menu

/*  A função dispMenuCliente imprime na tela do usuário as opções disponíveis relacionadas ao cliente
    e solicita que o usuário escolha uma, caso o usuário digite uma opção não disponível é solicitado
    novamente ao usuário que escolha uma opção disponível, ao informar uma das opções a função retorna
    a escolha do usuário.
*/
int dispMenuCliente(){
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
int dispMenuVeiculo(){
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


/*  A função dispAlteraCliente imprime na tela do usuário as opções disponíveis relacionadas a alteração de cliente
    e solicita que o usuário escolha uma, caso o usuário digite uma opção não disponível é solicitado
    novamente ao usuário que escolha uma opção disponível, ao informar uma das opções a função retorna
    a escolha do usuário.
*/


/*
    Função para o menu de clientes
*/
void menuCliente(vector<Cliente> *lista){
    int op; // variável que irá receber a opção de escolha do usuário
    
    do{
        op = dispMenuCliente(); // chama o menu de clientes da biblioteca Menu e armazena a escolha do usuário
        switch (op){ // se o usuário escolher uma opção dentre as diponíveis abaixo, será chamada a função correspondente da biblioteca Cliente
            case 1:
                setCliente(lista);
                break;
            case 2:
                deleteCliente(lista);
                break;
            case 3:
                alteraCliente(lista);
                break;
            case 4:
                listaClientes(*lista);
                break;
            case 5:
                buscaCliente(*lista);
                break;
            default:
                break;
        }
    } while (op != 0); // o programa irá encerrar caso o usuário escolha sair, selecionando 0
}

/*
    Função para o menu de veiculos
*/
void menuVeiculos(vector<Veiculo> *lista){
    int op; // variável que irá receber a opção de escolha do usuário

    do{
        op = dispMenuVeiculo(); // chama o menu de veiculos da biblioteca Menu e armazena a escolha do usuário
        switch (op){ // se o usuário escolher uma opção dentre as diponíveis abaixo, será chamada a função correspondente da biblioteca Veiculo
            case 1:
                setVeiculo(lista);
                break;
            case 2:
                deleteVeiculo(lista);
                break;
            case 3:
                alteraVeiculo(lista);
                break;
            case 4:
                listaVeiculos(*lista);
                break;
            case 5:
                buscaVeiculo(*lista);
                break;
            default:
                break;
        }
    } while (op != 0); // o programa irá encerrar caso o usuário escolha sair, selecionando 0
}

/*
    Função para o menu de locação
*/
void menuLocacao(vector<Locacao> *lista){
    int op; // variável que irá receber a opção de escolha do usuário

    do{
        op = dispMenuVeiculo(); // chama o menu de Locação e armazena a escolha do usuário
        switch (op){ // se o usuário escolher uma opção dentre as diponíveis abaixo, será chamada a função correspondente da biblioteca Veiculo
            case 0:
                break;
            case 1:
                //setLocacao(lista);
                break;
            case 2:
                //deleteLocacao(lista);
                break;
            case 3:
                //alteraLocacao(lista);
                break;
            case 4:
                //listaLocacao(*lista);
                break;
            default:
                break;
        }
    } while (op != 0); // o programa irá encerrar caso o usuário escolha sair, selecionando 0
}

/*
    Função para o menu de ocorrencia
*/
void menuOcorrencia(vector<Locacao> *lista){
    int op; // variável que irá receber a opção de escolha do usuário

    do{
        op = dispMenuVeiculo(); // chama o menu de Locação e armazena a escolha do usuário
        switch (op){ // se o usuário escolher uma opção dentre as diponíveis abaixo, será chamada a função correspondente da biblioteca Veiculo
        case 0:
            break;
        case 1:
            //setOcorrencia(lista);
            break;
        case 2:
            //deleteOcorrencia(lista);
            break;
        case 3:
            //alteraOcorrencia(lista);
            break;
        case 4:
            //listaOcorrenciaCliente(*lista);
            break;
        case 5:
            //listaOcorrenciaVeiculo(*lista);
            break;
        default:
            break;
        }
    } while (op != 0); // o programa irá encerrar caso o usuário escolha sair, selecionando 0
}

/*
    Função para o menu principal
*/
int menuPrincipal(void){
    int opcao = 0;
    do{
        cout << "********* LocaFINA S/A *********" << endl << endl << "\t";
        cout << endl << "Escolha uma opção abaixo:" << endl << endl
            << "#1. Gestao de Clientes" << endl
            << "#2. Gestao de Veiculos" << endl
            << "#3. Gestao de Ocorrencias" << endl 
            << "#4. Gestao de Locacao" << endl
            << "#0. Sair" << endl << endl
            << endl << "Digite uma opcao valida!" << endl
            << "> #";
        cin >> opcao;
    }while(opcao != 0);

    return opcao;
}

#endif // MENU_HPP