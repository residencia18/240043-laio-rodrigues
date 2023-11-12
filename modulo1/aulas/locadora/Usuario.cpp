#include"Usuario.hpp"


void Usuario::setCPF(string _cpf){
    this->cpf = _cpf;
}

void Usuario::setEndereco(string _endereco){
    this->endereco = _endereco;
}

void Usuario::setNome(string _nome){
    this->nome = _nome;
}

void Usuario::setTelefone(string _telefone){
    this->telefone = _telefone;
}

string Usuario::getCPF(){
    return this->cpf;
}

string Usuario::getEndereco(){
    return this->endereco;
}

string Usuario::getNome(){
    return this->nome;
}

string Usuario::getTelefone(){
    return this->telefone;
}

string Usuario::toString(){
    string texto;
    texto = "CPF: " + this->cpf +
            "\nNome: " + this->nome +
            "\nEndereco: " + this->endereco +
            "\nTelefone: " + this->telefone + "\n";
    return texto;
}