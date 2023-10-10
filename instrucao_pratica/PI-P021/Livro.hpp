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
        Livro(string titulo, string autor, int copias);
        
        void setTitulo(string titulo);
        void setAutor(string autor);
        void setCopias(int copias);
        void setCopiasTotais(int copiasTotais);
        
        string getTitulo();
        string getAutor();
        int getCopias();
        int getCopiasTotais();
        string getId();
        
        string toString();
        
        static void addLivro(Livro* livro);
        static void removeLivro(size_t idx);
        static void alterarQTD(size_t idx, int qtd);

        static int getIdx(string id);
        static Livro* getLivro(size_t idx);
        static vector<Livro*> getLista();
        
        ~Livro(){}
};

#endif // LIVRO_HPP
