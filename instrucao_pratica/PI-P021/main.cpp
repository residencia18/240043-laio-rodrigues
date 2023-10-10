#include"Biblioteca.hpp"



int main(){

    Biblioteca::menuMain();

    return 0;
}


void menu(){
    int op;
    
    do
    {
        op = dispMenu();
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

int dispMenu(){
    int op;
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl << endl;
    cout << "1 - Novo emprestimo" << endl;
    cout << "2 - Pesquisar livro" << endl;
    cout << "3 - Gerenciamento de livros" << endl;
    cout << "4 - Gerenciamento de usuarios" << endl;
    cout << "0 - Sair" << endl;
    cout << "Opcao: ";
    cin >> op;
    limpaBuffer();
    return op;
}

void dispGetNomeLivro(string *t1, string *t2){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "******** DADOS DO LIVRO ********" << endl << endl;
    cout << "Digite o nome do livro: ";
    getline(cin, *t1);
    cout << "Digite o autor do livro: ";
    getline(cin, *t2);
}

void dispGetCopiasLivro(int *copias){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "********* QTD DE COPIAS ********" << endl << endl;
    cout << "Qual a quantidade de copias deste livro?" << endl;
    cin >> *copias;
    limpaBuffer();
}

void dispGetIdLivro(string *id){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "********* ID DO LIVRO ********" << endl << endl;
    cout << "Digite o id do livro: ";
    getline(cin, *id);
}

Livro* getLivroByNome(){
    int idx;
    string t1, t2;

    dispGetNomeLivro(&t1, &t2);

    idx = Livro::getIdxByNome(t1, t2);

    if(idx < 0){
        cout << "Livro nao encontrado!" << endl;
        pausaTela();
        return NULL;
    }

    return Livro::getLivro(idx);
}

Livro* getLivroById(){
    int idx;
    string id;

    dispGetIdLivro(&id);

    idx = Livro::getIdxById(id);

    if(idx < 0){
        cout << "Livro nao encontrado!" << endl;
        pausaTela();
        return NULL;
    }

    return Livro::getLivro(idx);
}

void dispGetNomeUser(string *nome, string *email){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "******* DADOS DO USUARIO *******" << endl << endl;
    cout << "Digite o nome do usuario: ";
    getline(cin, *nome);
    cout << "Digite o email do usuario: ";
    getline(cin, *email);
}

void dispGetSenhaUser(string *senha){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "******* SENHA DO USUARIO *******" << endl << endl;
    cout << "Digite a senha do usuario: ";
    getline(cin, *senha);
}

void dispGetIdUser(string *id){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "********* ID DO USUARIO ********" << endl << endl;
    cout << "Digite o id do usuario: ";
    getline(cin, *id);
}

Usuario* getUserById(){
    int idx;
    string id;

    dispGetIdUser(&id);

    idx = Usuario::getIdxById(id);

    if(idx < 0){
        cout << "Usuario nao encontrado!" << endl;
        pausaTela();
        return NULL;
    }

    return Usuario::getUsuario(idx);
}

Usuario* getUsuarioByNome(){
    int idx;
    string nome, email;

    dispGetNomeUser(&nome, &email);

    idx = Usuario::getIdxByNome(nome, email);

    if(idx < 0){
        cout << "Usuario nao encontrado!" << endl;
        pausaTela();
        return NULL;
    }

    return Usuario::getUsuario(idx);
}

bool autentica(Usuario* usuario){
    string senha;

    dispGetSenhaUser(&senha);

    return usuario->autentica(senha);
}

void emprestimo(){
    Livro* livro;
    Usuario* usuario;
    int tempo = 7, k = 0;
    string status = "Emprestado";

    livro = getLivroById();
    if(livro == NULL){
        return;
    }

    if(livro->getCopias() == 0){
        cout << "Livro nao possui copias disponíveis!" << endl;
        pausaTela();
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
            cout << "Livro emprestado com sucesso!" << endl;
            k = 10;
            pausaTela();
        }else{
            cout << "Usuario nao autenticado!" << endl;
            k++;
            pausaTela();
        }
    } while (k < 3);
    if(k < 5){
        cout << "Limite excedido de tentativas de autenticacao do usuario!" << endl;
        cout << "Verifique a senha do usuario e tente novamente!" << endl;
        pausaTela();
    }
}

void pesquisa(){
    Livro* livro = getLivroByNome();
    if(livro == NULL){
        return;
    }
    livro->toString();
    pausaTela();
}

int dispMenuLivro(){
    int op;
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "**** GERENCIAMENTO DE LIVROS ***" << endl << endl;
    cout << "1 - Adicionar novo livro" << endl;
    cout << "2 - Remover um livro" << endl;
    cout << "3 - Alterar estoque de um livro" << endl;
    cout << "4 - Exibir todos os livros" << endl;
    cout << "0 - Sair" << endl;
    cout << "Opcao: ";
    cin >> op;
    limpaBuffer();
    return op;
}

void menuLivro(){
    int op;
    
    do{
        op = dispMenuLivro();
        switch (op){
            case 1:
                addLivro();
                break;
            case 2:
                rmLivro();
                break;
            case 3:
                alterarEstoque();
                break;
            case 4:
                listarLivros();
                break;
            default:
                break;
        }
    } while (op != 0);
}

void addLivro(){
    string t1, t2;
    int copias;

    dispGetNomeLivro(&t1, &t2);
    dispGetCopiasLivro(&copias);

    if(Livro::getIdxByNome(t1, t2) >= 0){
        cout << "Livro ja existente na biblioteca!" << endl;
        cout << "Por favor, faca alteracao do estoque!" << endl;
        pausaTela();
        return;
    }

    Livro* livro = new Livro(t1, t2, copias);
    Livro::addLivro(livro);

    cout << "Livro adicionado com sucesso!" << endl;
    pausaTela();
}

void rm



