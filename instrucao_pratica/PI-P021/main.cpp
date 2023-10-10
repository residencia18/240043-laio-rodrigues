#include"Utilitarios.hpp"

void menu();
int dispMenu();
void emprestimo();
void pesquisa();
void menuLivro();
void menuUser();

int main(){

    menu();
    
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









