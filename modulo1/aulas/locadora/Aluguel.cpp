#include"Aluguel.hpp"

Aluguel::Aluguel(){
    cont++;
    this->id = to_string(cont);
}

void Aluguel::setStatus(string _status) {
    this->status = _status;
}

void Aluguel::setCliente(Cliente* _cliente){
    this->cliente = _cliente;
}

void Aluguel::setVeiculo(Veiculo* _veiculo){
    this->veiculo = _veiculo;
}

void Aluguel::setFuncionario(Funcionario* _funcionario){
    this->funcionario = _funcionario;
}

void Aluguel::setDt_inicio(Data* _dt_inicio){
    this->dt_inicio = _dt_inicio;
}

void Aluguel::setDt_termino(Data* _dt_termino){
    this->dt_termino = _dt_termino;
}

void Aluguel::setDt_devolucao(Data* _dt_devolucao){
    this->dt_devolucao = _dt_devolucao;
}

void Aluguel::setDesconto(float _desconto){
    this->desconto = _desconto;
}

void Aluguel::setAdicional(float _adicional){
    this->adicional = _adicional;
}

Veiculo* Aluguel::getVeiculo(){
    return this->veiculo;
}

Cliente* Aluguel::getCliente(){
    return this->cliente;
}

Funcionario* Aluguel::getFuncionario(){
    return this->funcionario;
}

Data* Aluguel::getDt_inicio(){
    return this->dt_inicio;
}

Data* Aluguel::getDt_termino(){
    return this->dt_termino;
}

Data* Aluguel::getDt_devolucao(){
    return this->dt_devolucao;
}

float Aluguel::getDesconto(){
    return this->desconto;
}

float Aluguel::getAdicional(){
    return this->adicional;
}

string Aluguel::getId(){
    return this->id;
}

float Aluguel::calcularValorFinal(){
    int dias;
    dias = this->dt_inicio->diaEntre(dt_termino);
    
    float valorFinal = dias * this->veiculo->getPrecoDiario();
    valorFinal -= this->getDesconto();
    valorFinal += this->getAdicional();

    if(this->verificaStatus().compare("atrasada") == 0){
        dias = dt_termino->diaEntre(dt_devolucao);
        this->setAdicional(5.0 * dias * this->veiculo->getPrecoDiario());
    }
    return valorFinal;
}

string Aluguel::verificaStatus(){
    return this->status;
}

string Aluguel::toString(){
    string texto;
    texto = "Aluguel de numero " + this->id + "\n\n" + 
            "\tVeiculo alugado:\n" + this->veiculo->toString() + "\n\n" + 
            "\tCliente:\n" + this->cliente->toString() + "\n\n" + 
            "\tFuncionario do atendimento:\n" + this->funcionario->toString() + "\n\n" +  
            "\tData de inicio do aluguel\n: " + this->dt_inicio->toString() + "\n\n";
    string status = verificaStatus();
    if(status.compare("finalizada") != 0){
        texto += "\tData prevista de termino do aluguel:\n" + this->dt_termino->toString() + "\n\n";
    }else{
        texto += "\tData de devolucao do veiculo:\n" + this->dt_devolucao->toString() + "\n\n";
    }
    texto += "Valor final do aluguel: " + to_string(calcularValorFinal()) + "\n";
    return texto;
}

