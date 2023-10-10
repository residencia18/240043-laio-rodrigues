#include"Livro.hpp"

Livro::Livro(string titulo, string autor, int copias){
    cont++;
    this->id = to_string(cont);
    this->titulo = titulo;
    this->autor = autor;
    this->copiasTotais = copias;
    this->copias = copias;
}

void Livro::setTitulo(string titulo){
    this->titulo = titulo;
}

string Livro::getTitulo(){
    return this->titulo;
}

void Livro::setAutor(string autor){
    this->autor = autor;
}

string Livro::getAutor(){
    return this->autor;
}

void Livro::setCopiasTotais(int copiasTotais){
    this->copiasTotais = copiasTotais;
}

int Livro::getCopiasTotais(){
    return this->copiasTotais;
}

void Livro::setCopias(int copias){
    this->copias = copias;
}

int Livro::getCopias(){
    return this->copias;
}

string Livro::getId(){
    return this->id;
}

string Livro::toString(){
    return "#" + this->id + "\t" + this->titulo + "\t" + this->autor + "\t" + to_string(this->copias);
}

void Livro::addLivro(Livro* livro){
    lista.push_back(livro);
}

void Livro::removeLivro(size_t idx){
    lista.erase(lista.begin() + idx);
}

void Livro::alterarQTD(size_t idx, int qtd){
    int i = qtd - lista[idx]->getCopiasTotais();
    lista[idx]->setCopiasTotais(qtd);
    lista[idx]->setCopias(lista[idx]->getCopias() + i);
}

int Livro::getIdx(string id){
    for(size_t i = 0; i < lista.size(); i++){
        if(lista[i]->getId().compare(id) == 0){
            return i;
        }
    }
    return -1;
}

Livro* Livro::getLivro(size_t idx){
    return lista[idx];
}

vector<Livro*> Livro::getLista(){
    return lista;
}