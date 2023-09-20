#if !defined(DATA_HPP)
#define DATA_HPP

#include<iostream>
#include<string>
#include <ctime>
#include "Utilitarios.hpp"

using namespace std;

// Esta biblioteca foi criada para conter funções relacionadas à manipulação de datas

// Definiu-se a struct para uma data contendo os atributos necessários a ela, além de algumas funções próprias da struct. 
typedef struct T_data{
    int dia, mes, ano;
    int hora = -1, min = -1;

    /*  A função toString retorna uma string com a data formatada (Ex: 19/09/2023)
    */
    string toString(){
        string data = "";

        if(this->dia <10)
            data += "0";
        data += to_string(this->dia) + "/";

        if(this->mes < 10)
            data += "0";
        data += to_string(this->mes) + "/";
        data += to_string(this->ano);
        
        return data;
    }

    /*  A função anoEntre calcula e retorna os anos completos entre duas datas.
    */
    int anoEntre(T_data dt){
        int k = this->ano-dt.ano;
        if(k < 0){
            k = dt.ano - this->ano;
            if(dt.mes < this->mes)
                k--;
            else if(dt.mes == this->mes && dt.dia < this->dia)
                k--;
        }else if(k > 0){
            if(dt.mes > this->mes)
                k--;
            else if(dt.mes == this->mes && dt.dia > this->dia)
                k--;
        }
        return k;
    }

    /*  A função isData verifica se a data é valida e retorna true, caso contrário retorna false.
    */
    bool isData(){
        if (this->dia < 1 || this->dia > 31 || this->mes < 1 || this->mes > 12)
            return false;
        
        switch (this->mes){
            case 2:
                if (this->ano%4 == 0 && (this->ano%400 == 0 || this->ano%100 != 0) && this->dia > 29)
                    return false;
                if (!(this->ano%4 == 0 && (this->ano%400 == 0 || this->ano%100 != 0)) && this->dia > 28)
                    return false;
                break;
            case 4:
                if (this->dia > 30)
                    return false;
                break;
            case 6:
                if (this->dia > 30)
                    return false;
                break;
            case 9:
                if (this->dia > 30)
                    return false;
                break;
            case 11:
                if (this->dia > 30)
                    return false;
                break;
            default:
                break;
        }
        return true;
    }

    /*  A função isHora verifica se a hora é valida e retorna true, caso contrário retorna false.
    */
    bool isHora(){
        if(this->hora > 23 || this->hora < 0 || this->min > 59 || this->min < 0)
            return false;
        else
            return true;
    }

    /*  A função diaDaSemana calcula e retorna um número entre 0 e 6 correspondente ao dia da semana.
    */
    int diaDaSemana(){
        int formula, dia_semana;
        int c_dia = this->dia, c_mes = this->mes, c_ano = this->ano;
        
        if(c_mes == 01 ){ // mês de janeiro será o mês 13 do ano anterior.
            c_mes = 13;
            c_ano = c_ano - 1;
        }

        if(c_mes == 02 ){ // mês de favereiro será o mês 14 do ano anterior.
            c_mes = 14;
            c_ano = c_ano - 1;
        } 

        formula = c_dia + 2*c_mes + (3*(c_mes+1)/5) + c_ano + c_ano/4 - c_ano/100 + c_ano/400 + 1;  // Formula para calcular o dia da semana.
        dia_semana = formula % 7;                                                     // Resto da divisão do valor encontrado na formula por 7.
        
        return dia_semana;
    }

    /*  A função getHora retorna uma string com a hora formatada (Ex: 12:00)
    */
    string getHora(){
        string horario = "";

        if(this->hora <10 && this->hora >= 0)
            horario += "0";
        horario += to_string(this->hora) + ":";

        if(this->min < 10 && this->min >= 0)
            horario += "0";
        horario += to_string(this->min);
        
        return horario;
    }

}Data;

/*  A função getDataAtual coleta a data atual e a retorna.
*/
Data getDataAtual(){
    Data data;
    time_t tempo_atual = time(NULL);
    struct tm tm = *localtime(&tempo_atual);
    data.dia = tm.tm_mday;
    data.mes = tm.tm_mon + 1;
    data.ano = tm.tm_year + 1900;
 
    return data;
}

/*  A função setData solicita do usuário um dia, mes e ano e armazena essa data.
*/
void setData(Data *nova_data){
    cout << "Digite o dia: ";
    cin >> nova_data->dia;
    cout << "Digite o mes: ";
    cin >> nova_data->mes;
    cout << "Digite o ano: ";
    cin >> nova_data->ano;
    limpaBuffer();
    return;
}

/*  A função setHora solicita do usuário uma hora e minuto e armazena esse horario.
*/
void setHora(Data *nova_hora){
    cout << "Digite a hora (apenas dois numeros): ";
    cin >> nova_hora->hora;
    cout << "Digite os minutos (apenas dois numeros): ";
    cin >> nova_hora->min;
    limpaBuffer();
    return;
}

#endif // DATA_HPP
