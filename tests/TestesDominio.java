import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import java.time.LocalDate;

public final class TestesDominio {
    private static void verificar(boolean condicao, String mensagem) {
        if (!condicao) throw new AssertionError(mensagem);
    }

    private static void rejeitar(Runnable caso, String mensagem) {
        try {
            caso.run();
            throw new AssertionError(mensagem);
        } catch (IllegalArgumentException esperado) {
            // entrada recusada como previsto
        }
    }

    public static void main(String[] args) {
        Curso curso = new Curso("Java", "Fundamentos de POO", 6);
        verificar("Java".equals(curso.getTitulo()), "Título do curso deve ser inicializado");
        verificar("Fundamentos de POO".equals(curso.getDescricao()), "Descrição não inicializada");
        verificar(curso.getCargaHoraria() == 6, "Carga horária incorreta");
        verificar(curso.calcularXp() == 60.0, "XP do curso incorreto");

        LocalDate data = LocalDate.of(2026, 11, 13);
        Mentoria mentoria = new Mentoria("Mentoria Java", "Orientação", 2, data);
        verificar("Mentoria Java".equals(mentoria.getTitulo()), "Título da mentoria incorreto");
        verificar("Orientação".equals(mentoria.getDescricao()), "Descrição da mentoria incorreta");
        verificar(data.equals(mentoria.getData()), "Construtor deve respeitar data informada");
        verificar(mentoria.calcularXp() == 30.0, "XP da mentoria incorreto");

        rejeitar(() -> new Curso("Incorreto", "Teste", 0), "Curso sem carga horária foi aceito");
        rejeitar(() -> new Mentoria("Incorreta", "Teste", -1, data), "Mentoria inválida foi aceita");

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(mentoria);
        Dev aluno = new Dev();
        aluno.setNome("Aluno Teste");
        aluno.inscreverBootcamp(bootcamp);

        verificar(bootcamp.getDevsInscritos().contains(aluno), "Inscrição deveria existir");
        aluno.progredir();
        verificar(bootcamp.getDevsInscritos().contains(aluno),
            "Progressão não pode quebrar identidade no HashSet");
        verificar(aluno.getConteudosConcluidos().size() == 1, "Progressão precisa concluir item");
        aluno.progredir();
        verificar(bootcamp.getDevsInscritos().contains(aluno),
            "Inscrição deve persistir depois de concluir todos os itens");
        verificar(aluno.getConteudosConcluidos().size() == 2, "Dois itens deveriam estar concluídos");
        verificar(aluno.calcularTotalXp() == 90.0, "XP total incorreto");
        aluno.inscreverBootcamp(bootcamp);
        verificar(aluno.getConteudosInscritos().isEmpty(),
            "Reinscrição não pode reabrir conteúdo já concluído");
        verificar(aluno.getConteudosConcluidos().size() == 2,
            "Reinscrição não deve apagar ou duplicar progresso");
        verificar(aluno.calcularTotalXp() == 90.0, "XP não pode mudar após reinscrição");
        aluno.inscreverBootcamp(bootcamp);
        verificar(aluno.getConteudosInscritos().isEmpty(), "Inscrição repetida deve ser idempotente");
        rejeitar(() -> aluno.inscreverBootcamp(null), "Bootcamp nulo não pode causar NPE");

        Curso novo = new Curso("Tópico novo", "Adicionado ao cronograma", 3);
        bootcamp.getConteudos().add(novo);
        aluno.inscreverBootcamp(bootcamp);
        verificar(aluno.getConteudosInscritos().size() == 1 &&
            aluno.getConteudosInscritos().contains(novo),
            "Reinscrever com conteúdo novo só deve adicionar a tarefa inédita");
        aluno.progredir();
        verificar(aluno.calcularTotalXp() == 120.0,
            "Somente o conteúdo novo deve acrescentar XP");

        System.out.println("Testes do domínio Bootcamp: PASS");
    }
}
