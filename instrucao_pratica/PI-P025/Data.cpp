#include"Data.hpp"


Data::Data(int dia, int mes, int ano){
    this->dia = dia;
    this->mes = mes;
    this->ano = ano;
}

int Data::getDia(){
    return this->dia;
}

int Data::getMes(){
    return this->mes;
}

int Data::getAno(){
    return this->ano;
}

int Data::anoEntre(Data* dt){
    int k = this->ano - dt->ano;
    if(k < 0){
        k = dt->ano - this->ano;
        if(dt->mes < this->mes)
            k--;
        else if(dt->mes == this->mes && dt->dia < this->dia)
            k--;
    }else if(k > 0){
        if(dt->mes > this->mes)
            k--;
        else if(dt->mes == this->mes && dt->dia > this->dia)
            k--;
    }
    return k;
}


bool Data::isAnoBissexto(int ano){
    return (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0));
}

int Data::diasNoMes(int _mes, int ano){
    int mes[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    if(isAnoBissexto(ano)){
        mes[1] = 29;
    }
    return mes[_mes-1];
}

bool Data::estaEntre(Data* dt1, Data* dt2){
    if(this->diaEntre(dt1) < 0 && this->diaEntre(dt2) > 0)
        return true;
    return false;
}

int Data::diaEntre(Data* dt){
    int dias = 0;
    
    Data* d1 = new Data();
    d1->setAno(this->ano);
    d1->setMes(this->mes);
    d1->setDia(this->dia);

    if(d1->getAno()>dt->getAno() || (d1->getAno()==dt->getAno() && d1->getMes()>dt->getMes()) || (d1->getAno()==dt->getAno() && d1->getMes()==dt->getMes() && d1->getDia()>dt->getDia())){
        return -1;
    }

    while(d1->getAno()<dt->getAno() || (d1->getAno()==dt->getAno() && d1->getMes()<dt->getMes())){
        dias += (Data::diasNoMes(d1->getMes(), d1->getAno()) - d1->getDia() + 1);
        d1->setDia(1);
        d1->setMes(d1->getMes()+1);
        
        if(d1->getMes() > 12){
            d1->setMes(1);
            d1->setAno(d1->getAno()+1);
        }
        
        if(d1->getAno() > dt->getAno())
            break;
    }
    dias += dt->getDia() - d1->getDia();
    return dias;

    
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
    return true;
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

void Data::somaDias(int dias){
    this->dia = this->dia + dias;
    
    if(this->dia > Data::diasNoMes(this->mes, this->ano)){
        this->dia = this->dia - Data::diasNoMes(this->mes, this->ano);
        this->mes = this->mes + 1;
        if(this->mes > 12){
            this->mes = 1;
            this->ano = this->ano + 1;
        }
    }
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

Data* Data::getDataAtual(){
    time_t t = time(NULL);
    struct tm *tm = localtime(&t);
    Data* dt = new Data(tm->tm_mday, tm->tm_mon + 1, tm->tm_year + 1900);
    return dt;
}

Data::~Data(){}