from empresa import carregar_funcionarios, reajusta_dez_porcento

def main():
    arquivo_funcionarios = "E:\\repositorios\\resitic18\\modulo2\\python\\instrucao_pratica\\PP-P003\\Empregados\\funcionarios.txt"
    
    # Carrega funcionários do arquivo
    lista_funcionarios = carregar_funcionarios(arquivo_funcionarios)
    
    # Exibe informações antes do reajuste
    print("Antes do reajuste:")
    for funcionario in lista_funcionarios:
        print(funcionario)

    # Aplica o reajuste de 10%
    reajusta_dez_porcento(lista_funcionarios)

    # Exibe informações após o reajuste
    print("\nApós o reajuste:")
    for funcionario in lista_funcionarios:
        print(funcionario)

if __name__ == "__main__":
    main()
