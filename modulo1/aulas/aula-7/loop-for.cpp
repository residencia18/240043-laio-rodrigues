#include<iostream>
#include<math.h>

using namespace std;

bool isPrimo(int num){
    int i;
    for (i = 2; i <= sqrt(num) ; i++){
        if(num%i == 0){
            return false;
        }
    }
    return true;
}

int main(){
    int i = 2, j = 0, num;

    cout << "Digite um número: ";
    cin >> num;
    cout << endl;

    while (j < num){
        if (isPrimo(i)){
            cout << i << ", ";
            j++;
        }
        i++;
    }
    

    for (i = 1; i < num; i++){
        
    }
    
    
    return 0;
}