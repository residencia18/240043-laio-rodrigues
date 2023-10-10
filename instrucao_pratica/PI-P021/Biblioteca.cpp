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

