#if !defined(FUNCIONARIO_HPP)
#define FUNCIONARIO_HPP

#include "Usuario.hpp"

class Aluguel;

class Funcionario: public Usuario{
    protected:
        vector<Aluguel*> historicoAlugueis;
    public:
        Funcionario(string _cpf, string _nome, string _endereco, string _telefone): Usuario(_cpf, _nome, _endereco, _telefone){};
        void addAluguel(Aluguel* novo);
        vector<Aluguel*> getHistoricoAlugueis();
        ~Funcionario(){};
};

#endif // FUNCIONARIO_HPP
