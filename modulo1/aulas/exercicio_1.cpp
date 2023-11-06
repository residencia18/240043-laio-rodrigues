#include<iostream>
#include<sstream>
#include<string>
#include<vector>
#include<conio.h>
#include<math.h>

using namespace std;

typedef struct T_passagem{
    string nome, cpf, data, hora;
    int idade, linha, acento;
} Passagem;

void dispLinhas(int posicao, vector<int> disponivel){
    system("cls");
    cout << "======= Viacao Residencia =======" << endl << endl;
    cout << "== Selecione a linha da viagem ==" << endl << endl;
    for (int i = 0; i < 10; i++){
        if(disponivel[i] == 1)
            cout << "\t*** ONIBUS CHEIO ***" << endl;
        if (i == posicao)
            cout << "-> ";
        switch (i){
            case 0:
                cout << "IDA ---- 08:00h -- RJ x SP" << endl;
                break;
            case 1:
                cout << "VOLTA -- 09:00h -- SP x RJ" << endl;
                break;
            case 2:
                cout << "IDA ---- 10:00h -- RJ x SP" << endl;
                break;
            case 3:
                cout << "VOLTA -- 11:00h -- SP x RJ" << endl;
                break;
            case 4:
                cout << "IDA ---- 12:00h -- RJ x SP" << endl;
                break;
            case 5:
                cout << "VOLTA -- 13:00h -- SP x RJ" << endl;
                break;
            case 6:
                cout << "IDA ---- 14:00h -- RJ x SP" << endl;
                break;
            case 7:
                cout << "VOLTA -- 15:00h -- SP x RJ" << endl;
                break;
            case 8:
                cout << "IDA ---- 16:00h -- RJ x SP" << endl;
                break;
            case 9:
                cout << "VOLTA -- 17:00h -- SP x RJ" << endl;
                break;
        default:
            break;
        }
    }
}

int linhaOpcoes(vector<vector<int>> *onibus){
    int seta, posicao = 0, onibusCheio = 0, ocupadas = 0;
    vector<int> disponivel(10, 0);

    for (int i = 0; i < 10; i++){
        ocupadas = 0;
        for (int j = 0; j < 40; j++){
            if((*onibus)[i][j] == 1)
                ocupadas++;
        }
        if (ocupadas == 40){
            disponivel[i] = 1;
            onibusCheio++;
        }
    }
    if(onibusCheio == 10){
        system("cls");
        cout << "Todos os onibus estao cheios!" << endl;
        system("pause");
        return -1;
    }
    do{
        if(seta==80){
            posicao++;
            if (disponivel[posicao] == 1)
                posicao++;
        }
        if(seta==72){
            posicao--;
            if (disponivel[posicao] == 1)
                posicao--;
        }
        if(posicao>9)
            posicao=0;
        if(posicao<0)
            posicao=9;

        dispLinhas(posicao, disponivel);
        seta = _getch();

        if(seta == 13){
            return posicao;
        }
    } while (seta!=27);
    return -1;
}

string getData(){
    string temp, data;
    int dia, mes;
    bool erro;

    system("cls");
    cout << "Informe a data da viagem:" << endl << "> ";
    cin >> data;

    do{
        erro = false;
        istringstream str(data);

        getline(str, temp, '/');
        dia = stoi(temp);
        getline(str, temp, '/');
        mes = stoi(temp);

        if (dia < 1){
            erro = true;
        }

        switch (mes){
            case 2:
                if (dia > 29)
                    erro = true;
                break;
            case 4:
                if (dia > 30)
                    erro = true;
                break;
            case 6:
                if (dia > 30)
                    erro = true;
                break;
            case 9:
                if (dia > 30)
                    erro = true;
                break;
            case 11:
                if (dia > 30)
                    erro = true;
                break;
            default:
                if (dia > 31 || mes > 12)
                    erro = true;
                break;
        }
        if(erro){
            system("cls");
            cout << "Por favor, digite uma data valida:" << endl << "> ";
            cin >> data;
        }
    } while (erro);
    
    return data;
}

string getHora(int linha){
    string hora;
    switch (linha){
        case 0:
            hora = "08:00";
            break;
        case 1:
            hora = "09:00";
            break;
        case 2:
            hora = "10:00";
            break;
        case 3:
            hora = "11:00";
            break;
        case 4:
            hora = "12:00";
            break;
        case 5:
            hora = "13:00";
            break;
        case 6:
            hora = "14:00";
            break;
        case 7:
            hora = "15:00";
            break;
        case 8:
            hora = "16:00";
            break;
        case 9:
            hora = "17:00";
            break;
        default:
            break;
    }
    return hora;
}

void dispAcento(vector<int> poltronas){
    system("cls");
    cout << "================= Viacao Residencia ==================" << endl << endl;
    cout << "=========== Selecione um acento disponivel ===========" << endl << endl;
    for (int i = 1; i <= 4; i++){
        cout << "\t";
        for (int j = 0; j < 10; j++){
            if (poltronas[4*j + i - 1] == 1){
                cout << "--" << "  ";
            }else{
                if(j*4 + i < 10)
                    cout << " ";
                cout << (j*4 + i) << "  ";
            }
        }
        cout << endl;
        if(i == 2){
            cout << endl;
        }
    }
}

int getAcento(vector<int> *poltronas){
    int acento = 0;

    dispAcento(*poltronas);

    while (acento == 0){
        cout << endl << "> ";
        cin >> acento;
        if((*poltronas)[acento-1] == 1 || acento > 40 || acento <= 0){
            dispAcento(*poltronas);
            acento = 0;
            cout << endl << "Acento nao disponivel!";
        }
    }
    (*poltronas)[acento-1] = 1;
    return acento;
}

int getDadosViagem(Passagem* passageiro, vector<vector<int>> *onibus){
    
    passageiro->data = getData();
    passageiro->linha = linhaOpcoes(onibus);
    int li = passageiro->linha;
    if (li == -1){
        return 0;
    }
    passageiro->hora = getHora(li);
    passageiro->acento = getAcento(&onibus->at(li));
    return 1;
}

int getDadosPassageiro(Passagem* passageiro){
    string nome, sobrenome, cpf;
    int idade;
    char confirma;

    do{
        system("cls");
        cout << "Digite o primeiro nome do passageiro:" << endl << "> ";
        cin >> nome;
        cout << "Digite o ultimo sobrenome do passageiro:" << endl << "> ";
        cin >> sobrenome;
        cout << "Digite o CPF do passageiro (Formato: 123.456.789-10):" << endl << "> ";
        cin >> cpf;
        cout << "Digite a idade do passageiro:" << endl << "> ";
        cin >> idade;

        passageiro->nome = nome + " " + sobrenome;
        passageiro->cpf = cpf;
        passageiro->idade = idade;

        system("cls");
        cout << "Confirme os dados do passageiro:" << endl << endl
            << "Nome Completo: " << passageiro->nome << endl
            << "CPF: " << passageiro->cpf << endl
            << "Idade: " << passageiro->idade << endl << endl
            << "Os dados estao corretos? ([S]im / [N]ao)" << endl << "> ";
        cin >> confirma;
        if (toupper(confirma) != 'S'){
            cout << "Refazer ou Sair? ([R]efazer / [S]air)" << endl << "> ";
            cin >> confirma;
            if(toupper(confirma) == 'S')
                return 0;
        }
    }while(toupper(confirma) != 'S');

    return 1;
}

void incluirPassagem(vector<vector<Passagem>> *viagens, vector<vector<int>> *onibus){
    Passagem passageiro;
    vector<Passagem> viagem;

    if(!getDadosViagem(&passageiro, onibus))
        return;
    if(!getDadosPassageiro(&passageiro))
        return;
    viagem.push_back(passageiro);
    (*viagens)[passageiro.linha] = viagem;
    return;
}

void buscarInfo(vector<vector<Passagem>> *viagens, vector<vector<int>> *onibus){
    int poltrona, linha = -1, h;
    string hora;
    system("cls");
    cout << "Informe o horario do onibus (Ex.: 08:00, 09:00,...):" << endl << "> ";
    cin >> hora;
    cout << "Informe o numero da poltrona" << endl << "> ";
    cin >> poltrona;

    h = stoi(hora.substr(0,2));

    switch (h){
    case 8:
        if ((*onibus)[0][poltrona-1] == 1)
            linha = 0;
        break;
    case 9:
        if ((*onibus)[1][poltrona-1] == 1)
            linha = 1;
        break;
    case 10:
        if ((*onibus)[2][poltrona-1] == 1)
            linha = 2;
        break;
    case 11:
        if ((*onibus)[3][poltrona-1] == 1)
            linha = 3;
        break;
    case 12:
        if ((*onibus)[4][poltrona-1] == 1)
            linha = 4;
        break;
    case 13:
        if ((*onibus)[5][poltrona-1] == 1)
            linha = 5;
        break;
    case 14:
        if ((*onibus)[6][poltrona-1] == 1)
            linha = 6;
        break;
    case 15:
        if ((*onibus)[7][poltrona-1] == 1)
            linha = 7;
        break;
    case 16:
        if ((*onibus)[8][poltrona-1] == 1)
            linha = 8;
        break;
    case 17:
        if ((*onibus)[9][poltrona-1] == 1)
            linha = 9;
        break;
    default:
        break;
    }

    if(linha == -1){
        cout << endl << "Nao ha passageiro nessa poltrona" << endl;
        system("pause");
    }else{
        system("cls");
        cout << "Na poltrona " << poltrona << " esta:" << endl
             << "Nome: " << (*viagens)[linha][poltrona-1].nome << endl
             << "CPF: " << (*viagens)[linha][poltrona-1].cpf << endl
             << "Idade: " << (*viagens)[linha][poltrona-1].idade << endl;
        system("pause");
    }
}


void dispMenu(int posicao){
    system("cls");
    cout << "======= Viacao Residencia =======" << endl << endl;
    for (int i = 0; i < 5; i++){
        if (i == posicao)
            cout << "-> ";
        switch (i){
            case 0:
                cout << "Registrar passagem" << endl;
                break;
            case 1:
                cout << "Exibir informacoes sobre passageiros" << endl;
                break;
            case 2:
                cout << "Arrecadacoes" << endl;
                break;
            case 3:
                cout << "Medias de idade dos passageiros" << endl << endl;
                break;
            case 4:
                cout << "Sair" << endl;
                break;
        default:
            break;
        }
    }
}

void menuOpcoes(void){
    int seta, posicao = 0;
    vector<Passagem> passageiro(40);
    vector<vector<Passagem>> viagens(10, passageiro);
    vector<int> poltronas(40, 0);
    vector<vector<int>> onibus(10, poltronas);
    do{
        if(seta==80)
            posicao++;
        if(seta==72)
            posicao--;
        if(posicao>4)
            posicao=0;
        if(posicao<0)
            posicao=4;

        dispMenu(posicao);
        seta = _getch();

        if(seta == 13){
            switch (posicao){
            case 0:
                incluirPassagem(&viagens, &onibus);
                break;
            case 1:
                buscarInfo(&viagens, &onibus);
                break;
            case 2:
                // arrecadacoes(viagens);
                break;
            case 3:
                // mediaIdade(viagens);
                break;
            case 4:
                seta = 27;
                break;
            default:
                break;
            }
        }
    } while (seta!=27);
    
}

int main(){

    menuOpcoes();
    system("cls");
    
    return 0;
}