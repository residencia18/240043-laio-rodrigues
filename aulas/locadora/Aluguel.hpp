#if !defined(ALUGUEL_HPPU)
#define ALUGUEL_HPP

#include"Utilitarios.hpp"
#include"Veiculo.hpp"
#include"Cliente.hpp"
#include"Funcionario.hpp"
#include"Data.hpp"

class Aluguel{
    private:
        static int cont;
        string id;
        string status; //agendado, iniciado, atrasado, em devolucao, finalizado
        Veiculo* veiculo;
        Cliente* cliente;
        Funcionario* funcionario;
        Data* dt_inicio;
        Data* dt_termino;
        Data* dt_devolucao;
        float desconto;
        float adicional;

    public:
        Aluguel();
        void setStatus(string _status);
        void setVeiculo(Veiculo* _veiculo);
        void setCliente(Cliente* _cliente);
        void setFuncionario(Funcionario* _funcionario);
        void setDt_inicio(Data* _dt_inicio);
        void setDt_termino(Data* _dt_termino);
        void setDt_devolucao(Data* _dt_devolucao);
        void setDesconto(float _desconto);
        void setAdicional(float _adicional);
        string getId();
        Veiculo* getVeiculo();
        Cliente* getCliente();
        Funcionario* getFuncionario();
        Data* getDt_inicio();
        Data* getDt_termino();
        Data* getDt_devolucao();
        float getDesconto();
        float getAdicional();
        string toString();
        float calcularValorFinal();
        string verificaStatus();
        ~Aluguel(){}
};

#endif // ALUGUEL_HPP
