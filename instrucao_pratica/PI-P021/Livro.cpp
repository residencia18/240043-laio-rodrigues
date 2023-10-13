#include"Livro.hpp"

Livro::Livro(string titulo, string autor, int copias){
    cont++;
    this->id = to_string(cont);
    this->titulo = titulo;
    this->autor = autor;
    this->copiasTotais = copias;
    this->copias = copias;
}

void Livro::setCont(int cont){
    this->cont = cont;
}

void Livro::setId(string id){
    this->id = id;
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

string Livro::dispToString(){
    return "#Id\tDisponiveis\tEstoque\tLivro\t\t\t\tAutor";

}

string Livro::toString(){
    return "#" + this->id + "\t" + to_string(this->copias) + "\t\t" + to_string(this->copiasTotais) + "\t" + this->titulo + "\t\t" + this->autor;
}

string Livro::dispToStringEmp(){
    return "#Id\tStatus\t\tData de Devolucao\tLivro\t\t\tAutor";
}

string Livro::toStringEmp(string status, string dev){
    return "#" + this->id + "\t" + status + "\t" + dev + "\t\t" + this->titulo + "\t" + this->autor;
}