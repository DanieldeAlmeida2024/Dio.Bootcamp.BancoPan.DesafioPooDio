# Plano de testes

## Casos
- T01: instanciação e execução com dados válidos.
- T02: tratamento de valor inválido.
- T03: validação de comportamento do domínio.
- T04: documentação, escopo e arquitetura legíveis.

```bash
mkdir -p saida
javac -encoding UTF-8 -d saida src/src/br/com/dio/desafio/dominio/*.java src/src/Main.java tests/TestesDominio.java
java -cp saida Main
java -cp saida TestesDominio
git ls-files -- '*.class'
python -m unittest discover -s tests -p test_documentacao.py -v
```

**Importante:** os testes documentais não substituem execução do Maven, JUnit, banco de dados ou integração.

O teste de domínio deve imprimir `Testes do domínio Bootcamp: PASS`, e `git ls-files` deve retornar uma lista vazia para `.class`.

Limite: Exercício de console: não existe endpoint HTTP nem deployment de produção.
