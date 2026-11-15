# POO-BOOT-02 — Reinscrição e integridade da progressão

**Revisão:** 15/11/2026

## Defeito

Ao chamar `Dev.inscreverBootcamp` depois de concluir os conteúdos, a implementação copiava novamente **todos** os conteúdos do bootcamp para as pendências, inclusive os já concluídos. Isso fazia o aluno reaparecer com aulas concluídas como se estivessem pendentes. O XP era protegido apenas incidentalmente pelo `Set` de concluídos.

## Contrato corrigido

- A inscrição inclui apenas conteúdo que não está em `conteudosConcluidos`, preservando a ordem de `LinkedHashSet`.
- Reinscrever duas vezes não reabre tarefas nem altera o XP.
- Se forem adicionados novos conteúdos ao bootcamp, só as tarefas inéditas entram nas pendências.
- Bootcamp e coleções nulos são rejeitados com `IllegalArgumentException` antes da mutação, sem `NullPointerException` não controlada.
- O teste funcional Java verifica a inscrição inicial, duas progressões, repetição, conteúdo novo e XP.

**Limitações:** progresso permanece em memória, sem persistência, login ou concorrência multiusuário. O exemplo não é um sistema de cursos em produção.
