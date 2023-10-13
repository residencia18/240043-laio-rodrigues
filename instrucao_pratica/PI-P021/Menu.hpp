#if !defined(MENU_HPP)
#define MENU_HPP

#include<iostream>
#include<vector>
#include<string>

using namespace std;

class Menu{
    private:
        
    public:
        Menu(){}

        static int dispMain();
        static void dispGetNomeLivro(string*, string*);
        static void dispGetCopiasLivro(int*);
        static void dispGetIdLivro(string*);
        static void dispGetNomeUser(string*);
        static void dispGetEmailUser(string *);
        static void dispGetSenhaUser(string *);
        static void dispGetIdUser(string *);
        static int dispMenuLivro();
        static int dispMenuUser();

        static void errorNFlivro();
        static void errorNFuser();
        static void errorNFcopias();
        static void errorNFdevolucao();
        static void errorAutenticacao();
        static void errorLimite();
        static void errorLivroExiste();
        static void errorUserExiste();
        static void errorEmpCopias();
        static void success(string);

        static void limpaTela();
        static void pausaTela();
        static void limpaBuffer();

        ~Menu(){}
};

#endif // MENU_HPP
