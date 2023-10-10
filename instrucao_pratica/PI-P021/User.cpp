#include"User.hpp"

Usuario::Usuario(string nome, string email, string senha){
    cont++;
    this->id = to_string(cont);
    this->nome = nome;
    this->email = email;
    this->senha = senha;
}

void Usuario::setNome(string nome){
    this->nome = nome;
}

void Usuario::setEmail(string email){
    this->email = email;
}

void Usuario::setSenha(string senha){
    this->senha = senha;
}

string Usuario::getNome(){
    return this->nome;
}

string Usuario::getEmail(){
    return this->email;
}

string Usuario::getSenha(){
    return this->senha;
}

string Usuario::getId(){
    return this->id;
}

string Usuario::toString(){
    return "#" + this->id + "\t" + this->nome + "\t" + this->email;
}

bool Usuario::autentica(string senha){
    return this->senha.compare(senha) == 0;
}

void Usuario::addEmprestimo(Emprestimo* novo){
    listaEmprestimo.push_back(novo);
}

void Usuario::removerEmprestimo(size_t idx){
    listaEmprestimo.erase(listaEmprestimo.begin() + idx);
}

Emprestimo* Usuario::getEmprestimo(size_t idx){
    return listaEmprestimo[idx];
}

vector<Emprestimo*> Usuario::getListaEmprestimo(){
    return listaEmprestimo;
}





