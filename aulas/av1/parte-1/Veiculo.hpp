#if !defined(VEICULO_HPP)
#define VEICULO_HPP

#include<iostream>
#include<string>
#include <vector>
#include "Data.hpp"
#include "Menu.hpp"
#include "Utilitarios.hpp"

using namespace std;

// Esta biblioteca foi criada para conter funções relacionadas à manipulação dos veículos


// Definiu-se a struct para um veículo contendo os atributos necessários a ele, além de algumas funções próprias da struct.
typedef struct T_veiculo{
    string Renavan;
    string Placa;
    Data Data_Hora_Retirada;
    Data Data_Hora_Entrega;
    string Loja_Retirada;

    /*  A função dispDadosVeiculo quando executada ira imprimir para o usuário os dados 
        correspondentes a um veículo. 
    */
    void dispDadosVeiculo(){
        limpaTela();
        cout << "********* Dados do Veiculo *********" << endl << endl;
        cout << "Renavan: " << this->Renavan << endl
            << "Placa: " << this->Placa << endl
            << "Data e hora da retirada (prevista): " << this->Data_Hora_Retirada.getHora()
            << " " << this->Data_Hora_Retirada.toString() << endl
            << "Data e hora da entrega (prevista): " << this->Data_Hora_Entrega.getHora()
            << " " << this->Data_Hora_Entrega.toString() << endl
            << "Loja de retirada: " << this->Loja_Retirada << endl;
        getchar();
    }

    /*  A função dispListaVeiculo quando executada ira imprimir para o usuário os dados 
        correspondentes a um veículo, sendo ela utilizada para listar todos os veículos. 
    */
    void dispListaVeiculos(int id){
        cout << endl << "********* Dados do Veiculo #" << id
            << " *********" << endl << endl;
        cout << "Renavan: " << this->Renavan << endl
            << "Placa: " << this->Placa << endl
            << "Data e hora da retirada (prevista): " << this->Data_Hora_Retirada.getHora()
            << " " << this->Data_Hora_Retirada.toString() << endl
            << "Data e hora da entrega (prevista): " << this->Data_Hora_Entrega.getHora()
            << " " << this->Data_Hora_Entrega.toString() << endl
            << "Loja de retirada: " << this->Loja_Retirada << endl;
    }

} Veiculo; // optou-se pela utilização de um typedef para definir o nome da struct como Veiculo

/*  A função hasPlaca irá procurar se já existe uma placa específica em algum veículo
    do vetor de veículos. 
*/
bool hasPlaca(string placa, vector<Veiculo> lista){
    for (size_t i = 0; i < lista.size(); i++){
        if (lista[i].Placa == placa){
            return true;
        }
    }
    return false;
}

/*  A função setVeiculo recebe a referência do vetor de veículos, cria um novo veículo,
    recebe do usuário os dados do veículo e armazena no vetor de veículos o novo veículo. 
*/
void setVeiculo(vector<Veiculo> *lista){
    Veiculo veiculo;
    limpaTela();
    cout << "********* Cadastro de Veiculo *********" << endl << endl;
    cout << "Informe o renavan do veiculo: ";
    getline(cin, veiculo.Renavan);
    cout << "Informe a placa do veiculo:";
    getline(cin, veiculo.Placa);
    while(hasPlaca(veiculo.Placa, *lista)){ // Caso o usuário informe uma placa ja existente, será solicitado uma nova placa
        cout << "Placa ja cadastrada!" << endl;
        cout << "Informe uma placa valida: ";
        getline(cin, veiculo.Placa);
    }
    cout << "Informe a data prevista de retirada do veiculo:" << endl;
    setHora(&veiculo.Data_Hora_Retirada);
    while(!veiculo.Data_Hora_Retirada.isHora()){ // Caso o usuário informe uma hora inválida, será solicitado um novo horario
        cout << "Informe uma hora valida:" << endl;
        setHora(&veiculo.Data_Hora_Retirada);
    }
    setData(&veiculo.Data_Hora_Retirada);
    while(!veiculo.Data_Hora_Retirada.isData()){ // Caso o usuário informe uma data inválida, será solicitado uma nova data
        cout << "Informe uma data valida:" << endl;
        setData(&veiculo.Data_Hora_Retirada);
    }
    cout << "Informe a data prevista de entrega do veiculo:" << endl;
    setHora(&veiculo.Data_Hora_Entrega);
    while(!veiculo.Data_Hora_Entrega.isHora()){ // Caso o usuário informe uma hora inválida, será solicitado um novo horario
        cout << "Informe uma hora valida:" << endl;
        setHora(&veiculo.Data_Hora_Entrega);
    }
    setData(&veiculo.Data_Hora_Entrega);
    while(!veiculo.Data_Hora_Entrega.isData()){ // Caso o usuário informe uma data inválida, será solicitado uma nova data
        cout << "Informe uma data valida:" << endl;
        setData(&veiculo.Data_Hora_Entrega);
    }
    cout << "Informe o nome da loja de retirada: ";
    getline(cin, veiculo.Loja_Retirada);
    (*lista).push_back(veiculo);
    limpaTela();
    cout << "********* Cadastro de Veiculo *********" << endl << endl;
    cout << "Veiculo cadastrado com sucesso!" << endl;
    getchar();
}

/*  A função indexVeiculo executa uma busca no vetor de veículos por uma determinada placa,
    caso encontre retorna a posição do vetor correspondente ao veículo com a placa, 
    caso não encontre informa que a placa não foi encontrada e retorna -1. 
*/    
int indexVeiculo(string Placa, vector<Veiculo> lista){
    for (size_t i = 0; i < lista.size(); i++){
        if (lista[i].Placa == Placa){
            return i;
        }
    }
    limpaTela();
    cout << "Placa informada nao encontrada!" << endl
         << "(Pressione qualquer tecla para continuar...)";
    getchar();
    return -1;
}

/*  A função deleteVeiculo solicita do usuário uma placa e faz uma busca dessa placa no vetor de veículos,
    caso encontre, mostra os dados do veículo para o usuário e pergunta se o usuário deseja apagar o veículo,
    caso o usuário confirme, o veículo é removido do vetor de veículos,
    caso o usuário negue, retorna ao menu anterior.
*/
void deleteVeiculo(vector<Veiculo> *lista){
    string placa;
    char op;
    limpaTela();
    cout << "Informe a placa do veiculo:" << endl << "> ";
    getline(cin, placa);
    int idVeiculo = indexVeiculo(placa, *lista);
    if(idVeiculo < 0){
        return;
    }
    (*lista)[idVeiculo].dispDadosVeiculo();
    cout << "Deseja remover este veiculo? ([S]im / [N]ao)" << endl << "> ";
    cin >> op;
    limpaBuffer();
    if(toupper(op) == 'S'){
        (*lista).erase((*lista).begin()+idVeiculo);
        cout << "Veiculo removido com sucesso!";
        getchar();
    }
    return;
}

/*  A função alteraVeiculo solicita do usuário uma placa e faz uma busca dessa placa no vetor de veículos,
    caso encontre, mostra os dados do veículo para o usuário e pergunta se o usuário deseja altera algum dado,
    caso o usuário selecione alguma das opções disponíveis, é solicitado e executado as alterações correspondentes,
    logo após, o usuário é questionado se deseja realizar alguma outra alteração, se o usuário não quiser,
    a função é encerrada e retorna ao menu anterior.
*/
void alteraVeiculo(vector<Veiculo> *lista){
    string texto;
    int op;
    
    limpaTela();
    cout << "Informe a placa do veiculo:" << endl << "> ";
    getline(cin, texto);
    int idVeiculo = indexVeiculo(texto, *lista);
    if(idVeiculo < 0){
        return;
    }
    (*lista)[idVeiculo].dispDadosVeiculo();

    do{
        op = dispAlteraVeiculo();
        switch (op){
        case 1:
            cout << "Informe o novo renavan do veiculo:" << endl << "> ";
            getline(cin, texto);
            (*lista)[idVeiculo].Renavan = texto;
            break;
        case 2:
            cout << "Informe a nova data e hora de retirada:" << endl;
            setHora(&(*lista)[idVeiculo].Data_Hora_Retirada);
            setData(&(*lista)[idVeiculo].Data_Hora_Retirada);
            break;
        case 3:
            cout << "Informe a nova data e hora de entrega:" << endl;
            setHora(&(*lista)[idVeiculo].Data_Hora_Entrega);
            setData(&(*lista)[idVeiculo].Data_Hora_Entrega);
            break;
        case 4:
            cout << "Informe o novo nome da loja de retirada:" << endl << "> ";
            getline(cin, texto);
            (*lista)[idVeiculo].Loja_Retirada = texto;
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

/*  A função listaVeiculos recebe o vetor de veículos e imprime na tela os dados de todos
    os veículos presentes no vetor.
*/
void listaVeiculos(vector<Veiculo> lista){
    limpaTela();
    for (size_t i = 0; i < lista.size(); i++){
        lista[i].dispListaVeiculos(i+1);
    }
    getchar();
}

/*  A função buscaVeiculo solicita do usuário uma placa e faz uma busca dessa placa no vetor de veículos,
    caso encontre, mostra os dados do veículo para o usuário.
*/
void buscaVeiculo(vector<Veiculo> lista){
    string placa;
    
    limpaTela();
    cout << "Informe a placa do veiculo:" << endl << "> ";
    getline(cin, placa);
    int idVeiculo = indexVeiculo(placa, lista);
    if(idVeiculo < 0){
        return;
    }
    lista[idVeiculo].dispDadosVeiculo();
}

#endif