#if !defined(REDESOCIAL_HPP)
#define REDESOCIAL_HPP

#include"Tweet.hpp"
#include<fstream>
#include<sstream>

class RedeSocial{
    private:
        static vector<Usuario*> usuarios;
        static vector<Tweet*> tweets;
    public:
        RedeSocial(){}

        static void init();
        
        static void abrirArqUsuarios();
        static void abrirArqTweets();
        static void salvarArqUsuarios();
        static void salvarArqTweets();

        static void registrar();
        static Usuario* fazerLogin();
        static void home(Usuario*);

        static void verFeed();
        static void novoTweet(Usuario*);
        static Usuario* pesquisar();
        static void verUsuario(Usuario*, Usuario*);
        static void naoSeguir(Usuario*, Usuario*);
        static void seguir(Usuario*, Usuario*);
        static void verTweets(Usuario*);
        static void verSeguidores(Usuario*);
        static void excluir(Usuario*);


        static Usuario* getUsuario(string);
        static vector<Tweet*> getTweets();
        static vector<Tweet*> getTweets(string);
        
        static void addUsuario(Usuario*);
        static void addTweet(Tweet*);
        static bool hasUsuario(string);
        static int getIdxUsuario(string);
        static vector<int> getIdxTweets(string);
        static void removeUsuario(string);
        static void removeTweet(int);


        ~RedeSocial(){}
};

#endif // REDESOCIAL_HPP
