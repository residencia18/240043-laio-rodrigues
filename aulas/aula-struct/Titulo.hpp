#if !defined(TITULO_HPP)
#define TITULO_HPP

#include<iostream>
#include<string>
#include "estruturas.hpp"
#include"data.hpp"


void dispTitulo(Titulo_Eleitor el){
    cout << "****************** Titulo Eleitoral ******************" << endl;
    cout << "Nome do eleitor:         " << el.nome << endl
         << "Data de nascimento:      ";
         dispData(el.dt_nasc);
    cout << "Numero de inscricao:     " << el.num_inscr << endl
         << "Zona e secao de votacao: " << el.zona << " - " << el.secao << endl
         << "Muncipio do eleitor:     " << el.municipio << " - " << el.UF << endl
         << "Data de emissao:         ";
         dispData(el.dt_emiss);
    return;
}

void setTitulo(Titulo_Eleitor *el){
    cout << "Digite o nome do eleitor: ";
    getline(cin, el->nome);
    cout << "Digite a data de nascimento: " << endl;
    getData(&(*el).dt_nasc);
    cout << "Digite o numero de inscricao: ";
    cin.ignore();
    getline(cin, el->num_inscr);
    cout << "Digite o numero da zona e da secao: ";
    cin >> el->zona >> el->secao;
    cout << "Informe o nome do municipio e da UF: ";
    cin >> el->municipio >> el->UF;
    cout << "Digite a data da emissao: " << endl;
    getData(&(*el).dt_emiss);
}

#endif // TITULO_HPP
