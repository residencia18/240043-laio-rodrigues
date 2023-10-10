#if !defined(USER_HPP)
#define USER_HPP

#include"Utilitarios.hpp"

class Emprestimo;

class Usuario{
    private:
        vector<Emprestimo*> listaEmprestimo;
        static int cont;
        string id;
        string nome;
        string email;
        string senha;
    public:
        Usuario(){}
        Usuario(string, string, string);

        void setNome(string);
        void setEmail(string);
        void setSenha(string);
        void addEmprestimo(Emprestimo*);
        void removerEmprestimo(size_t);
        bool autentica(string);

        Emprestimo* getEmprestimo(size_t);
        vector<Emprestimo*> getListaEmprestimo();
        string getNome();
        string getEmail();
        string getSenha();
        string getId();
        string toString();

        ~Usuario(){}
};

#endif // USER_HPP
