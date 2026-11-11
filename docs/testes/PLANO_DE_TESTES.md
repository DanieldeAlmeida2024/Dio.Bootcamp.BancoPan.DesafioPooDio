# Testes — Bootcamp Java — orientação a objetos, matrícula e XP

**v1.0.0 · 11/11/2026 · base `d6d2eb109f69386e01644ab1922ae0866772a18e` · análise do código, sem execução de testes neste PR.**

## Casos e critérios de aceitação
| ID | Cenário | Esperado | Estado |
|---|---|---|---|
| POO-01 | Inscrever Camila no Bootcamp | Conjunto inscrito contém 4 conteúdos | Planejado, não executado neste PR |
| POO-02 | Chamar progredir uma vez | Primeiro conteúdo sai de inscritos e entra concluídos | Planejado, não executado neste PR |
| POO-03 | Completar todos os 4 conteúdos | Inscritos vazio, XP soma dos quatro | Planejado, não executado neste PR |
| POO-04 | Progredir sem conteúdos | Não lança erro e emite aviso | Planejado, não executado neste PR |
| POO-05 | Inscrever novamente no mesmo Bootcamp | Set evita duplicação de conteúdo | Planejado, não executado neste PR |
| POO-06 | XP de Curso e Mentoria | Aplicar override específico de cada subclasse | Planejado, não executado neste PR |
| POO-07 | Igualdade/hashing após progressão | Verificar risco de hash mutável | Planejado, não executado neste PR |
| POO-08 | Main com Camila e João | Camila conclui 3, João conclui 4, sem interferência | Planejado, não executado neste PR |

## Estratégia
Isolar as dependências externas do projeto e exercitar os limites citados; preservar dados e hardware. Executar em ambiente adequado:
```bash
javac -d out $(find src/src -name '*.java') && java -cp out Main
```

Testes JUnit não foram encontrados nessa pasta; os oito casos são planejamento. Comandos javac propostos para Unix requerem adaptação a PowerShell.

Registrar por cenário SHA, versão de ferramenta, entrada, resultado observado, evidência e decisão. Teste documental presente em `tests/` não comprova os critérios de domínio.
