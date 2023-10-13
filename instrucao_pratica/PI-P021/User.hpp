#if !defined(USER_HPP)
#define USER_HPP

#include<string>
#include<vector>

using namespace std;

class Usuario{
    private:
        static int cont;
        string id;
        string nome;
        string email;
        string senha;
    public:
        Usuario(){}
        Usuario(string, string, string);

        void setCont(int);
        void setId(string);
        void setNome(string);
        void setEmail(string);
        void setSenha(string);
        bool autentica(string);
        
        string getNome();
        string getEmail();
        string getSenha();
        string getId();

        static string dispToString();
        string toString();

        ~Usuario(){}
};

#endif // USER_HPP
