#include<iostream>
#include<math.h>

using namespace std;

int main(){
    int a, b, c, delta;
    float x1, x2;

    cout << "Digite o coeficiente a: ";
    cin >> a;
    cout << endl;
    cout << "Digite o coeficiente b: ";
    cin >> b;
    cout << endl;
    cout << "Digite o coeficiente c: ";
    cin >> c;
    cout << endl; 

    delta = pow(b, 2) - 4*a*c;

    if (delta >= 0){
        x1 = (-b + sqrt(delta))/2*a;
        
        cout << "A equação tem como raízes: " << endl;
        cout << "x1 = " << x1 << endl;

        if(delta > 0){
            x2 = (-b - sqrt(delta))/2*a; 
            cout << "x2 = " << x2 << endl;
        }
    }else{
        cout << "Não há raízes reais!";
    }
    


    return 0;
}