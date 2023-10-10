#if !defined(DATA_HPP)
#define DATA_HPP

#include<iostream>
#include<string>
#include<ctime>

using namespace std;

class Data{
    private:
        int dia, mes, ano;
    public:
        Data(){}
        Data(int dia, int mes, int ano);
        int anoEntre(Data* dt);
        static bool isAnoBissexto(int ano);
        static int diasNoMes(int mes, int ano);
        bool estaEntre(Data* dt1, Data* dt2);
        int diaEntre(Data* dt);
        bool isData();
        int diaDaSemana();
        static Data* getDataAtual();
        string toString();
        ~Data();
};

#endif