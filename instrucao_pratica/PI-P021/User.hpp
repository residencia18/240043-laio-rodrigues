#if !defined(USER_HPP)
#define USER_HPP

#include"Utilitarios.hpp"

class Emprestimo;

class Usuario{
    private:
        static vector<Usuario*> listaUsuario;
        vector<Emprestimo*> listaEmprestimo;
        static int cont;
        string id;
        string nome;
        string email;
        string senha;
    public:
        Usuario(string, string, string);

        void setNome(string);
        void setEmail(string);
        void setSenha(string);
        void addEmprestimo(Emprestimo*);
        void removerEmprestimo(size_t);
        void alterarStatusEmprestimo(size_t, string);

        Emprestimo* getEmprestimo(size_t);
        vector<Emprestimo*> getListaEmprestimo();
        string getNome();
        string getEmail();
        string getSenha();
        string getId();
        string toString();

        static void addUsuario(Usuario*);
        static void removerUsuario(size_t);
        static void alterarEmailUsuario(size_t, string);
        static void alterarSenhaUsuario(size_t, string);

        static int getIdx(string);
        static Usuario* getUsuario(size_t);
        static vector<Usuario*> getListaUsuario();
        

        ~Usuario(){}
};

#endif // USER_HPP
