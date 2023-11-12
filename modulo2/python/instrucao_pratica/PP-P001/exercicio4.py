# Declarando uma variável nome atribuindo a ela o nome completo
nomeCompleto = "Laio Rodrigues"

# Vamos assumir que o sobrenome é a última palavra no nome completo
palavras = nomeCompleto.split()
nome = palavras[0]
sobrenome = palavras[-1]

print(nome, sobrenome)

# Verificando qual das duas novas variáveis antecede a outra na ordem alfabética
ordemAlfabetica = sorted([nome, sobrenome])
primeiraVariavel = ordemAlfabetica[0]
segundaVariavel = ordemAlfabetica[1]

print(primeiraVariavel, segundaVariavel)

# Verificando a quantidade de caracteres de cada uma das novas variáveis
qtdCaracteresNome = len(nome)
qtdCaracteresSobrenome = len(sobrenome)

print(qtdCaracteresNome, qtdCaracteresSobrenome)

# Verificando se o nome é um palíndromo
nomeInverso = nome[::-1]

print(nomeInverso)

if(nome == nomeInverso):
    print("É palindromo")
else:
    print("Não é palindromo")