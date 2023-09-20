#if !defined(CLIENTE_HPP)
#define CLIENTE_HPP

#include<iostream>
#include<string>
#include <vector>
#include "Data.hpp"
#include "Utilitarios.hpp"

using namespace std;


// Esta biblioteca foi criada para conter funções relacionadas à manipulação dos clientes

// Definiu-se a struct para um cliente contendo os atributos necessários a ele, além de algumas funções próprias da struct.
typedef struct T_cliente{
    string CPF;
    string Nome;
    Data DtNascimento;
    string CNH;

    /*  A função dispDadosCliente quando executada ira imprimir para o usuário os dados 
        correspondentes a um cliente. 
    */
    void dispDadosCliente(){
        limpaTela();
        cout << "********* Dados do Cliente *********" << endl << endl;
        cout << "Nome completo: " << this->Nome << endl
            << "CPF: " << getCPF() << endl
            << "Data de nascimento: " << this->DtNascimento.toString() << endl
            << "CNH: " << this->CNH << endl;
        getchar();
    }

    /*  A função dispListaCliente quando executada ira imprimir para o usuário os dados 
        correspondentes a um cliente, sendo ela utilizada para listar todos os clientes. 
    */
    void dispListaClientes(int id){
        cout << endl << "********* Dados do Cliente #" << id
            << " *********" << endl << endl;
        cout << "Nome completo: " << this->Nome << endl
            << "CPF: " << getCPF() << endl
            << "Data de nascimento: " << this->DtNascimento.toString() << endl
            << "CNH: " << this->CNH << endl;
    }

    /* A função getCPF retorna uma string com o CPF do cliente devidamente formatado.
    */
    string getCPF(){
        string cpf = "";
        
        cpf.insert(cpf.end(), this->CPF.end()-2, this->CPF.end());
        cpf.insert(0, "-");
        cpf.insert(cpf.begin(), this->CPF.end()-5, this->CPF.end()-2);
        cpf.insert(0, ".");
        cpf.insert(cpf.begin(), this->CPF.end()-8, this->CPF.end()-5);
        cpf.insert(0, ".");
        cpf.insert(cpf.begin(), this->CPF.end()-11, this->CPF.end()-8);
        return cpf;
    }

} Cliente; // optou-se pela utilização de um typedef para definir o nome da struct como Cliente

/*  A função hasCPF irá procurar se já existe um CPF específico em algum cliente
    do vetor de clientes. 
*/
bool hasCPF(string CPF, vector<Cliente> lista){
    for (size_t i = 0; i < lista.size(); i++){
        if (lista[i].CPF == CPF){
            return true;
        }
    }
    return false;
}

/*  A função setCliente recebe a referência do vetor de clientes, cria um novo cliente,
    recebe do usuário os dados do cliente e armazena no vetor de clientes o novo cliente. 
*/
void setCliente(vector<Cliente> *lista){
    Cliente cliente;
    limpaTela();
    cout << "********* Cadastro de Cliente *********" << endl << endl;
    cout << "Informe o nome do cliente: ";
    getline(cin, cliente.Nome);
    cout << "Informe o CPF (apenas numeros): ";
    getline(cin, cliente.CPF);
    // Caso o usuário informe um CPF inválido ou ja existente, será solicitado um novo CPF
    while((cliente.CPF.size() > 11 || cliente.CPF.size() < 9) || hasCPF(cliente.CPF, *lista)){
        cout << "CPF invalido ou ja cadastrado!" << endl;
        cout << "Informe um CPF valido (apenas numeros): ";
        getline(cin, cliente.CPF);
    }
    cout << "Informe a data de nascimento:" << endl;
    setData(&cliente.DtNascimento);
    // Caso o usuário informe uma data inválida, será solicitado uma nova data
    while (!cliente.DtNascimento.isData()){
        cout << "Informe uma data valida:" << endl;
        setData(&cliente.DtNascimento);
    }
    cout << "Informe o numero da CNH:";
    getline(cin, cliente.CNH);
    (*lista).push_back(cliente);
    limpaTela();
    cout << "********* Cadastro de Cliente *********" << endl << endl;
    cout << "Cliente cadastrado com sucesso!" << endl;
    getchar();
}

/*  A função indexCliente executa uma busca no vetor de clientes por um determinado CPF,
    caso encontre retorna a posição do vetor correspondente ao cliente com o CPF, 
    caso não encontre informa que o CPF não foi encontrado e retorna -1. 
*/
int indexCliente(string CPF, vector<Cliente> lista){
    for (size_t i = 0; i < lista.size(); i++){
        if (lista[i].CPF == CPF){
            return i;
        }
    }
    limpaTela();
    cout << "CPF informado nao encontrado!" << endl
         << "(Pressione qualquer tecla para continuar...)";
    getchar();
    return -1;
}

/*  A função deleteCliente solicita do usuário um CPF e faz uma busca desse CPF no vetor de clientes,
    caso encontre, mostra os dados do cliente para o usuário e pergunta se o usuário deseja apagar o cliente,
    caso o usuário confirme, o cliente é removido do vetor de clientes,
    caso o usuário negue, retorna ao menu anterior.
*/
void deleteCliente(vector<Cliente> *lista){
    string cpf;
    char op;
    limpaTela();
    cout << "Informe o CPF do cliente (apenas numeros):" << endl << "> ";
    getline(cin, cpf);
    while(cpf.size() > 11 || cpf.size() < 9){
        cout << "Informe um CPF valido (apenas numeros): ";
        getline(cin, cpf);
    }
    int idCliente = indexCliente(cpf, *lista);
    if(idCliente < 0){
        return;
    }
    (*lista)[idCliente].dispDadosCliente();
    cout << "Deseja remover este cliente? ([S]im / [N]ao)" << endl << "> ";
    cin >> op;
    limpaBuffer();
    if(toupper(op) == 'S'){
        (*lista).erase((*lista).begin()+idCliente);
        cout << "Cliente removido com sucesso!";
        getchar();
    }
    return;
}

/*  A função alteraCliente solicita do usuário um CPF e faz uma busca desse CPF no vetor de clientes,
    caso encontre, mostra os dados do cliente para o usuário e pergunta se o usuário deseja altera algum dado,
    caso o usuário selecione alguma das opções disponíveis, é solicitado e executado as alterações correspondentes,
    logo após, o usuário é questionado se deseja realizar alguma outra alteração, se o usuário não quiser,
    a função é encerrada e retorna ao menu anterior.
*/
void alteraCliente(vector<Cliente> *lista){
    string cpf, nome, cnh;
    int op;
    
    limpaTela();
    cout << "Informe o CPF do cliente (apenas numeros):" << endl << "> ";
    getline(cin, cpf);
    while(cpf.size() > 11 || cpf.size() < 9){
        cout << "Informe um CPF valido (apenas numeros): ";
        getline(cin, cpf);
    }
    int idCliente = indexCliente(cpf, *lista);
    if(idCliente < 0){
        return;
    }
    (*lista)[idCliente].dispDadosCliente();

    do{
        op = dispAlteraCliente();
        switch (op){
        case 1:
            cout << "Informe o novo nome do cliente:" << endl << "> ";
            getline(cin, nome);
            (*lista)[idCliente].Nome = nome;
            break;
        case 2:
            cout << "Informe a nova data de nascimento:" << endl << "> ";
            setData(&(*lista)[idCliente].DtNascimento);
            while (!(*lista)[idCliente].DtNascimento.isData()){
                cout << "Informe uma data valida:" << endl;
                setData(&(*lista)[idCliente].DtNascimento);
            }
            break;
        case 3:
            cout << "Informe o novo numero da CNH:" << endl << "> ";
            getline(cin, cnh);
            (*lista)[idCliente].CNH = cnh;
            break;
        default:
            break;
        }
        if(op != 0){
            cout << "Alteracoes realizadas com sucesso!" << endl;
            cout << "Deseja outra alteração? ([1]Sim / [0]Nao)" << endl << "> ";
            cin >> op;
            limpaBuffer();
        }
    } while (op != 0);
}

/*  A função listaClientes recebe o vetor de clientes e imprime na tela os dados de todos
    os clientes presentes no vetor.
*/
void listaClientes(vector<Cliente> lista){
    limpaTela();
    for (size_t i = 0; i < lista.size(); i++){
        lista[i].dispListaClientes(i+1);
    }
    getchar();
}

/*  A função buscaCliente solicita do usuário um CPF e faz uma busca desse CPF no vetor de clientes,
    caso encontre, mostra os dados do cliente para o usuário.
*/
void buscaCliente(vector<Cliente> lista){
    string cpf;

    limpaTela();
    cout << "Informe o CPF do cliente (apenas numeros):" << endl << "> ";
    getline(cin, cpf);
    while(cpf.size() > 11 || cpf.size() < 9){
        cout << "Informe um CPF valido (apenas numeros): ";
        getline(cin, cpf);
    }
    int idCliente = indexCliente(cpf, lista);
    if(idCliente < 0){
        return;
    }
    lista[idCliente].dispDadosCliente();
}

#endif