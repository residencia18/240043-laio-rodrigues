#include<iostream>
#include<math.h>

using namespace std;

int main(){
    int i, j, num;
    bool flag;

    cout << "Digite um número: ";
    cin >> num;
    cout << endl;

    for (i = 1; i < num; i++){
        flag = true;
        for (j = 2; j <= sqrt(i); j++){
            if(j%i == 0){
                flag = false;
                break;
            }
        }
        if (flag){
            cout << i;
        }
    }
    return 0;
}