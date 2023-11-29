def carregar_funcionarios(arquivo):
    funcionarios = []
    
    with open(arquivo, 'r') as file:
        next(file)
        for linha in file:
            dados = linha.strip().split()
            funcionario = {
                'nome': dados[0],
                'sobrenome': dados[1],
                'nascimento': int(dados[2]),
                'rg': dados[3],
                'admissao': int(dados[4]),
                'salario': float(dados[5])
            }
            funcionarios.append(funcionario)

    return funcionarios

def reajusta_dez_porcento(lista_funcionarios):
    for funcionario in lista_funcionarios:
        funcionario['salario'] *= 1.1  # Aumento de 10%

