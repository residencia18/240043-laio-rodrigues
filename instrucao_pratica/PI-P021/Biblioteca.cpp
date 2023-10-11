#include"Biblioteca.hpp"

void Biblioteca::init(){
    int op;
    
    do{
        op = Menu::dispMain();
        switch (op){
            case 1:
                emprestimo();
                break;
            case 2:
                pesquisa();
                break;
            case 3:
                menuLivro();
                break;
            case 4:
                menuUser();
                break;
            default:
                break;
        }
    } while (op != 0);
}

Livro* Biblioteca::getLivroByNome(){
    int idx;
    string t1, t2;

    Menu::dispGetNomeLivro(&t1, &t2);

    idx = getIdxLivroByNome(t1, t2);

    if(idx < 0){
        Menu::errorNFlivro();
        return NULL;
    }

    return getLivro(idx);
}

Livro* Biblioteca::getLivroById(){
    int idx;
    string id;

    Menu::dispGetIdLivro(&id);

    idx = getIdxLivroById(id);

    if(idx < 0){
        Menu::errorNFlivro();
        return NULL;
    }

    return getLivro(idx);
}

Usuario* Biblioteca::getUserById(){
    int idx;
    string id;

    Menu::dispGetIdUser(&id);

    idx = getIdxUsuarioById(id);

    if(idx < 0){
        Menu::errorNFuser();
        return NULL;
    }

    return getUsuario(idx);
}

Usuario* Biblioteca::getUsuarioByNome(){
    int idx;
    string nome, email;

    Menu::dispGetNomeUser(&nome, &email);

    idx = getIdxUsuarioByNome(nome, email);

    if(idx < 0){
        Menu::errorNFuser();
        return NULL;
    }

    return getUsuario(idx);
}

bool Biblioteca::autentica(Usuario* usuario){
    string senha;

    Menu::dispGetSenhaUser(&senha);

    return usuario->autentica(senha);
}

void Biblioteca::emprestimo(){
    Livro* livro;
    Usuario* usuario;
    int tempo = 7, k = 0;
    string status = "Emprestado";

    livro = getLivroById();
    if(livro == NULL){
        return;
    }

    if(livro->getCopias() == 0){
        Menu::errorNFcopias();
        return;
    }

    usuario = getUserById();
    if(usuario == NULL){
        return;
    }

    Data* dt_retirada = new Data(10, 10, 2023);

    do{
        if(autentica(usuario)){
            Emprestimo* novo = new Emprestimo(livro, usuario, status, dt_retirada, tempo);
            livro->setCopias(livro->getCopias() - 1);
            usuario->addEmprestimo(novo);
            k = 10;
            Menu::successEmprestimo();
        }else{
            k++;
            Menu::errorAutenticacao();
        }
    } while (k < 3);
    if(k < 5){
        Menu::errorLimite();
    }
}

void Biblioteca::pesquisa(){
    Livro* livro = getLivroByNome();
    if(livro == NULL){
        return;
    }
    cout << livro->toString();
    getchar();
}

void Biblioteca::menuLivro(){
    int op;
    
    do{
        op = Menu::dispMenuLivro();
        switch (op){
            case 1:
                novoLivro();
                break;
            case 2:
                rmLivro();
                break;
            case 3:
                alterarEstoque();
                break;
            case 4:
                listarTodosLivros();
                break;
            default:
                break;
        }
    } while (op != 0);
}

void Biblioteca::novoLivro(){
    string t1, t2;
    int copias;

    Menu::dispGetNomeLivro(&t1, &t2);
    Menu::dispGetCopiasLivro(&copias);

    if(getIdxLivroByNome(t1, t2) >= 0){
        Menu::errorLivroExiste();
        return;
    }

    Livro* livro = new Livro(t1, t2, copias);
    addLivro(livro);

    Menu::successAddLivro();
}

void Biblioteca::rmLivro(){
    string id;
    
    Menu::dispGetIdLivro(&id);
    int idx = getIdxLivroById(id);
    
    if(idx < 0){
        Menu::errorNFlivro();
        return;
    }
    
    if(livros[idx]->getCopias() != livros[idx]->getCopiasTotais()){
        Menu::errorEmpCopias();
        return;
    }

    removeLivro(idx);
}







void Biblioteca::addUsuario(Usuario* novo){
    usuarios.push_back(novo);
}

void Biblioteca::removerUsuario(size_t idx){
    usuarios.erase(usuarios.begin() + idx);
}

void Biblioteca::alterarEmailUsuario(size_t idx, string email){
    usuarios[idx]->setEmail(email);
}

void Biblioteca::alterarSenhaUsuario(size_t idx, string senha){
    usuarios[idx]->setSenha(senha);
}

int Biblioteca::getIdxUsuarioById(string id){
    for(size_t i = 0; i < usuarios.size(); i++){
        if(usuarios[i]->getId().compare(id) == 0){
            return i;
        }
    }
    return -1;
}

int Biblioteca::getIdxUsuarioByNome(string nome, string email){
    for(size_t i = 0; i < usuarios.size(); i++){
        if(usuarios[i]->getNome().compare(nome) == 0 && usuarios[i]->getEmail().compare(email) == 0){
            return i;
        }
    }
    return -1;
}

Usuario* Biblioteca::getUsuario(size_t idx){
    return usuarios[idx];
}

vector<Usuario*> Biblioteca::getListaUsuario(){
    return usuarios;
}


void Biblioteca::addLivro(Livro* livro){
    livros.push_back(livro);
}

void Biblioteca::removeLivro(size_t idx){

    livros.erase(livros.begin() + idx);
}

void Biblioteca::alterarQTD(size_t idx, int qtd){
    int i = qtd - livros[idx]->getCopiasTotais();
    livros[idx]->setCopiasTotais(qtd);
    livros[idx]->setCopias(livros[idx]->getCopias() + i);
}

int Biblioteca::getIdxLivroById(string id){
    for(size_t i = 0; i < livros.size(); i++){
        if(livros[i]->getId().compare(id) == 0){
            return i;
        }
    }
    return -1;
}

int Biblioteca::getIdxLivroByNome(string _titulo, string _autor){
    for(size_t i = 0; i < livros.size(); i++){
        if(livros[i]->getTitulo().compare(_titulo) == 0 && livros[i]->getAutor().compare(_autor) == 0){
            return i;
        }
    }
    return -1;
}

Livro* Biblioteca::getLivro(size_t idx){
    return livros[idx];
}

vector<Livro*> Biblioteca::getLista(){
    return livros;
}

