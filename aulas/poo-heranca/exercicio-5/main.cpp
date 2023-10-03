#include"Estado.hpp"

int main(){
    vector<Estado> brasil;
    vector<Cidade> cidades;

    Estado ba("Bahia", "BA");
    Estado pe("Pernambuco", "PE");
    Estado sp("Sao Paulo", "SP");

    Cidade b1("Camacan");
    ba.setCidade(b1);
    Cidade b2("Itabuna");
    ba.setCidade(b2);
    Cidade b3("Salvador");
    ba.setCidade(b3);

    Cidade p1("Petrolina");
    pe.setCidade(p1);
    Cidade p2("Recife");
    pe.setCidade(p2);
    Cidade p3("Olinda");
    pe.setCidade(p3);

    Cidade s1("Sao Paulo");
    sp.setCidade(s1);
    Cidade s2("Santos");
    sp.setCidade(s2);
    Cidade s3("Sumare");
    sp.setCidade(s3);

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

    for(Estado e : brasil){
        for(Cidade c : e.getCidades()){
            cout << c.toString() << ", " << e.toString() << endl;
        }
    }

    return 0;
}