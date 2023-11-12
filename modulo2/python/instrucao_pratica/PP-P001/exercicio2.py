# Em Python, os operadores aritméticos são semelhantes aos de C/C++.
# São alguns exemplos:

# Adição
a = 5 + 3

# Subtração
b = 7 - 2

# Multiplicação
c = 4 * 6

# Divisão
d = 10 / 2

# Módulo (resto da divisão)
e = 15 % 7

# Exponenciação
f = 2 ** 3

# Entretanto, diferente de C/C++, Python introduz o operador de divisão inteira '//'
# Este operador retorna a divisão truncada, independente se as variáveis são do tipo int ou float
g = 17 // 3 # Resultado: 5

# Além disso, Python permite operadores aritméticos compostos, como '+=', '-=', '*=', '/=', etc...
x = 10
x += 3 # x agora é 13



'''
Python não tem limitações para representar números inteiros como em C/C++. 
Isso é devido ao fato de o Python usar internamente uma representação de número 
inteiro de precisão arbitrária. Aqui está um exemplo calculando o fatorial de 30:
'''

import math

resultado = math.factorial(30)
print(resultado)



'''
Em Python, os números inteiros são imutáveis. 
Isso significa que, quando você realiza uma operação aritmética em uma variável, 
uma nova variável é criada para armazenar o resultado, e a variável original não é modificada.
'''

# Exemplo:
a = 5
b = a
a += 1 # Neste momento temos, a = 6 e b = 5


'''
Variáveis inteiras em Python tem métodos associados a elas.
São alguns exemplos:
'''

# bit_length()
'''
Retorna o número mínimo de bits necessários para representar o número (excluindo o sinal e os zeros à esquerda).
'''
x = 42
bits = x.bit_length()
print(bits)  # Saída: 6

# conjugate()
'''
Retorna o conjugado complexo do número. Para inteiros, isso é equivalente ao próprio número.
'''
x = 5
y = x.conjugate()
print(y)  # Saída: 5

# to_bytes(length, byteorder, signed=False)
'''
Converte o inteiro em uma representação de bytes.
'''
x = 255
byte_representation = x.to_bytes(2, byteorder='big')
print(byte_representation)  # Saída: b'\x00\xff'

# from_bytes(bytes, byteorder, signed=False)
'''
Converte uma sequência de bytes de volta para um inteiro.
'''
byte_representation = b'\x00\xff'
x = int.from_bytes(byte_representation, byteorder='big')
print(x)  # Saída: 255

