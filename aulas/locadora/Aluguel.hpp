#if !defined(ALUGUEL_HPPU)
#define ALUGUEL_HPP

#include<string>

using namespace std;

class Veiculo;
class Cliente;
class Funcionario;
class Data;

class Aluguel{
    private:
        string id;
        Veiculo* veiculo;
        Cliente* cliente;
        Funcionario* funcionario;
        

    public:
        Aluguel();
        ~Aluguel();
};

#endif // ALUGUEL_HPP
