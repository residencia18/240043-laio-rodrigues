#include"Tweet.hpp"

Tweet::Tweet(Usuario* _usuario, string conteudo, Data* dt){
    this->autor = _usuario;
    this->conteudo = conteudo;
    this->dt_criacao = dt;
}

void Tweet::setAutor(Usuario* novo){
    this->autor = novo;
}

void Tweet::setConteudo(string _conteudo){
    this->conteudo = _conteudo;
}

void Tweet::setDt_criacao(Data* dt){
    this->dt_criacao = dt;
}

Usuario* Tweet::getAutor(){
    return this->autor;
}

string Tweet::getConteudo(){
    return this->conteudo;
}

Data* Tweet::getDt_criacao(){
    return this->dt_criacao;
}
