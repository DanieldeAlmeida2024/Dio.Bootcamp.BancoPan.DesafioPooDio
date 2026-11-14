package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo{
    int cargaHoraria;
    LocalDate data;

    public Mentoria() {
    }

    public Mentoria(String titulo, String descricao, int cargaHoraria, LocalDate data) {
        setTitulo(titulo);
        setDescricao(descricao);
        setCargaHoraria(cargaHoraria);
        setData(data);
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }


    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria <= 0) throw new IllegalArgumentException("Carga horária deve ser positiva");
        this.cargaHoraria = cargaHoraria;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = java.util.Objects.requireNonNull(data, "Data da mentoria obrigatória");
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", data=" + data +
                '}';
    }
}
