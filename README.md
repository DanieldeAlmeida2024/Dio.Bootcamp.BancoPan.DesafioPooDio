# Bootcamp em Java — exercício de orientação a objetos

Projeto de estudo realizado a partir do desafio **Aprendendo na Prática Programação Orientada a Objetos**, da [Digital Innovation One](https://www.dio.me/).

## O que o código faz

Um `Bootcamp` organiza cursos e mentorias. A classe `Dev` inscreve a pessoa nos conteúdos, registra o que foi concluído e calcula a experiência (XP). `Curso` e `Mentoria` usam herança e polimorfismo para calcular XP de formas diferentes.

## Executar

Requer **JDK 11 ou superior**. Na raiz do repositório:

```bash
mkdir -p saida
javac -encoding UTF-8 -d saida src/src/br/com/dio/desafio/dominio/*.java src/src/Main.java tests/TestesDominio.java
java -cp saida Main
java -cp saida TestesDominio
```

O último comando verifica os construtores, o cálculo de XP e a permanência da inscrição mesmo depois da progressão do aluno. Os mesmos testes rodam no GitHub Actions em Java 17.

## Regras de domínio e execução

- Os construtores de `Curso` e `Mentoria` agora utilizam os argumentos recebidos.
- Cargas horárias inválidas são rejeitadas.
- `Dev` usa identidade de objeto, evitando que a alteração dos conjuntos de conteúdos quebre a inscrição armazenada em `HashSet`.
- A demonstração continua um programa de console, sem banco de dados ou API.

## Material e autoria

O desafio-base e seu enunciado são da **DIO e seus instrutores**. Este repositório reúne a implementação do exercício e melhorias de manutenção/testes; não reivindica a criação do desafio. O [material original foi mantido para consulta](docs/referencia/MATERIAL_ORIGINAL_DIO.md).

**Documentação:** [Requisitos](docs/REQUISITOS.md) · [Arquitetura](docs/ARQUITETURA.md) · [UML](docs/UML.puml) · [Plano de testes](docs/PLANO_TESTES.md)
