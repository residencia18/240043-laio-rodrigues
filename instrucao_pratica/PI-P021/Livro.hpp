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
        
        void setCont(int);
        void setId(string);
        void setTitulo(string);
        void setAutor(string);
        void setCopias(int);
        void setCopiasTotais(int);
        
        string getTitulo();
        string getAutor();
        int getCopias();
        int getCopiasTotais();
        string getId();
        
        static string dispToString();
        string toString();
        static string dispToStringEmp();
        string toStringEmp(string, string);
        
        ~Livro(){}
};

#endif // LIVRO_HPP
