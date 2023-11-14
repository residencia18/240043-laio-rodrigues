for i in range(10):
    # Imprime o caractere e seu código ASCII
    print(f"'{i}' - {ord('0') + i}")

print()

for i in range(10):
    # Obtém o caractere e seu código ASCII correspondente
    numASCII = ord('0') + i
    print(f"'{i}' - Decimal: {numASCII}, Octal: {oct(numASCII)}, Hexadecimal: {hex(numASCII)}")

print()

# Solicita ao usuário que insira um caractere
str = input("Digite um caractere: ")

# Obtém o primeiro caractere da entrada do usuário
num = str[0]

# Imprime as informações sobre o caractere
print(f"'{num}' - Decimal: {ord(num)}, Octal: {oct(ord(num))}, Hexadecimal: {hex(ord(num))}")


'''
Em Python, os caracteres especiais, como 'ç' e 'ã', são tratados como parte de strings Unicode.
Python 3 utiliza Unicode como padrão para representar caracteres, 
o que permite a inclusão de uma vasta variedade de caracteres especiais, 
incluindo acentos, caracteres não latinos, entre outros.

Aqui estão alguns exemplos de como trabalhar com esses caracteres em Python:
'''

# Atribuição direta em uma string:
char_cedilha = 'ç'
char_til = 'ã'
print(char_cedilha, char_til)

# Códigos Unicode:
'''
Python permite que você use códigos Unicode diretamente para representar caracteres especiais. 
O código Unicode do 'ç' é U+00E7 e do 'ã' é U+00E3. 
Você pode usar esses códigos para representar esses caracteres em uma string.
'''
char_cedilha = '\u00e7'
char_til = '\u00e3'
print(char_cedilha, char_til)

# Encode e Decode:
'''
Você pode usar os métodos encode e decode para converter strings entre diferentes codificações. 
UTF-8 é uma codificação comum que suporta caracteres especiais.
'''
texto = 'çã'
texto_encoded = texto.encode('utf-8')
texto_decoded = texto_encoded.decode('utf-8')
print(texto_encoded, texto_decoded)
