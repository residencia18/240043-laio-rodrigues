#include<iostream>
#include<string>

using namespace std;

int main(void){
    string nome;
    int anoNascimento;
    cout << "Digite seu nome: ";
    cin >> nome;
    cout << "Bom dia, " << nome << ". Tenha um bom curso.";
    cout << endl;
    cout << nome << ", voce nasceu em que ano? ";
    cin >> anoNascimento;
    cout << "Considerando que estamos em 2023, ou voce tem "
        << 2023-anoNascimento
        << " anos, ou está próximo de fazer."
        << endl;

    return 0;
}