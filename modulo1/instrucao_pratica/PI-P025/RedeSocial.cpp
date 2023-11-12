#include "RedeSocial.hpp"

void RedeSocial::init(){
    int op;
    Usuario* u;

    abrirArqUsuarios();
    abrirArqTweets();
    
    do{
        op = Menu::dispMain();
        switch (op){
            case 1:
                u = fazerLogin();
                if(u != NULL)
                    home(u);
                break;
            case 2:
                registrar();
                break;
            case 0:
                salvarArqUsuarios();
                salvarArqTweets();
                break;
            default:
                break;
        }
    } while (op != 0);
}

void RedeSocial::abrirArqUsuarios(){
    ifstream is("usuarios.txt");
    
    if (!is.is_open()) {
        cout << "Erro ao abrir o arquivo usuarios.txt" << endl;
        exit(1);
    }
    
    string linha;
    
    while (getline(is, linha)) {
        istringstream ss(linha);
        string username, nome, senha;
        
        // Lê os campos separados por vírgulas
        if (getline(ss, username, ',')) {
            getline(ss, nome, ',');
            getline(ss, senha, ',');
        }
        
        // Crie um novo objeto Usuario e atribua os valores lidos
        Usuario *novoUsuario = new Usuario(username, nome, senha);
        
        // Agora, vamos lidar com os seguidores e seguindo
        string token;
        while (getline(ss, token, ',')) {
            istringstream token_ss(token);
            string label;
            token_ss >> label;
            if (label == "Seguidores:") {
                string seguidorUsername;
                while (token_ss >> seguidorUsername) {
                    Usuario *seguidor = getUsuario(seguidorUsername);
                    if (seguidor) {
                        novoUsuario->addSeguidor(seguidor);
                    }
                }
            } else if (label == "Seguindo:") {
                string seguindoUsername;
                while (token_ss >> seguindoUsername) {
                    Usuario *seguido = getUsuario(seguindoUsername);
                    if (seguido) {
                        novoUsuario->addSeguindo(seguido);
                    }
                }
            }
        }
        
        // Adicione o usuário carregado ao vetor de usuários
        usuarios.push_back(novoUsuario);
    }
    
    is.close();
}

void RedeSocial::abrirArqTweets(){
    ifstream is("tweets.txt");
    
    if (!is.is_open()) {
        cout << "Erro ao abrir o arquivo tweets.txt" << endl;
        exit(1);
    }
    
    string linha;
    
    while (getline(is, linha)) {
        istringstream ss(linha);
        string autorUsername, conteudo, dataCriacaoStr;
        
        // Lê os campos separados por vírgulas
        if (getline(ss, autorUsername, ',')) {
            getline(ss, conteudo, ',');
            getline(ss, dataCriacaoStr, ',');
        }
        
        // Crie um novo objeto Tweet e atribua os valores lidos
        Usuario* autor = getUsuario(autorUsername);
        Data* nova = new Data();

        istringstream dt(dataCriacaoStr);
        string dia, mes, ano;
        if(getline(dt, dia, '/') && getline(dt, mes, '/') && getline(dt, ano, '/')){
            nova = new Data(stoi(dia), stoi(mes), stoi(ano));
        }
        
        Tweet* novoTweet = new Tweet(autor, conteudo, nova);
        
        // Adicione o tweet carregado ao vetor de tweets
        tweets.push_back(novoTweet);
    }
    
    is.close();
}

void RedeSocial::salvarArqUsuarios(){
    ofstream os("usuarios.txt");
    
    if (!os.is_open()){
        cout << "Erro ao abrir arquivo usuarios.txt" << endl;
        exit(1);
    }
    
    for (int i = 0; i < usuarios.size(); i++) {
        os << usuarios[i]->getUsername() << ',';
        os << usuarios[i]->getNome() << ',';
        os << usuarios[i]->getSenha() << ',';
        
        // Salvando seguidores
        os << "Seguidores: ";
        for (int j = 0; j < usuarios[i]->getSeguidores().size(); j++) {
            os << usuarios[i]->getSeguidores()[j]->getUsername() << ',';
        }
        
        // Salvando seguindo
        os << "Seguindo: ";
        for (int j = 0; j < usuarios[i]->getSeguindo().size(); j++) {
            os << usuarios[i]->getSeguindo()[j]->getUsername() << ',';
        }
        
        os << endl;
    }
    
    os.close();
}

void RedeSocial::salvarArqTweets(){
    ofstream os("tweets.txt");
    
    if (!os.is_open()) {
        cout << "Erro ao abrir o arquivo tweets.txt" << endl;
        exit(1);
    }
    
    for (int i = 0; i < tweets.size(); i++) {
        os << tweets[i]->getAutor()->getUsername() << ',';
        os << tweets[i]->getConteudo() << ',';
        os << tweets[i]->getDt_criacao()->toString() << ','; // Suponhamos que você tenha um método toString() para a classe Data
        os << endl;
    }
    
    os.close();
}



void RedeSocial::registrar(){
    string _nome, _username, _password;
    
    Menu::dispRegister(&_nome, &_username, &_password);

    if(hasUsuario(_username)){
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
        return NULL;
    }
    
    Usuario* usuario = usuarios[idx];
    if(usuario->getSenha()!= _password){
        Menu::error("Senha incorreta!");
        return NULL;
    }
    
    Menu::success("Login efetuado com sucesso!");
    return usuario;
}

void RedeSocial::home(Usuario* _usuario){
    int op;
    Usuario* _pesq;
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
                _pesq = pesquisar();
                if(_pesq != NULL)
                    verUsuario(_usuario, _pesq);
                break;
            case 4:
                verSeguidores(_usuario);
                break;
            case 5:
                excluir(_usuario);
                op = 0;
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
    Menu::limpaTela();
    cout << "*************** XWITTER ***************" << endl;
    cout << "***************  FEED   ***************" << endl << endl;
    for(Tweet* tt : _tweets){
        Menu::dispFeed(tt->getAutor()->getUsername(), tt->getConteudo(), tt->getDt_criacao()->toString());
    }
    cout << "*************** XWITTER ***************" << endl << endl;
    Menu::pausaTela();
}

void RedeSocial::novoTweet(Usuario* _usuario){
    string _conteudo;
    Menu::dispTweet(&_conteudo);
    Tweet* novo = new Tweet(_usuario, _conteudo, Data::getDataAtual());
    addTweet(novo);
    Menu::success("Tweet enviado com sucesso!");
}

Usuario* RedeSocial::pesquisar(){
    string _username;
    Menu::dispPesquisa(&_username);
    return getUsuario(_username);
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
    Menu::limpaTela();
    cout << "*************** XWITTER ***************" << endl;
    cout << "***************  FEED   ***************" << endl << endl;
    for(Tweet* tt : _tweets){
        Menu::dispFeed(tt->getAutor()->getUsername(), tt->getConteudo(), tt->getDt_criacao()->toString());
    }
    cout << "*************** XWITTER ***************" << endl << endl;
    Menu::pausaTela();
}

void RedeSocial::verSeguidores(Usuario* _usuario){
    vector<Usuario*> _seguidores = _usuario->getSeguidores();
    Menu::limpaTela();
    cout << "*************** XWITTER ***************" << endl;
    cout << "***************  FOLLOWERS   ***************" << endl << endl;
    for(Usuario* us : _seguidores){
        Menu::dispSeguidores(us->getUsername(), us->getNome(), us->getSeguidores().size(), us->getSeguindo().size());
    }
    cout << "*************** XWITTER ***************" << endl << endl;
    Menu::pausaTela();
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
    return NULL;
}

vector<Tweet*> RedeSocial::getTweets(){
    vector<Tweet*> tts;
    for(int i = tweets.size()-1; i >= 0; i--){
        tts.push_back(tweets[i]);
    }
    return tts;
}

vector<Tweet*> RedeSocial::getTweets(string _username){
    vector<Tweet*> tts;

    for(int i = tweets.size()-1; i >= 0; i--){
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

bool RedeSocial::hasUsuario(string _username){
    for(Usuario* u : usuarios){
        if(u->getUsername().compare(_username) == 0)
            return true;
    }
    return false;
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

        vector<int> _idx = getIdxTweets(_username);
        for(size_t i = 0; i < _idx.size(); i++){
            removeTweet(_idx[i]);
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
