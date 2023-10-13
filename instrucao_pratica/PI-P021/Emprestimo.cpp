#include"Emprestimo.hpp"

Emprestimo::Emprestimo(Livro* _livro, Usuario* _usuario, string _status, Data* _dt_retirada, int _tempo){
    cont++;
    this->id = to_string(cont);
    this->livro = _livro;
    this->usuario = _usuario;
    this->status = _status;
    this->dt_retirada = _dt_retirada;
    Data* dt_nova = new Data(_dt_retirada->getDia(), _dt_retirada->getMes(), _dt_retirada->getAno());
    dt_nova->somaDias(_tempo);
    this->dt_devolucao = dt_nova;
}

void Emprestimo::setCont(int cont){
    this->cont = cont;
}

void Emprestimo::setId(string id){
    this->id = id;
}

void Emprestimo::setLivro(Livro* _livro){
    this->livro = _livro;
}

void Emprestimo::setUsuario(Usuario* _usuario){
    this->usuario = _usuario;
}

void Emprestimo::setStatus(string _status){
    this->status = _status;
}

void Emprestimo::setDt_retirada(Data* _retirada){
    this->dt_retirada = _retirada;
}

void Emprestimo::setDt_devolucao(Data* devolucao){
    this->dt_devolucao = devolucao;
}

string Emprestimo::getId(){
    return this->id;
}

Livro* Emprestimo::getLivro(){
    return this->livro;
}

Usuario* Emprestimo::getUsuario(){
    return this->usuario;
}

string Emprestimo::getStatus(){
    return this->status;
}

Data* Emprestimo::getDt_retirada(){
    return this->dt_retirada;
}

Data* Emprestimo::getDt_devolucao(){
    return this->dt_devolucao;
}

string Emprestimo::toString(){
    return "#" + this->id + "\t" + this->livro->getTitulo() + "\t" + this->usuario->getNome() + "\t" + 
        this->status + "\t" + this->dt_retirada->toString() + "\t" + this->dt_devolucao->toString();
}