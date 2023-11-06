#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;
// Função para calcular a média de duas notas
float calcularMedia(float nota1, float nota2) {
    return (nota1 + nota2) / 2.0f;
}

// Função para ordenar o vetor de nomes lexicograficamente (bubble sort)
void ordenarNomes(vector<string>& nomes) {
    bool trocou;
    do {
        trocou = false;
        for (size_t i = 0; i < nomes.size() - 1; i++) {
            if (nomes[i] > nomes[i + 1]) {
                swap(nomes[i], nomes[i + 1]);
                trocou = true;
            }
        }
    } while (trocou);
}

int main() {
    int limiteAlunos;
    cout << "Digite o limite de alunos (N): ";
    cin >> limiteAlunos;

    vector<string> nomes;
    vector<float> notas;

    char incluirMaisAlunos;
    do {
        if (nomes.size() >= static_cast<size_t>(limiteAlunos)) {
            cout << "Limite de alunos atingido." << endl;
            break;
        }

        string nome;
        float nota1, nota2;

        cout << "Digite o nome do aluno: ";
        cin >> nome;
        cout << "Digite a primeira nota do aluno: ";
        cin >> nota1;
        cout << "Digite a segunda nota do aluno: ";
        cin >> nota2;

        nomes.push_back(nome);
        notas.push_back(nota1);
        notas.push_back(nota2);

        ordenarNomes(nomes);

        cout << "Deseja incluir mais alunos (s/n)? ";
        cin >> incluirMaisAlunos;
    } while (incluirMaisAlunos == 's' || incluirMaisAlunos == 'S');

    char excluirAluno;
    do {
        cout << "Deseja excluir algum aluno (s/n)? ";
        cin >> excluirAluno;
        if (excluirAluno == 's' || excluirAluno == 'S') {
            string nomeExcluir;
            cout << "Digite o nome do aluno a ser excluído: ";
            cin >> nomeExcluir;

            auto it = find(nomes.begin(), nomes.end(), nomeExcluir);
            if (it != nomes.end()) {
                // Encontrou o aluno, exclui-o
                size_t pos = distance(nomes.begin(), it);
                nomes.erase(nomes.begin() + pos);
                notas.erase(notas.begin() + pos * 2, notas.begin() + pos * 2 + 2);
                cout << "Aluno excluído com sucesso." << endl;
            } else {
                cout << "Aluno não encontrado." << endl;
            }
        }
    } while (excluirAluno == 's' || excluirAluno == 'S');

    char alterarNota;
    do {
        cout << "Deseja alterar alguma nota (s/n)? ";
        cin >> alterarNota;
        if (alterarNota == 's' || alterarNota == 'S') {
            string nomeAlterar;
            cout << "Digite o nome do aluno cuja nota será alterada: ";
            cin >> nomeAlterar;

            auto it = find(nomes.begin(), nomes.end(), nomeAlterar);
            if (it != nomes.end()) {
                // Encontrou o aluno, mostra as notas
                size_t pos = distance(nomes.begin(), it);
                cout << "Notas do aluno " << nomes[pos] << ": " << notas[pos * 2] << " e " << notas[pos * 2 + 1] << endl;
                int opcao;
                do {
                    cout << "Alterar a primeira nota (1), a segunda nota (2) ou nenhuma (0)? ";
                    cin >> opcao;
                    if (opcao == 1) {
                        cout << "Digite a nova primeira nota: ";
                        cin >> notas[pos * 2];
                    } else if (opcao == 2) {
                        cout << "Digite a nova segunda nota: ";
                        cin >> notas[pos * 2 + 1];
                    }
                } while (opcao != 0);
            } else {
                cout << "Aluno não encontrado." << endl;
            }
        }
    } while (alterarNota == 's' || alterarNota == 'S');

    cout << "Lista de alunos e notas:" << endl;
    for (size_t i = 0; i < nomes.size(); i++) {
        float media = calcularMedia(notas[i * 2], notas[i * 2 + 1]);
        cout << nomes[i] << ": Nota 1 = " << notas[i * 2] << ", Nota 2 = " << notas[i * 2 + 1]
                  << ", Média = " << media << " (" << (media >= 7.0f ? "Aprovado" : "Reprovado") << ")" << endl;
    }

    return 0;
}