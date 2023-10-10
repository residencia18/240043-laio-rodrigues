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