# Prática Orientada 03

### 1- O que é uma exceção em Java e qual é o propósito de usá-las em programas?

```
Em Java, uma exceção é um evento que ocorre durante a execução de um programa e que interrompe o fluxo normal de instruções. Exceções são usadas para lidar com situações imprevistas ou erros que podem ocorrer durante a execução de um programa. O principal propósito das exceções é fornecer um mecanismo de tratamento de erros que permite ao programador lidar com condições excepcionais de forma controlada e eficiente.
```
---
### 2- Pesquise sobre a diferença entre exceções verificadas e não verificadas em Java. Dê exemplos de cada uma.

### _Exceções verificadas:_

```
São exceções que o compilador obriga o programador a tratar explicitamente. Isso significa que, se um método pode gerar uma exceção verificada, o programador deve usar blocos try-catch para lidar com essas exceções ou declarar que o método as lança usando a cláusula throws na assinatura do método.
```

#### _Exemplo de exceção verificada:_ 

```
public class Exemplo {
    public static void main(String[] args) {
        try {
            File file = new File("arquivo.txt");
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

### _Exceções não verificadas:_


```
Também conhecidas como exceções em tempo de execução, essas exceções não precisam ser tratadas explicitamente pelo programador. Elas geralmente indicam erros de programação, como divisão por zero, acesso a índices fora dos limites de um array, entre outros.
```

#### _Exemplo de exceção não verificada:_ 

```
public class Exemplo {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        System.out.println(array[4]); // Isso gera uma ArrayIndexOutOfBoundsException em tempo de execução
    }
}
```

---
### 3- Como você pode lidar com exceções em Java? Quais são as palavras-chave e as práticas comuns para tratamento de exceções?

```
Em Java, o tratamento de exceções é feito usando blocos try, catch, finally e throw.
```

#### Práticas comuns:


* Usar exceções apropriadas para o tipo de erro que está ocorrendo. Evitar usar exceções genéricas, como Exception, sempre que possível.

* Limitar o escopo do bloco try para cobrir apenas o código que pode lançar uma exceção. Isso ajuda a identificar e tratar problemas específicos.

* Evitar capturar exceções de forma global, a menos que seja absolutamente necessário. Capturar exceções mais específicas é uma prática mais segura.

* Usar o bloco finally para liberar recursos, como fechar arquivos ou conexões, independentemente de ocorrer uma exceção ou não.
---
### 4- O que é o bloco "try-catch" em Java? Como ele funciona e por que é importante usá-lo ao lidar com exceções?

```
O bloco "try-catch" em Java é uma estrutura fundamental para o tratamento de exceções. Ele permite que você envolva um bloco de código no qual exceções podem ocorrer (bloco "try") e fornece um mecanismo para lidar com essas exceções de maneira controlada (bloco "catch"). Além disso, o bloco "finaly" e a palavra-chave "throw" são comandos opcionais que podem ser utilizados para uma maior robustez do código. 
```

#### _Try_

```
O bloco "try" é usado para envolver um conjunto de instruções onde uma exceção pode ocorrer.

Exemplo:

try {
    // Código que pode gerar uma exceção
} 
```

#### _Catch_

```
O bloco "catch" é usado para capturar e lidar com uma exceção que foi lançada no bloco "try". Pode haver vários blocos "catch" para lidar com diferentes tipos de exceções.

Exemplo:

try {
    // Código que pode gerar uma exceção
} catch (TipoDeExcecao1 e1) {
    // Tratamento para TipoDeExcecao1
} catch (TipoDeExcecao2 e2) {
    // Tratamento para TipoDeExcecao2
} catch (Exception e) {
    // Tratamento genérico para outras exceções
}
```

#### _Finaly_

```
O bloco "finally" é opcional e é usado para definir código que sempre será executado, independentemente de ocorrer uma exceção ou não. Por exemplo, é comum usar "finally" para liberar recursos, como fechar arquivos ou conexões com bancos de dados.

Exemplo:

try {
    // Código que pode gerar uma exceção
} catch (TipoDeExcecao e) {
    // Tratamento para TipoDeExcecao
} finally {
    // Código que será executado sempre, mesmo que uma exceção ocorra
}
```

#### _Throw_

```
A palavra-chave "throw" é usada para explicitamente lançar uma exceção. Você pode usá-la para sinalizar que uma condição de erro específica ocorreu.

Exemplo:

if (algumaCondicao) {
    throw new MinhaExcecao("Mensagem de erro");
}
```

```
A razão pela qual é importante usar o bloco try-catch ao lidar com exceções está relacionada à natureza imprevisível de certas situações durante a execução do programa. Algumas operações podem falhar devido a condições inesperadas, como falhas na rede, problemas de leitura/gravação de arquivos, erros de cálculos, etc.
```

---

### 5- Quando é apropriado criar suas próprias exceções personalizadas em Java e como você pode fazer isso? Dê um exemplo de quando e por que você criaria uma exceção personalizada.

```
É apropriado criar as próprias exceções personalizadas em Java quando se está lidando com situações específicas no domínio de aplicação que não são adequadamente representadas pelas exceções padrão fornecidas pela linguagem. As exceções personalizadas podem ser úteis para expressar de forma mais clara e semântica os erros ou condições excepcionais que podem ocorrer no código.
```

```
A criação de uma exceção personalizada em Java envolve a criação de uma nova classe que estende a classe Exception ou uma de suas subclasses. Aqui está um exemplo de como pode criar uma exceção personalizada:
```

```
// Exceção personalizada
class MeuErroException extends Exception {
    public MeuErroException(String mensagem) {
        super(mensagem);
    }
}

// Exemplo de uso da exceção personalizada
public class Exemplo {
    public static void main(String[] args) {
        try {
            // Simulação de uma situação que gera a exceção personalizada
            throw new MeuErroException("Isso é um erro personalizado!");
        } catch (MeuErroException e) {
            System.out.println("Capturado um erro personalizado: " + e.getMessage());
        }
    }
}
```

#### Exemplo de cenário real:
```
Supondo que está sendo desenvolvido um sistema de gerenciamento de biblioteca e tem uma classe Livro que pode ser reservada. Se alguém tentar reservar um livro já reservado, pode-se criar uma exceção personalizada LivroJaReservadoException para representar esse cenário específico. Isso tornaria mais claro no código quando esse tipo específico de erro ocorre e permitiria tratá-lo de maneira adequada.
```
