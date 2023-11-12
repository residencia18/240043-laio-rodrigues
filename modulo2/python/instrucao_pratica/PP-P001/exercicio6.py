'''
L = [1,2,3,4,5,6,7,8,9]
print(L[::-1]) # A lista é percorrida do final para o começo de 1 em 1
print(L[-1::]) # A lista é percorrida a partir do ultimo elemento - 1 até o final
print(L[:-1:]) # A lista é percorrida do início até o ultimo elemento - 1
print(L[::-2]) # A lista é percorrida do final para o começo de 2 em 2
print(L[-2::]) # A lista é percorrida a partir do ultimo elemento - 2 até o final
print(L[:-2:]) # A lista é percorrida do início até o ultimo elemento - 2
'''

signo = ['Macaco', 'Galo', 'Cão', 'Porco', 'Rato', 'Boi', 'Tigre', 'Coelho', 'Dragão', 'Serpente', 'Cavalo', 'Carneiro']

cin = input("Digite o ano de nascimento: ")
temp = cin.split()
ano = temp[0]

num = int(ano)%12

print(f"Para o ano de {ano}, o signo é {signo[num]}")

