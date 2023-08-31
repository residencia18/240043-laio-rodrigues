#include<iostream>

using namespace std;

int main(){
    int soma = 0, a = 0;

    
    while (a>=0){
        cout << endl << "Digite um numero: ";
        cin >> a;
        soma += a;
        cout << endl << "Soma total = " << soma << endl;
    }
    

    // do{
    //     cout << "Digite um numero: ";
    //     cin >> a;

    // } while (a>=0);
    

    return 0;
}