#if !defined(BIBLIOTECA_HPP)
#define BIBLIOTECA_HPP

#include"Emprestimo.hpp"
#include"Menu.hpp"

class Biblioteca{
    private:
        static vector<Livro*> livros;
        static vector<Usuario*> usuarios;
    public:
        Biblioteca(){}

        static void init();

        static void addUsuario(Usuario*);
        static void removerUsuario(size_t);
        static void alterarEmailUsuario(size_t, string);
        static void alterarSenhaUsuario(size_t, string);
        static int getIdxUsuarioByNome(string, string);
        static int getIdxUsuarioById(string);
        static Usuario* getUsuario(size_t);
        static vector<Usuario*> getListaUsuario();

        static void addLivro(Livro*);
        static void removeLivro(size_t);
        static void alterarQTD(size_t, int);
        static int getIdxLivroById(string);
        static int getIdxLivroByNome(string, string);
        static Livro* getLivro(size_t);
        static vector<Livro*> getLista();

        ~Biblioteca(){}
};

#endif // BIBLIOTECA_HPP
