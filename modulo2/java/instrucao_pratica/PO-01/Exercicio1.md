# Prática Orientada - 01

### 1 - O que é uma classe em Java e qual é a diferença entre uma classe e um objeto? Dê 5 exemplos mostrando-os em C++ e em Java. 

> Em programação orientada a objetos, uma classe é um tipo de estrutura que define um conjunto de atributos e métodos que podem ser compartilhados por objetos. Uma classe é uma espécie de modelo ou planta baixa para criar objetos. Ela define as características e comportamentos que os objetos dessa classe terão.
>
> Um objeto, por outro lado, é uma instância de uma classe. Ou seja, é uma entidade concreta criada com base na estrutura definida por uma classe. Os objetos são instâncias específicas de uma classe e podem ter valores diferentes para seus atributos, mas compartilham os mesmos métodos.
>
> Segue abaixo alguns exemplos:

---

### _Exemplos em C++_

1. Classe Carro

```
class Carro {
public:
    string modelo;
    int ano;
    void dirigir() {
        cout << "Carro em movimento!" << endl;
    }
};
```

2. Objeto Carro

```
Carro Carro1;
Carro1.modelo = "Fusca";
Carro1.ano = 2020;
```

---

### _Exemplos em Java_

1. Classe Carro

```
public class Carro {
    String modelo;
    int ano;
    void dirigir() {
        System.out.println("Carro em movimento!");
    }
}
```

2. Objeto Carro

```
Carro carro1 = new Carro();
carro1.modelo = "Fusca";
carro1.ano = 2020;
```