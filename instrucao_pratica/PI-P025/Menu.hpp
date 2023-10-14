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

        static void success(string);
        static void error(string);

        ~Menu(){}
};

#endif // MENU_HPP
