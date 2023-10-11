#include"Biblioteca.hpp"

int Emprestimo::cont = 0;
int Usuario::cont = 0;
int Livro::cont = 0;

vector<Livro*> Biblioteca::livros;
vector<Usuario*> Biblioteca::usuarios;

int main(){

    vector<Livro*> livros;

    Livro* l1 = new Livro("t1", "t2", 1);
    Livro* l2 = new Livro("t3", "t4", 2);
    Livro* l3 = new Livro("t5", "t6", 3);

    livros.push_back(l1);
    livros.push_back(l2);
    livros.push_back(l3);

    for(int i = 0; i < livros.size(); i++){
        cout << livros[i]->getTitulo() << endl;
    }

    delete l1;
    livros.erase(livros.begin());

    for(int i = 0; i < livros.size(); i++){
        cout << livros[i]->getTitulo() << endl;
    }

    return 0;
}