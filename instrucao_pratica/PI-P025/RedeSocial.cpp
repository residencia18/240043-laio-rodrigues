#include "RedeSocial.hpp"

void RedeSocial::init(){
    int op;

    // abrirArqUser();
    // abrirArqLivros();
    // abrirArqEmprestimo();
    
    do{
        op = Menu::dispMain();
        switch (op){
            case 1:
                Usuario* u = fazerLogin();
                if(u != NULL)
                    home(u);
                break;
            case 2:
                registrar();
                break;
            case 0:
                // salvarArqUser();
                // salvarArqLivros();
                // salvarArqEmprestimo();
                break;
            default:
                break;
        }
    } while (op != 0);
}


void RedeSocial::registrar(){
    string _nome, _username, _password;
    
    Menu::dispRegister(&_nome, &_username, &_password);

    if(getIdxUsuario(_username) >= 0){
        Menu::error("O nome de usuario nao esta disponivel!");
        return;
    }

    Usuario* novo = new Usuario(_username, _nome, _password);
    addUsuario(novo);
    Menu::success("Usuario registrado com sucesso!");
}

Usuario* RedeSocial::fazerLogin(){
    string _username, _password;
    
    Menu::dispLogin(&_username, &_password);
    
    int idx = getIdxUsuario(_username);
    if(idx < 0){
        Menu::error("Usuario nao encontrado!");
        return NULL;
    }
    
    Usuario* usuario = getUsuario(idx);
    if(usuario->getPasswd()!= _password){
        Menu::error("Senha incorreta!");
        return NULL;
    }
    
    Menu::success("Login efetuado com sucesso!");
    return usuario;
}

void RedeSocial::home(Usuario* _usuario){
    int op;
    do{
        op = Menu::dispHome(_usuario->getUsername(), _usuario->getNome(), _usuario->getSeguidores().size(), _usuario->getSeguindo().size());
        switch (op){
            case 1:
                verFeed();
                break;
            case 2:
                novoTweet(_usuario);
                break;
            case 3:
                Usuario* _pesq = pesquisar();
                if(_pesq != NULL)
                    verUsuario(_usuario, _pesq);
                break;
            case 4:
                verSeguidores(_usuario);
                break;
            case 5:
                excluir(_usuario);
                break;
            case 0:
                Menu::dispLogout();
                break;
            default:
                break;
        }
    } while (op!= 0);
}

void RedeSocial::verFeed(){
    vector<Tweet*> _tweets = getTweets();
    cout << "*************** XWITTER ***************" << endl;
    cout << "***************  FEED   ***************" << endl << endl;
    for(Tweet* tt : _tweets){
        Menu::dispFeed(tt->getAutor(), tt->getConteudo(), tt->getDt_criacao()->toString());
    }
    cout << "*************** XWITTER ***************" << endl << endl;
    pausaTela();
}

void RedeSocial::novoTweet(Usuario* _usuario){
    string _conteudo;
    Menu::dispNewTweet(&_conteudo);
    Tweet* novo = new Tweet(_usuario->getUsername(), _conteudo, Data::getDataAtual());
    addTweet(novo);
    Menu::success("Tweet enviado com sucesso!");
}

Usuario* RedeSocial::pesquisar(){
    string _username;
    Menu::dispPesquisar(&_username);
    int idx = getIdxUsuario(_username);
    if(idx < 0){
        Menu::error("Usuario nao encontrado!");
        return NULL;
    }
    return getUsuario(idx);
}

void RedeSocial::verUsuario(Usuario* _usuario, Usuario* _pesq){
    int op;

    do{
        op = Menu::dispUsuario(_pesq->getUsername(), _pesq->getNome(), _pesq->getSeguidores().size(), _pesq->getSeguindo().size(), _pesq->isSeguidor(_usuario->getUsername()));
        switch (op){
            case 1:
                if(_pesq->isSeguidor(_usuario->getUsername()))
                    naoSeguir(_usuario, _pesq);
                else
                    seguir(_usuario, _pesq);
                break;
            case 2:
                verTweets(_pesq);
                break;
            case 3:
                verSeguidores(_pesq);
                break;
            case 0:
                break;
            default:
                break;
        }
    } while (op != 0);

}

void RedeSocial::naoSeguir(Usuario* _usuario, Usuario* _pesq){
    _usuario->removeSeguindo(_pesq->getUsername());
}

void RedeSocial::seguir(Usuario* _usuario, Usuario* _pesq){
    _usuario->addSeguindo(_pesq);
    _pesq->addSeguidor(_usuario);
}

void RedeSocial::verTweets(Usuario* _usuario){
    vector<Tweet*> _tweets = getTweets(_usuario->getUsername());
    cout << "*************** XWITTER ***************" << endl;
    cout << "***************  FEED   ***************" << endl << endl;
    for(Tweet* tt : _tweets){
        Menu::dispFeed(tt->getAutor(), tt->getConteudo(), tt->getDt_criacao()->toString());
    }
    cout << "*************** XWITTER ***************" << endl << endl;
    pausaTela();
}

void RedeSocial::verSeguidores(Usuario* _usuario){
    vector<Usuario*> _seguidores = _usuario->getSeguidores();
    cout << "*************** XWITTER ***************" << endl;
    cout << "***************  FOLLOWERS   ***************" << endl << endl;
    for(Usuario* us : _seguidores){
        Menu::dispSeguidores(us->getUsername(), us->getNome(), us->getSeguidores().size(), us->getSeguindo().size());
    }
    cout << "*************** XWITTER ***************" << endl << endl;
    pausaTela();
}

void RedeSocial::excluir(Usuario* _usuario){
    int op;
    string senha;

    op = Menu::dispExcluir();
    if(op == 1){
        Menu::dispConfirma(&senha);
        if(_usuario->getSenha().compare(senha) != 0){
            Menu::error("Senha incorreta!");
            return;
        }
        removeUsuario(_usuario->getUsername());
    }
}



Usuario* RedeSocial::getUsuario(string _username){
    int idx = getIdxUsuario(_username);
    if(idx >= 0){
        return usuarios[idx];
    }
}

vector<Tweet*> RedeSocial::getTweets(){
    vector<Tweet*> tts;
    for(size_t i = tweets.size()-1; i >= 0; i--){
        tts.push_back(tweets[i]);
    }
    return tts;
}

vector<Tweet*> RedeSocial::getTweets(string _username){
    vector<Tweet*> tts;

    for(size_t i = tweets.size()-1; i >= 0; i--){
        if(tweets[i]->getAutor()->getUsername().compare(_username) == 0)
            tts.push_back(tweets[i]);
    }
    return tts;
}


void RedeSocial::addUsuario(Usuario* novo){
    usuarios.push_back(novo);
}

void RedeSocial::addTweet(Tweet* novo){
    tweets.push_back(novo);
}

int RedeSocial::getIdxUsuario(string _username){
    for(size_t i = 0; i < usuarios.size(); i++){
        if(usuarios[i]->getUsername().compare(_username) == 0)
            return i;
    }
    Menu::error("Usuario nao encontrado!");
    return -1;
}

vector<int> RedeSocial::getIdxTweets(string _username){
    vector<int> result;
    for(size_t i = 0; i < tweets.size(); i++){
        if(tweets[i]->getAutor()->getUsername().compare(_username) == 0)
            result.push_back(i);
    }
    return result;
}

void RedeSocial::removeUsuario(string _username){
    int idx = getIdxUsuario(_username);
    if(idx >= 0){
        vector<Usuario*> _seguindo = usuarios[idx]->getSeguindo();
        for(int i = 0; i < _seguindo.size(); i++){
            _seguindo[i]->removeSeguidor(_username);
        }

        vector<int> idx = getIdxTweets(_username);
        for(size_t i = 0; i < idx.size(); i++){
            removeTweet(idx[i]);
        }

        delete usuarios[idx];
        usuarios.erase(usuarios.begin()+idx);
        Menu::success("Conta excluida com sucesso!");
    }
}

void RedeSocial::removeTweet(int idx){
    delete tweets[idx];
    tweets.erase(tweets.begin()+idx);
}
