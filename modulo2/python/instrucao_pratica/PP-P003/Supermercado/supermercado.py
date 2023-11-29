import os

def inserir_produto(produtos):
    os.system("cls||clear")
    id = input("Digite o código do produto: ")
    nome = input("Digite o nome do produto: ").capitalize()
    while True:
        try:
            preco = float(input("Digite o preço do produto: "))
        except ValueError:
            print("Valor digitado inválido!")
        except Exception as e:
            print("Erro: ", e)
        else:
            break
    
    produto = {
        "id": id,
        "nome": nome,
        "preco": round(preco, 2)
    }

    produtos.append(produto)
    print("Produto inserido com sucesso!\n")
    os.system("pause")
    


def excluir_produto(produtos, id):
    for produto in produtos:
        if produto["id"] == id:
            produtos.remove(produto)
            print("Produto excluído com sucesso!\n")
            os.system("pause")
            return

    print("Produto não encontrado!\n")
    os.system("pause")


def listar_produtos(produtos):
    os.system("cls||clear")
    if not produtos:
        print("Nenhum produto cadastrado.\n")
        os.system("pause")
        return

    produtos_ordenados = sorted(produtos, key=lambda x: x["id"])
    
    paginas = [produtos_ordenados[i:i+10] for i in range(0, len(produtos_ordenados), 10)]
    
    print("Lista de produtos:")
    for i,pagina in enumerate(paginas, start=1):
        print(f"\n === Página {i} === ")
        for produto in pagina:
            print(f"# {produto['id']} - {produto['nome']} \tR${produto['preco']:.2f}")

    print()
    os.system("pause")


def consultar_preco(produtos, id):
    for produto in produtos:
        if produto["id"] == id:
            print(f"O preço do produto {produto['nome']} é R${produto['preco']:.2f}\n")
            os.system("pause")
            return

    print("Produto não encontrado!\n")
    os.system("pause")
