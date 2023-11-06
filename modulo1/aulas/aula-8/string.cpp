#include<iostream>
#include<string>

using namespace std;

int main(){
    string nome, sobrenome, completo;

    cout << "Digite seu nome: ";
    cin >> nome;
    cout << "Digite seu sobrenome: ";
    cin >> sobrenome;
    completo = nome + " " + sobrenome;

    cout << endl << "Olá " << completo << endl;

    return 0;
}