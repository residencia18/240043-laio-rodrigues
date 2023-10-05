#include"Veiculo.hpp"

Veiculo::Veiculo(string _placa, string _marca, string _modelo, int _ano, float _precoDiario){
    this->placa = _placa;
    this->marca = _marca;
    this->modelo = _modelo;
    this->ano = _ano;
    this->precoDiario = _precoDiario;
}

void Veiculo::setPlaca(string _placa){
    this->placa = _placa;
}

void Veiculo::setMarca(string _marca){
    this->marca = _marca;
}

void Veiculo::setModelo(string _modelo){
    this->modelo = _modelo;
}

void Veiculo::setAno(int _ano){
    this->ano = _ano;
}

void Veiculo::setPrecoDiario(float _precoDiario){
    this->precoDiario = _precoDiario;
}

string Veiculo::getPlaca(){
    return this->placa;
}

string Veiculo::getMarca(){
    return this->marca;
}

string Veiculo::getModelo(){
    return this->modelo;
}

int Veiculo::getAno(){
    return this->ano;
}

float Veiculo::getPrecoDiario(){
    return this->precoDiario;
}

string Veiculo::toString(){
    return "Placa: " + this->placa + 
    "\nMarca: " + this->marca + 
    "\nModelo: " + this->modelo + 
    "\nAno: " + to_string(this->ano) + 
    "\nPreço diário: " + to_string(this->precoDiario);
}