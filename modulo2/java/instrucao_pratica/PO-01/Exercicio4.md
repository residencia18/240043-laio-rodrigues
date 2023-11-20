# Prática Orientada - 01

### 4 - Quando declaramos uma variável em Java, temos, na verdade, um ponteiro. Em C++ é diferente. Discorra sobre esse aspecto. 

> Na verdade, a afirmação "quando declaramos uma variável em Java, temos, na verdade, um ponteiro" não é precisa. Em Java, as variáveis de tipos primitivos (como int, float, boolean, etc.) armazenam diretamente os valores, enquanto as variáveis de tipos de objetos (como instâncias de classes) armazenam uma referência ao objeto no heap. Portanto, não é correto dizer que todas as variáveis em Java são ponteiros.
>
> Por outro lado, em C++, a situação é diferente. Em C++, você tem a opção de usar ponteiros diretamente, mas a declaração padrão de variáveis não envolve automaticamente ponteiros. Em C++, você tem controle mais direto sobre o gerenciamento de memória e pode usar ponteiros explicitamente, mas não é uma característica intrínseca de todas as variáveis como é muitas vezes associado com Java.

### _Exemplo em Java:_

```
// Variável primitiva
int numero = 42;

// Variável de objeto (referência)
String texto = "Exemplo";
```

### _Exemplo em C++:_

```
// Variável primitiva
int numero = 42;

// Ponteiro para int
int* ponteiroParaNumero = &numero;

// Variável de objeto (objeto diretamente, sem ponteiro)
std::string texto = "Exemplo";  
```

>Portanto, em C++, você tem a opção de trabalhar explicitamente com ponteiros quando desejar, mas a declaração padrão de variáveis não implica automaticamente o uso de ponteiros. Já em Java, o uso de ponteiros é gerenciado automaticamente pelo sistema de gerenciamento de memória (garbage collector) para objetos, e para tipos primitivos, os valores são armazenados diretamente.