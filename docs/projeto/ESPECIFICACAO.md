# Bootcamp Java — orientação a objetos, matrícula e XP

**v1.0.0 · 11/11/2026 · base `d6d2eb109f69386e01644ab1922ae0866772a18e` · análise do código, sem execução de testes neste PR.**

## Produto, componentes, contratos e riscos
Projeto didático Java sem Spring e sem banco. `src/src/Main.java` constrói três `Curso` (Java, HTML, CSS) e uma `Mentoria` com data `LocalDate.now()`, associa ao `Bootcamp` 'BootCamp Java Developer' e inscreve dois `Dev` (Camila e João), que progridem pelo conteúdo em ordem de inserção.

O modelo de domínio real contém `Bootcamp`, `Conteudo` abstrato, `Curso`, `Mentoria` e `Dev`. `Conteudo.XP_PADRAO = 10d` e subclasses implementam `calcularXp()`. `Dev` mantém `LinkedHashSet<Conteudo>` para inscritos e concluídos; `progredir()` move o primeiro conteúdo; `calcularTotalXp()` soma XP concluído. Progresso sem conteúdo apenas escreve em stderr. `Dev.equals/hashCode` inclui conjuntos mutáveis de conteúdo, o que pode quebrar comportamento de igualdade quando os objetos são armazenados em Set e sofrem mutação.

**Escopo:** mostrar encapsulamento, herança, polimorfismo, associação e progressão em memória. Não existe autenticação, persistência, sistema real de cursos ou API REST. O repositório armazena arquivos compilados em `out/production/`, que podem ficar obsoletos em relação ao fonte.

## Entradas, execução e limites
```bash
javac -d out $(find src/src -name '*.java') && java -cp out Main
```

Testes JUnit não foram encontrados nessa pasta; os oito casos são planejamento. Comandos javac propostos para Unix requerem adaptação a PowerShell.

## Relação com os documentos
Os fluxos estão nos diagramas de [UML](../uml/README.md) e os critérios rastreáveis estão em [Testes](../testes/PLANO_DE_TESTES.md). Mudança de regra exige atualizar ambos e o [controle](../controle/VERSIONAMENTO.md).
