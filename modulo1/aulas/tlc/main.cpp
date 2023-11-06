#include"Numero.hpp"

int main(){

    int a;

    cout << ">" << endl;
    cin >> a;

    Numero* v1 = new Numero(a);
    Numero* v2 = new Numero(a);

    v1->preencherVetor(1, 10);
    v2->TLCpreencherVetor(1, 10);
    cout << v1->desvio() << endl;
    cout << v2->desvio() << endl;

    return 0;
}