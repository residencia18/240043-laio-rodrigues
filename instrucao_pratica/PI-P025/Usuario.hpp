#if !defined(USUARIO_HPP)
#define USUARIO_HPP

#include "Menu.hpp"

class Usuario{
    private:
        string username;
        string nome;
        string senha;
        vector<Usuario*> seguidores;
        vector<Usuario*> seguindo;
    public:
        Usuario(){}
        Usuario(string, string, string);

        void setUsername(string);
        void setNome(string);
        void setSenha(string);

        string getUsername();
        string getNome();
        string getSenha();
        vector<Usuario*> getSeguidores();
        Usuario* getSeguidor(string);
        vector<Usuario*> getSeguindo();
        Usuario* getSeguiu(string);

        void addSeguidor(Usuario*);
        void addSeguindo(Usuario*);
        int getIdxSeguidor(string);
        int getIdxSeguindo(string);
        void removeSeguidor(string);
        void removeSeguindo(string);
        bool isSeguidor(string);
        bool isSeguindo(string);
        string printSeguidores();
        string printSeguindo();
        string printUsuario();

        ~Usuario(){}
};

#endif // USUARIO_HPP
