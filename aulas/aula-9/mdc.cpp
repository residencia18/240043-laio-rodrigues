#include<iostream>
#include<math.h>

using namespace std;

int mdc(int a, int b){
    if (a > b){
        a += b;
        b = a-b;
        a -= b;
    }
    if(b%a == 0){
        return a;
    }
    return mdc(b%a, a);
}

int main(){
    int a, b, m;

    cout << endl;
    cin >> a >> b;

    m = mdc(a, b);

    cout << endl << " -> " << m << endl;


    return 0;
}