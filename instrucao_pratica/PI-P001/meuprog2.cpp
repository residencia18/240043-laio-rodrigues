#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

int main(void){
    cout << fixed << setprecision(1);
    float A, B;

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


    return 0;
}