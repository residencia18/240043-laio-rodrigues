#if !defined(LIVRO_HPP)
#define LIVRO_HPP

#include"Utilitarios.hpp"

class Livro{
    private:
        static vector<Livro*> lista;
        static int cont;
        string id;
        string titulo;
        string autor;
        int copias;
        int copiasTotais;
    public:
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
        
        static void addLivro(Livro*);
        static void removeLivro(size_t);
        static void alterarQTD(size_t, int);

        static int getIdx(string);
        static Livro* getLivro(size_t);
        static vector<Livro*> getLista();
        
        ~Livro(){}
};

#endif // LIVRO_HPP
