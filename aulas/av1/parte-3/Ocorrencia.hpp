#if !defined(OCORRENCIA_HPP)
#define OCORRENCIA_HPP

#include<iostream>
#include<string>
#include <vector>
#include "../parte-1/Data.hpp"
#include "../parte-1/Utilitarios.hpp"
#include "../parte-1/Cliente.hpp"
#include "../parte-1/Veiculo.hpp"

using namespace std;

typedef struct T_ocorrencia{
    char ativa = 'n';
    string descricao;
    Data data_hora;
    string apolice;
    
    void dispDadosOcorrencia(){
        limpaTela();
        cout << "********* Dados da Ocorrencia *********" << endl << endl;
        cout << "Data da ocorrencia: " << this->data_hora.toString() << endl
            << "Numero da apolice: " << this->apolice << endl
            << "Descricao: " << this->descricao << endl;
        getchar();
    }

    void dispListaOcorrencia(int id){
        cout << endl << "********* Dados da Ocorrencia #" << id
            << " *********" << endl << endl;
        cout << "Data da ocorrencia: " << this->data_hora.toString() << endl
            << "Numero da apolice: " << this->apolice << endl
            << "Descricao: " << this->descricao << endl;
    }
} Ocorrencia;

typedef struct T_locacao{
    char Realizada;
    Data Dt_HoraRetirada;
    Data Dt_HoraEntrega;
    Cliente cliente;
    Veiculo veiculo;
    Ocorrencia ocorrencia;
}Locacao;

int indexLocacao(vector<Locacao> lista){
    string cpf, placa;
    
    cout << "Informe o CPF do cliente (apenas numeros): ";
    getline(cin, cpf);
    while(cpf.size() > 11 || cpf.size() < 9){
        cout << "Digite um CPF valido (apenas numeros): ";
        getline(cin, cpf);
    }
    
    cout << "Informe a placa do veiculo: ";
    getline(cin, placa);
    
    for (size_t i = 0; i < lista.size(); i++){
        if(lista[i].cliente.CPF == cpf && lista[i].veiculo.Placa == placa)
            return i;
    }
    
    cout << "O cliente e o veiculo nao coincidem em uma locacao."
        << "(Pressione qualquer tecla para continuar...)";
    getchar();
    return -1;
}

void setOcorrencia(vector<Locacao> *lista){
    Ocorrencia nova;
    int idLoc;
    
    limpaTela();
    cout << "********* Cadastro de Ocorrencia *********" << endl << endl;
    
    idLoc = indexLocacao(*lista);
    if(idLoc < 0)
        return;
    if((*lista)[idLoc].ocorrencia.ativa == 's'){
        cout << "A locacao ja possui uma ocorrencia registrada!" << endl
            << "(Pressione qualquer tecla para continuar...)";
        getchar();
        return;
    }
    cout << "Informe a data da ocorrencia:" <<  endl;
    setData(&nova.data_hora);
    while (!nova.data_hora.isData()){
        cout << "Informe uma data valida:" << endl;
        setData(&nova.data_hora);
    }
    
    cout << "Informe o numero da apolice: ";
    getline(cin, nova.apolice);
    
    cout << "Descreva a ocorrencia: ";
    getline(cin, nova.descricao);

    nova.ativa = 's';
    
    (*lista)[idLoc].ocorrencia = nova;

    limpaTela();
    
    cout << "********* Cadastro de Cliente *********" << endl << endl;
    cout << "Cliente cadastrado com sucesso!" << endl;
    getchar();
    return;
}

void deleteOcorrencia(vector<Locacao> *lista){
    char op;
    Ocorrencia nula;
    limpaTela();
    int idLoc = indexLocacao(*lista);
    if(idLoc < 0)
        return;
    if((*lista)[idLoc].ocorrencia.ativa == 'n'){
        cout << "A locacao nao possui uma ocorrencia ativa registrada!" << endl
            << "(Pressione qualquer tecla para continuar...)";
        getchar();
        return;
    }
    (*lista)[idLoc].ocorrencia.dispDadosOcorrencia();
    cout << "Deseja remover esta ocorrencia? ([S]im / [N]ao)" << endl << "> ";
    cin >> op;
    limpaBuffer();
    if(toupper(op) == 'S'){
        (*lista)[idLoc].ocorrencia = nula;
        cout << "Ocorrencia removida com sucesso!";
        getchar();
    }
    return;
}

void alteraOcorrencia(vector<Locacao> *lista){
    string texto;
    int op;
    
    limpaTela();
    int idLoc = indexLocacao(*lista);
    if(idLoc < 0){
        return;
    }
    if((*lista)[idLoc].ocorrencia.ativa == 'n'){
        cout << "A locacao nao possui uma ocorrencia ativa registrada!" << endl
            << "(Pressione qualquer tecla para continuar...)";
        getchar();
        return;
    }

    (*lista)[idLoc].ocorrencia.dispDadosOcorrencia();

    do{
        op = dispAlteraOcorrencia();
        switch (op){
        case 1:
            cout << "Informe a nova data da ocorrencia:" << endl;
            setData(&(*lista)[idLoc].ocorrencia.data_hora);
            while(!(*lista)[idLoc].ocorrencia.data_hora.isData()){
                cout << "Informe uma data valida:" << endl;
                setData(&(*lista)[idLoc].ocorrencia.data_hora);
            }
            cout << "Informe o novo horario da ocorrencia:" << endl;
            setHora(&(*lista)[idLoc].ocorrencia.data_hora);
            while(!(*lista)[idLoc].ocorrencia.data_hora.isHora()){
                cout << "Informe um horario valida:" << endl;
                setHora(&(*lista)[idLoc].ocorrencia.data_hora);
            }
            break;
        case 2:
            cout << "Informe o novo numero da apolice:" << endl << "> ";
            getline(cin, texto);
            (*lista)[idLoc].ocorrencia.apolice = texto;
            break;
        case 3:
            cout << "Informe a nova descricao:" << endl << "> ";
            getline(cin, texto);
            (*lista)[idLoc].ocorrencia.descricao = texto;
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

void listaOcorrenciaCliente(vector<Locacao> lista){
    string cpf;
    int k = 0;

    limpaTela();
    cout << "Informe o CPF do cliente (apenas numeros): ";
    getline(cin, cpf);
    while(cpf.size() > 11 || cpf.size() < 9){
        cout << "Digite um CPF valido (apenas numeros): ";
        getline(cin, cpf);
    }

    for (size_t i = 0; i < lista.size(); i++){
        if(lista[i].cliente.CPF.compare(cpf) == 0){
            k++;
            lista[i].ocorrencia.dispListaOcorrencia(k);
        }
    }
    if(k == 0){
        cout << "Nao ha ocorrencias registradas para o CPF informado!" << endl
            << "(Pressione qualquer tecla para continuar...)";
        getchar();
        return;
    }
    cout << "(Pressione qualquer tecla para continuar...)";
    getchar();
    return;
}

void listaOcorrenciaVeiculo(vector<Locacao> lista){
    string placa;
    int k = 0;
    
    limpaTela();
    cout << "Informe a placa do veiculo: ";
    getline(cin, placa);

    for (size_t i = 0; i < lista.size(); i++){
        if(lista[i].veiculo.Placa.compare(placa) == 0){
            if(lista[i].ocorrencia.ativa == 's'){
                k++;
                lista[i].ocorrencia.dispListaOcorrencia(k);
            }
        }
    }
    if(k == 0){
        cout << "Nao ha ocorrencias registradas para o veiculo informado!" << endl
            << "(Pressione qualquer tecla para continuar...)";
        getchar();
        return;
    }
    cout << "(Pressione qualquer tecla para continuar...)";
    getchar();
    return;
}


#endif