#if !defined(TURMA_HPP)
#define TURMA_HPP

#include"Aluno.hpp"
#include<vector>

class Turma{
    protected:
        vector<Aluno*> alunos;
        
    public:
        Turma(){}

        void addAluno(Aluno novo){
            this->alunos.push_back(&novo);
        }

        void listarAlunos(){
            cout << "Alunos: " << endl;
            for(Aluno* a : alunos){
                cout << a->toString() << endl;
            }
        }

        ~Turma(){}
};

#endif // TURMA_HPP
