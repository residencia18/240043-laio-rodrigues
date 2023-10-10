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

void Usuario::addUsuario(Usuario* novo){
    lista.push_back(novo);
}

void Usuario::removerUsuario(size_t idx){
    lista.erase(lista.begin() + idx);
}

void Usuario::alterarEmailUsuario(size_t idx, string email){
    lista[idx]->setEmail(email);
}

void Usuario::alterarSenhaUsuario(size_t idx, string senha){
    lista[idx]->setSenha(senha);
}

int Usuario::getIdx(string id){
    for(size_t i = 0; i < lista.size(); i++){
        if(lista[i]->getId().compare(id) == 0){
            return i;
        }
    }
    return -1;
}

Usuario* Usuario::getUsuario(size_t idx){
    return lista[idx];
}

vector<Usuario*> Usuario::getLista(){
    return lista;
}






