#if !defined(INTECLIENTE_HPP)
#define INTECLIENTE_HPP

#include"../Cliente.hpp"
#include"../Veiculo.hpp"
#include"../Aluguel.hpp"
#include"../Data.hpp"

class InteCliente{
    private:
        Cliente* cliente;
        vector<Veiculo*> veiculos;
        vector<Aluguel*> alugueis;
        int posicao = 0;
        
    public:
        InteCliente(Cliente* _cliente, vector<Veiculo*> _veiculos, vector<Aluguel*> _alugueis);
        float cotarAluguel(Veiculo* _veiculo, Data* _dt_inicio, Data* _dt_termino);
        Aluguel* solicitaAluguel(Veiculo* _veiculo, Data* _dt_inicio, Data* _dt_termino);
        void devolverVeiculo(Aluguel* _aluguel, Data* _dt_devolucao);
        int dispMenu();
        void Menu();

        ~InteCliente(){}
};

#endif // i-CLIENTE_HPP
