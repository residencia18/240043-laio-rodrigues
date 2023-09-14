#if !defined(DATA_HPP)
#define DATA_HPP

#include<iostream>
#include<string>
#include<ctime>

using namespace std;

class Data
{
private:
    int dia, mes, ano;
public:
    Data(int dia, int mes, int ano);
    int anoEntre(Data dt);
    bool isData();
    int diaDaSemana();
    string toString();
    ~Data();
};

Data::Data(int dia, int mes, int ano){
    this->dia = dia;
    this->mes = mes;
    this->ano = ano;
}

int Data::anoEntre(Data dt){
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

bool Data::isData(){
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
            return true;
            break;
    }
}

int Data::diaDaSemana(){
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

string Data::toString(){
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

Data::~Data(){
    cout << "Data removida com sucesso!" << endl;
}

#endif