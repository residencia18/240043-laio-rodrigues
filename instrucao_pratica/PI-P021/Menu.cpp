#include"Menu.hpp"

int Menu::dispMain(){
    int op;
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl << endl;
    cout << "1 - Novo emprestimo" << endl;
    cout << "2 - Pesquisar livro" << endl;
    cout << "3 - Devolucao de livro" << endl;
    cout << "4 - Gerenciamento de livros" << endl;
    cout << "5 - Gerenciamento de usuarios" << endl;
    cout << "0 - Sair" << endl;
    cout << "Opcao: ";
    cin >> op;
    limpaBuffer();
    return op;
}

void Menu::dispGetNomeLivro(string *nome, string *autor){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "******** DADOS DO LIVRO ********" << endl << endl;
    cout << "Digite o nome do livro: ";
    getline(cin, *nome);
    cout << "Digite o autor do livro: ";
    getline(cin, *autor);
}

void Menu::dispGetCopiasLivro(int *copias){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "********* QTD DE COPIAS ********" << endl << endl;
    cout << "Qual a quantidade de copias deste livro?" << endl;
    cin >> *copias;
    limpaBuffer();
}

void Menu::dispGetIdLivro(string *id){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "********* ID DO LIVRO ********" << endl << endl;
    cout << "Digite o id do livro: ";
    getline(cin, *id);
}

void Menu::dispGetNomeUser(string *nome){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "******* DADOS DO USUARIO *******" << endl << endl;
    cout << "Digite o nome do usuario: ";
    getline(cin, *nome);
}

void Menu::dispGetEmailUser(string *email){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "******* EMAIL DO USUARIO *******" << endl << endl;
    cout << "Digite o email do usuario: ";
    getline(cin, *email);
}

void Menu::dispGetSenhaUser(string *senha){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "******* SENHA DO USUARIO *******" << endl << endl;
    cout << "Digite a senha do usuario: ";
    getline(cin, *senha);
}

void Menu::dispGetIdUser(string *id){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "********* ID DO USUARIO ********" << endl << endl;
    cout << "Digite o id do usuario: ";
    getline(cin, *id);
}

int Menu::dispMenuLivro(){
    int op;
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "**** GERENCIAMENTO DE LIVROS ***" << endl << endl;
    cout << "1 - Adicionar novo livro" << endl;
    cout << "2 - Remover um livro" << endl;
    cout << "3 - Alterar estoque de um livro" << endl;
    cout << "4 - Exibir todos os livros" << endl;
    cout << "5 - Exibir livros em emprestimo" << endl;
    cout << "0 - Sair" << endl;
    cout << "Opcao: ";
    cin >> op;
    limpaBuffer();
    return op;
}

int Menu::dispMenuUser(){
    int op;
    limpaTela();
    cout << "********** BIBLIOTECA ***********" << endl;
    cout << "*** GERENCIAMENTO DE USUARIOS ***" << endl << endl;
    cout << "1 - Adicionar novo usuario" << endl;
    cout << "2 - Remover um usuario" << endl;
    cout << "3 - Alterar e-mail do usuario" << endl;
    cout << "4 - Alterar senha do usuario" << endl;
    cout << "5 - Exibir todos os usuarios" << endl;
    cout << "0 - Sair" << endl;
    cout << "Opcao: ";
    cin >> op;
    limpaBuffer();
    return op;
}

void Menu::errorNFlivro(){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "******* ERRO NA OPERAÇÃO *******" << endl << endl;
    cout << "Livro nao encontrado!" << endl;
    pausaTela();
}

void Menu::errorNFuser(){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "******* ERRO NA OPERAÇÃO *******" << endl << endl;
    cout << "Usuario nao encontrado!" << endl;
    pausaTela();
}

void Menu::errorNFcopias(){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "******* ERRO NA OPERAÇÃO *******" << endl << endl;
    cout << "Livro nao possui copias disponíveis!" << endl;
    pausaTela();
}

void Menu::errorNFdevolucao(){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "******* ERRO NA OPERAÇÃO *******" << endl << endl;
    cout << "Devolucao ja efetuada!" << endl;
    pausaTela();
}

void Menu::errorAutenticacao(){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "******* ERRO NA OPERAÇÃO *******" << endl << endl;
    cout << "Senha incorreta!" << endl;
    pausaTela();
}

void Menu::errorLimite(){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "******* ERRO NA OPERAÇÃO *******" << endl << endl;
    cout << "Limite excedido de tentativas de autenticacao do usuario!" << endl;
    cout << "Verifique a senha do usuario e tente novamente!" << endl;
    pausaTela();
}

void Menu::errorLivroExiste(){
    cout << "Livro ja existente na biblioteca!" << endl;
    cout << "Por favor, faca alteracao do estoque!" << endl;
    pausaTela();
}

void Menu::errorUserExiste(){
    cout << "Usuario ja existente no cadastro!" << endl;
    pausaTela();
}

void Menu::errorEmpCopias(){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "******* ERRO NA OPERAÇÃO *******" << endl << endl;
    cout << "O livro possui copias em emprestimo!" << endl;
    cout << "Solicite a devolucao de todas a copias!" << endl; 
    pausaTela();
}

void Menu::success(string msg){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "****** SUCESSO NA OPERAÇÃO *****" << endl << endl;
    cout << msg << endl;
    pausaTela();
}


void Menu::limpaTela(){
    system("clear || cls");
}

void Menu::pausaTela(){
    system("pause || read");
}

void Menu::limpaBuffer(){
    int ch;
    while ( ( ch = fgetc ( stdin ) ) != EOF && ch != '\n' );
}
