'''
Em Python, os operadores aritméticos para números de ponto flutuante são semelhantes aos de inteiros. 
Aqui estão alguns exemplos:
'''

# Adição
adicao = 3.14 + 2.718

# Subtração
subtracao = 5.0 - 2.5

# Multiplicação
multiplicacao = 2.0 * 3.5

# Divisão
divisao = 10.0 / 3.0

# Exemplo de operadores compostos
x = 5.0
x += 2.0  # x agora é 7.0

'''
O operador de exponenciação ** pode ser usado para calcular potências. 
Vamos encontrar a maior e a menor potência de 2 que pode ser representada:
'''

import sys

maiorPotenciaDe2 = sys.float_info.max_10_exp
menorPotenciaDe2 = sys.float_info.min_10_exp

print("Maior Potência de 2:", maiorPotenciaDe2)
print("Menor Potência de 2:", menorPotenciaDe2)

'''
A maior potência de 2 é representada por sys.float_info.max_10_exp, 
e a menor potência de 2 é representada por sys.float_info.min_10_exp.
'''

'''
Como em Python, as variáveis de ponto flutuante são imutáveis, temos o exemplo abaixo:
'''

x = 3.14
y = x
x += 2.0

print(x, y) # y não é alterado; em vez disso, uma nova variável x é criada com o resultado da adição.

'''
Existem vários métodos disponíveis para variáveis de ponto flutuante. Alguns exemplos são:
'''

# as_integer_ratio()
'''
Retorna a representação racional do número como uma tupla de dois inteiros.
'''
num = 3.14
ratio = num.as_integer_ratio()
print(ratio)  # Saída: (157, 50)

# is_integer()
'''
Retorna True se o número for um inteiro, False caso contrário.
'''
num = 3.0
is_integer = num.is_integer()
print(is_integer)  # Saída: True

# hex() e bit_length() (métodos que também podem ser usados com inteiros)
'''
hex() retorna uma representação hexadecimal do número.
bit_length() retorna a quantidade mínima de bits necessária para representar o número.
'''
num = 42.5
hex_representation = num.hex()
bit_length = num.bit_length()
print(hex_representation)  # Saída: '0x1.5000000000000p+5'
print(bit_length)  # Saída: 7

# round(ndigits=None)
'''
Arredonda o número para o número especificado de dígitos decimais. 
Se nenhum número de dígitos for fornecido, ele arredonda para o inteiro mais próximo.
'''
num = 3.14159
rounded_num = round(num, 2)
print(rounded_num)  # Saída: 3.14

# sqrt() e isqrt() (métodos que também podem ser usados com o módulo math para a raiz quadrada)
'''
sqrt() retorna a raiz quadrada do número.
isqrt() retorna a parte inteira da raiz quadrada do número.
'''
import math

num = 25.0
square_root = num.sqrt()
integer_square_root = math.isqrt(int(num))
print(square_root)  # Saída: 5.0
print(integer_square_root)  # Saída: 5