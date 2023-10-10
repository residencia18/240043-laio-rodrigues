#if !defined(USER_HPP)
#define USER_HPP

#include"Utilitarios.hpp"

class Usuario{
    private:
        static vector<Usuario*> lista;
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
        static vector<Usuario*> getLista();
        

        ~Usuario(){}
};

#endif // USER_HPP
