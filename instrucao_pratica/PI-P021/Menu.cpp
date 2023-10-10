#include"Menu.hpp"

void Menu::init(){
    
}

int Menu::dispMain(){
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

void Menu::dispGetNomeLivro(string *nome, string *autor){
    limpaTela();
    cout << "********** BIBLIOTECA **********" << endl;
    cout << "******** DADOS DO LIVRO ********" << endl << endl;
    cout << "Digite o nome do livro: ";
    getline(cin, *nome);
    cout << "Digite o autor do livro: ";
    getline(cin, *autor);
}








