#include"Cidade.hpp"
#include<vector>

int main(){
    vector<Estado> brasil;
    vector<Cidade> cidades;

    Estado ba("Bahia", "BA");
    Estado pe("Pernambuco", "PE");
    Estado sp("Sao Paulo", "SP");

    Cidade b1("Camacan", &ba);
    Cidade b2("Itabuna", &ba);
    Cidade b3("Salvador", &ba);

    Cidade p1("Petrolina", &pe);
    Cidade p2("Recife", &pe);
    Cidade p3("Olinda", &pe);

    Cidade s1("Sao Paulo", &sp);
    Cidade s2("Santos", &sp);
    Cidade s3("Sumare", &sp);

    brasil.push_back(ba);
    brasil.push_back(pe);
    brasil.push_back(sp);

    cidades.push_back(s1);
    cidades.push_back(p3);
    cidades.push_back(b1);
    cidades.push_back(s3);
    cidades.push_back(b3);
    cidades.push_back(p1);
    cidades.push_back(b2);
    cidades.push_back(s2);
    cidades.push_back(p2);

    for(Cidade c : cidades){
        cout << c.toString() << endl;
    }

    return 0;
}