#if !defined(LIVRO_HPP)
#define LIVRO_HPP

#include<string>

using namespace std;

class Livro{
    private:
        static int cont;
        string id;
        string titulo;
        string autor;
        int copias;
        int copiasTotais;
    public:
        Livro(){}
        Livro(string, string, int);
        
        void setTitulo(string);
        void setAutor(string);
        void setCopias(int);
        void setCopiasTotais(int);
        
        string getTitulo();
        string getAutor();
        int getCopias();
        int getCopiasTotais();
        string getId();
        
        string toString();
        
        ~Livro(){}
};

#endif // LIVRO_HPP
