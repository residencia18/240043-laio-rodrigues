#include<iostream>
#include<math.h>
#include<string>
#include<vector>

using namespace std;

int fatorial(int num){
    int fat = 1;

    if (num <= 0){
        cout << "Numero" << num << " invalido!" << endl;
        exit(0);
    }
    
    for (int i = 1; i <= num; i++){
        fat *= i;
    }
    return fat;
}

int combinacao(int n, int p){
    return (fatorial(n)/(fatorial(p)*fatorial(n-p)));
}

int arranjo(int n, int p){
    return (fatorial(n)/fatorial(n-p));
}

int main(){
    int n, p;
    char opc;

    cout << "Digite o total de itens: ";
    cin >> n;
    cout << "Digite quantos serao tomados: ";
    cin >> p;
    cout << "Combinacao (C) ou Arranjo (A): ";
    cin >> opc;

    cout << endl << n << " itens tomados " << p << " a " << p << endl;
    if (opc == 'c' || opc == 'C'){
        cout << "Combinacao de " << combinacao(n,p) << " maneiras!" << endl; 
    }else if (opc == 'a' || opc == 'A'){
        cout << "Arranjo de " << arranjo(n,p) << " maneiras!" << endl; 
    }

    


    return 0;
}