#include"Gato.hpp"
#include"Cachorro.hpp"
#include<vector>

int main(){

    vector<Animal*> animais;
    Cachorro c1("Zeus", 5);
    Gato g1("Francisco", 2);
    Gato g2("Cleo", 3);

    animais.push_back(&c1);
    animais.push_back(&g1);
    animais.push_back(&g2);

    for(Animal* a : animais){
        a->fazerSom();
    }

    return 0;
}