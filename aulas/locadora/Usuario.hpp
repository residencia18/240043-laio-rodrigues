#if !defined(USUARIO_HPP)
#define USUARIO_HPP

#include<iostream>
#include<string>
#include<vector>

using namespace std;

class Usuario{
    protected:
        string cpf;
        string nome;
        string endereco;
        string telefone;
    public:
        Usuario(string _cpf, string _nome, string _endereco, string _telefone);
        void setCPF(string _cpf);
        void setNome(string _nome);
        void setEndereco(string _endereco);
        void setTelefone(string _telefone);
        string getCPF();
        string getNome();
        string getEndereco();
        string getTelefone();
        string toString();
        ~Usuario(){};
};

#endif // USUARIO_HPP
