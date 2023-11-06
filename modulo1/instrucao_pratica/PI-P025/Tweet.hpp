#if !defined(TWEET_HPP)
#define TWEET_HPP

#include"Usuario.hpp"
#include"Data.hpp"

class Tweet{
    private:
        Usuario* autor;
        string conteudo;
        Data* dt_criacao;
    public:
        Tweet(){}
        Tweet(Usuario*, string, Data*);

        void setAutor(Usuario*);
        void setConteudo(string);
        void setDt_criacao(Data*);

        Usuario* getAutor();
        string getConteudo();
        Data* getDt_criacao();

        ~Tweet(){}
};

#endif // TWEET_HPP
