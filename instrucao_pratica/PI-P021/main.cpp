#include"Biblioteca.hpp"
#include<fstream>

int Emprestimo::cont = 0;
int Usuario::cont = 0;
int Livro::cont = 0;

vector<Livro*> Biblioteca::livros;
vector<Usuario*> Biblioteca::usuarios;
vector<Emprestimo*> Biblioteca::emprestimos;

using namespace std;

int main(){

    Biblioteca::init();

    return 0;
}