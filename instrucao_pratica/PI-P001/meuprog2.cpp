#include <iostream>
#include <string>

using namespace std;

int main(void){

    int A, B;

    cout << "Digite dois numeros, A e B: ";
    cout << endl;
    cout << "A = ";
    cin >> A;
    cout << "B = ";
    cin >> B;

    cout << endl;
    cout << "Soma = " << A+B;
    cout << endl;
    cout << "Subtracao = " << A-B;
    cout << endl;
    cout << "Multiplicacao = " << A*B;
    cout << endl;
    cout << "Divisao = " << A/B;
    cout << endl;
    cout << "Resto = " << A%B;


    return 0;
}