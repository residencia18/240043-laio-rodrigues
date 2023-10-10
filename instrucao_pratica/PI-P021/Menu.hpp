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
        

        ~Menu(){}
};

#endif // MENU_HPP
