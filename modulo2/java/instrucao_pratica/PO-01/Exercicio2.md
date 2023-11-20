# Prática Orientada - 01

### 2 - Como você declara uma variável em Java e quais são os tipos de dados primitivos mais comuns? Faça um paralelo entre isso e a mesma coisa na linguagem C++

> Em Java, você declara uma variável especificando o tipo de dados seguido pelo nome da variável. 

#### __Aqui está um exemplo simples:__

```
// Declarando uma variável inteira em Java
int numero = 42;

// Declarando uma variável de ponto flutuante
float salario = 1000.50f;

// Declarando uma variável de texto (String)
String nome = "Alice";

// Declarando uma variável booleana
boolean estaAtivo = true;
```

#### _Os tipos de dados primitivos mais comuns em Java são:_

1. int: Para armazenar números inteiros.
2. float e double: Para armazenar números de ponto flutuante.
3. char: Para armazenar caracteres.
4. boolean: Para armazenar valores booleanos (true ou false).

---

### Agora, um paralelo com C++:

```
// Declarando uma variável inteira em C++
int numero = 42;

// Declarando uma variável de ponto flutuante
float salario = 1000.50;

// Declarando uma variável de texto (string)
std::string nome = "Alice";

// Declarando uma variável booleana
bool estaAtivo = true;
```

#### _Os tipos de dados primitivos mais comuns em C++ são:_

1. int: Para armazenar números inteiros.
2. float e double: Para armazenar números de ponto flutuante.
3. char: Para armazenar caracteres.
4. bool: Para armazenar valores booleanos (true ou false).


>As diferenças principais incluem a necessidade de usar std:: para o tipo de dados de string em C++ e a declaração de tipos de dados de ponto flutuante em Java, onde você precisa adicionar o sufixo f ao literal para o tipo float. Em C++, isso não é necessário. Esses são detalhes específicos das linguagens, mas, em geral, os conceitos são bastante semelhantes entre as duas linguagens.