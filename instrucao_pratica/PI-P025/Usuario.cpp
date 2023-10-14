#include"Usuario.hpp"

Usuario::Usuario(string _username, string _nome, string _senha){
    this->username = _username;
    this->nome = _nome;
    this->senha = _senha;
}

void Usuario::setUsername(string _username){
    this->username = _username;
}

void Usuario::setNome(string _nome){
    this->nome = _nome;
}

void Usuario::setSenha(string _senha){
    this->senha = _senha;
}


string Usuario::getUsername(){
    return this->username;
}

string Usuario::getNome(){
    return this->nome;
}

string Usuario::getSenha(){
    return this->senha;
}

vector<Usuario*> Usuario::getSeguidores(){
    return this->seguidores;
}

Usuario* Usuario::getSeguidor(string _username){
    for(Usuario* u : this->seguidores){
        if(u->getUsername() == _username){
            return u;
        }
    }
    Menu::error("Usuario nao encontrado!");
    return NULL;
}

vector<Usuario*> Usuario::getSeguindo(){
    return this->seguindo;
}

Usuario* Usuario::getSeguiu(string _username){
    for(Usuario* u : this->seguindo){
        if(u->getUsername() == _username){
            return u;
        }
    }
    Menu::error("Usuario nao encontrado!");
    return NULL;
}


void Usuario::addSeguidor(Usuario* novo){
    this->seguidores.push_back(novo);
}

void Usuario::addSeguindo(Usuario* novo){
    this->seguindo.push_back(novo);
}

int Usuario::getIdxSeguidor(string _username){
    for(size_t i = 0; i < this->seguidores.size(); i++){
        if(this->seguidores[i]->getUsername() == _username){
            return i;
        }
    }
    Menu::error("Usuario nao encontrado");
    return -1;
}

int Usuario::getIdxSeguindo(string _username){
    for(size_t i = 0; i < this->seguindo.size(); i++){
        if(this->seguindo[i]->getUsername() == _username){
            return i;
        }
    }
    Menu::error("Usuario nao encontrado!");
    return -1;
}

void Usuario::removeSeguidor(string _username){
    int idx = getIdxSeguidor(_username);
    if(idx >= 0){
        delete this->seguidores[idx];
        this->seguidores.erase(this->seguidores.begin() + idx);
    }
}

void Usuario::removeSeguindo(string _username){
    int idx = getIdxSeguindo(_username);
    if(idx >= 0){
        this->seguindo[idx]->removeSeguidor(this->getUsername());
        delete this->seguindo[idx];
        this->seguindo.erase(this->seguindo.begin() + idx);
        Menu::success("Usuario nao esta mais sendo seguido!");
    }
}

bool Usuario::isSeguidor(string _username){
    for(Usuario* u : this->seguidores){
        if(u->getUsername() == _username){
            return true;
        }
    }
    return false;
}

bool Usuario::isSeguindo(string _username){
    for(Usuario* u : this->seguindo){
        if(u->getUsername() == _username){
            return true;
        }
    }
    return false;
}

string Usuario::printSeguidores(){
    string ret = "";
    for(Usuario* u : this->seguidores){
        ret += u->getUsername() + "\n";
    }
    return ret;
}

string Usuario::printSeguindo(){
    string ret = "";
    for(Usuario* u : this->seguindo){
        ret += u->getUsername() + "\n";
    }
    return ret;
}

string Usuario::printUsuario(){
    string ret = "";
    ret += this->getUsername() + "\t";
    ret += this->getNome() + "\t";
    ret += to_string(this->seguidores.size()) + "\t";
    ret += to_string(this->seguindo.size());
    return ret;
}