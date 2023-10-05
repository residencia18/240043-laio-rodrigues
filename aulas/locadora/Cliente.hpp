#if !defined(CLIENTE_HPP)
#define CLIENTE_HPP

#include"Usuario.hpp"

class Aluguel;

class Cliente: public Usuario{
    private:
        string habilitacao;
        vector<Aluguel*> historicoAlugueis;
    public:
        Cliente(string _cpf, string _nome, string _endereco, string _telefone, string _habilitacao);
        void setHabilitacao(string _habilitacao);
        string getHabilitacao();
        void addAluguel(Aluguel* novo);
        vector<Aluguel*> getHistoricoAlugueis();
        ~Cliente();
};

#endif // CLIENTE_HPP
