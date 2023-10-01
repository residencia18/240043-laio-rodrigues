#include"ItemSet.hpp"

int main(){
    ItemSet conjuntoA;
    conjuntoA.inserir("Item1");
    conjuntoA.inserir("Item2");

    ItemSet conjuntoB;
    conjuntoB.inserir("Item3");
    conjuntoB.inserir("Item4");

    ItemSet conjuntoC;
    conjuntoC.inserir("Item2");
    conjuntoC.inserir("Item4");

    // Atribuir os itens de B a A usando a sobrecarga do operador =
    conjuntoA = conjuntoB;

    cout << "Conjunto A após a atribuição de B:" << endl;
    conjuntoA.listarItens();

    // Realizar a união de B e C e atribuir o resultado a A usando a sobrecarga do operador +
    conjuntoA = conjuntoB + conjuntoC;

    cout << "Conjunto A após a união de B e C:" << endl;
    conjuntoA.listarItens();

    // Realizar a união de B e C e atribuir o resultado a A usando a sobrecarga do operador +
    conjuntoA = conjuntoB + conjuntoC;

    cout << "Conjunto A após a união de B e C:" << endl;
    conjuntoA.listarItens();

    // Realizar a interseção de B e C e atribuir o resultado a A usando a sobrecarga do operador *
    conjuntoA = conjuntoB * conjuntoC;

    cout << "Conjunto A após a interseção de B e C:" << endl;
    conjuntoA.listarItens();

    // Calcular a diferença de B e C e atribuir o resultado a A usando a sobrecarga do operador -
    conjuntoA = conjuntoB - conjuntoC;

    cout << "Conjunto A após a diferença de B e C:" << endl;
    conjuntoA.listarItens();

    // Calcular o delta de B e C e atribuir o resultado a A usando a sobrecarga do operador <>
    conjuntoA = conjuntoB % conjuntoC;

    cout << "Conjunto A após o delta de B e C:" << endl;
    conjuntoA.listarItens();

    // Comparar conjuntoA e conjuntoB usando a sobrecarga do operador ==
    if (conjuntoA == conjuntoB) {
        cout << "Conjunto A é igual a B." << endl;
    } else {
        cout << "Conjunto A é diferente de B." << endl;
    }

    // Comparar conjuntoA e conjuntoC usando a sobrecarga do operador ==
    if (conjuntoA == conjuntoC) {
        cout << "Conjunto A é igual a C." << endl;
    } else {
        cout << "Conjunto A é diferente de C." << endl;
    }

    return 0;
}