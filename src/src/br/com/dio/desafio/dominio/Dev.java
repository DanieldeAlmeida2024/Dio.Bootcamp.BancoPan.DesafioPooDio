package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Optional;
// Identidade de Dev é a própria instância: coleções de progresso são mutáveis.
import java.util.Set;

public class Dev {
    private String Nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp (Bootcamp bootcamp) {
        if (bootcamp == null || bootcamp.getConteudos() == null ||
            bootcamp.getDevsInscritos() == null) {
            throw new IllegalArgumentException("Bootcamp e suas coleções são obrigatórios");
        }
        // Reinscrição não transforma conteúdo já concluído em tarefa pendente.
        // Mantém a ordem dos conteúdos e o progresso do mesmo Dev.
        for (Conteudo conteudo : bootcamp.getConteudos()) {
            if (conteudo == null) {
                throw new IllegalArgumentException("Conteúdo do bootcamp não pode ser nulo");
            }
            if (!conteudosConcluidos.contains(conteudo)) {
                conteudosInscritos.add(conteudo);
            }
        }
        bootcamp.getDevsInscritos().add(this);
    }
    public void progredir () {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        }else{
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }
    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }
}
