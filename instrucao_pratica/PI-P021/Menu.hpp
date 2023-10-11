#if !defined(MENU_HPP)
#define MENU_HPP

#include"Utilitarios.hpp"

class Menu{
    private:
        
    public:
        Menu(){}

        static void init();
        static int dispMain();
        static void dispGetNomeLivro(string*, string*);
        static void dispGetCopiasLivro(int*);
        static void dispGetIdLivro(string*);
        static void dispGetNomeUser(string*, string*);
        static void dispGetSenhaUser(string *);
        static void dispGetIdUser(string *);
        static int dispMenuLivro();

        static void errorNFlivro();
        static void errorNFuser();
        static void errorNFcopias();
        static void errorAutenticacao();
        static void errorLimite();
        static void errorLivroExiste();
        static void successEmprestimo();
        static void successAddLivro();
        static void errorEmpCopias();


        ~Menu(){}
};

#endif // MENU_HPP
