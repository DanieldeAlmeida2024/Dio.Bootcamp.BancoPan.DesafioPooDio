# Arquitetura

Exercício Java para modelagem de bootcamp, cursos, mentorias, estudantes e princípios de orientação a objetos.

**Stack:** Java, classes sob src/src, sem projeto Maven na raiz.

**Camadas conceituais:** apresentação / entrada; serviços / casos de uso; domínio / entidades; adaptadores de infraestrutura (quando existem no módulo). A disposição real é a das classes do repositório, e o diagrama não presume pacotes novos.

## Decisões
- Preservar os exercícios de origem e rastrear adaptações realizadas.
- Empregar DTOs e validação em fronteiras HTTP, quando presentes.
- Em Java, preferir nomes de domínio coerentes, testes JUnit e inversão de dependências.
- Evitar alteração de framework sem testes de compatibilidade.

## Limitações
Exercício de console: não existe endpoint HTTP nem deployment de produção.
