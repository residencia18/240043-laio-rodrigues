#if !defined(BIBLIOTECA_HPP)
#define BIBLIOTECA_HPP

#include"Emprestimo.hpp"
#include"Menu.hpp"
#include<fstream>
#include<sstream>

class Biblioteca{
    private:
        static vector<Livro*> livros;
        static vector<Usuario*> usuarios;
        static vector<Emprestimo*> emprestimos;

    public:
        Biblioteca(){}

        static void init();

        static void abrirArqUser();
        static void abrirArqLivros();
        static void abrirArqEmprestimo();

        static void salvarArqUser();
        static void salvarArqLivros();
        static void salvarArqEmprestimo();

        static Livro* getLivroByNome();
        static Livro* getLivroById();
        static Usuario* getUserById();
        static Usuario* getUsuarioByNome();
        static bool autentica(Usuario*);

        static void emprestimo();
        static void pesquisa();
        static void devolucao();

        static void menuLivro();
        static void novoLivro();
        static void rmLivro();
        static void alterarEstoque();
        static void listarTodosLivros();
        static void listarLivrosUsuario();

        static void menuUser();
        static void novoUser();
        static void rmUser();
        static void alterarEmail();
        static void alterarSenha();
        static void listarUsuarios();



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

        static void addEmprestimo(Emprestimo*);
        static void removerEmprestimo(size_t);
        static Emprestimo* getEmprestimo(size_t);
        static vector<Emprestimo*> getListaEmprestimo();

        ~Biblioteca(){}
};

#endif // BIBLIOTECA_HPP
