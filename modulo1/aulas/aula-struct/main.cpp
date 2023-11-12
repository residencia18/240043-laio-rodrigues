#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include "data.hpp"
#include "estruturas.hpp"
#include "Titulo.hpp"

using namespace std;

int main(){
    Titulo_Eleitor el;
    system("clear");
    setTitulo(&el);
    system("clear");
    dispTitulo(el);

    cout << "Tempo de emissao: " << anosCompletos(el.dt_emiss, el.dt_nasc) << endl;
   return 0;
}