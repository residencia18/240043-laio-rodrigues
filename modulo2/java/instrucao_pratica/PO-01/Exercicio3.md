# Prática Orientada - 01

### 3 - Explique o conceito de herança em Java e como você pode criar uma subclasse a partir de uma classe existente. Faça um paralelo com C++, apresentando 5 exemplos.

>A herança é um conceito fundamental em programação orientada a objetos que permite que uma classe (subclasse ou classe derivada) herde os atributos e métodos de outra classe (superclasse ou classe base). Isso promove a reutilização de código e a criação de uma hierarquia de classes. Em Java, você pode criar uma subclasse a partir de uma classe existente usando a palavra-chave extends.

### _Exemplo em Java:_

```
// Classe base ou superclasse
class Animal {
    void comer() {
        System.out.println("Animal comendo...");
    }
}

// Subclasse que herda de Animal
class Cachorro extends Animal {
    void latir() {
        System.out.println("Cachorro latindo...");
    }
}

// Uso das classes
public class TesteHeranca {
    public static void main(String[] args) {
        Cachorro meuCachorro = new Cachorro();
        meuCachorro.comer(); // Herdado da classe Animal
        meuCachorro.latir(); // Próprio da classe Cachorro
    }
}
```
---
>Agora, em C++, a herança é implementada de forma semelhante, usando os conceitos de classes base e derivadas. São exemplos em C++:

### _Exemplos em C++:_

1. _Classe base Animal_

```
class Animal {
public:
    void comer() {
        cout << "Animal comendo..." << endl;
    }
};
```

2. _Classe derivada Cachorro_

```
class Cachorro : public Animal {
public:
    void latir() {
        cout << "Cachorro latindo..." << endl;
    }
};
```
3. _Uso das classes_

```
int main() {
    Cachorro meuCachorro;
    meuCachorro.comer(); // Herdado da classe Animal
    meuCachorro.latir(); // Próprio da classe Cachorro
    return 0;
}
```

