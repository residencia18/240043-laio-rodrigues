#if !defined(MENU_HPP)
#define MENU_HPP

#include<iostream>
#include<string>
#include<vector>

using namespace std;

class Menu{
    private:
        
    public:
        Menu(){}

        static void limpaTela();
        static void limpaBuffer();
        static void pausaTela();

        static int dispMain();
        static void dispLogin(string*, string*);
        static void dispRegister(string*, string*, string*);
        static void dispLogout();

        static int dispHome(string, string, int, int);
        static void dispFeed(string, string, string);
        static void dispTweet(string*);
        static void dispPesquisa(string*);
        static int dispUsuario(string, string, int, int, bool);
        static void dispSeguidores(string, string, int, int);
        static int dispExcluir();
        static void dispConfirma(string*);

        static void success(string);
        static void error(string);

        ~Menu(){}
};

#endif // MENU_HPP
