import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.zip.DataFormatException;

public class Main {
    public static void main(String[] args) {
        Curso cursoJava = new Curso();
        cursoJava.setTitulo("Curso de Java");
        cursoJava.setDescricao("Descricao curso Java");
        cursoJava.setCargaHoraria(4);

        Curso cursoHtml = new Curso();
        cursoHtml.setTitulo("Curso de HTML");
        cursoHtml.setDescricao("Descricao curso HTML");
        cursoHtml.setCargaHoraria(4);

        Curso cursoCss = new Curso();
        cursoCss.setTitulo("Curso de Css");
        cursoCss.setDescricao("Descricao curso Css");
        cursoCss.setCargaHoraria(1);


        Mentoria mentoriaJava = new Mentoria();
        mentoriaJava.setTitulo("Mentoria de Java");
        mentoriaJava.setDescricao("Descrição mentoria Java");
        mentoriaJava.setData(LocalDate.now());


        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("BootCamp Java Developer");
        bootcamp.setDescricao("Descrição BootCamp Java Developer");
        bootcamp.getConteudos().add(cursoJava);
        bootcamp.getConteudos().add(cursoHtml);
        bootcamp.getConteudos().add(cursoCss);
        bootcamp.getConteudos().add(mentoriaJava);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos Camila"+ devCamila.getConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("/-/");
        System.out.println("Conteúdos inscritos Camila"+ devCamila.getConteudosInscritos());
        System.out.println("Conteúdos concluidos Camila"+ devCamila.getConteudosConcluidos());
        System.out.println("XP: "+devCamila.calcularTotalXp());

        System.out.println("/--------------/");

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos João"+ devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("/-/");
        System.out.println("Conteúdos inscritos João"+ devJoao.getConteudosInscritos());
        System.out.println("Conteúdos concluidos João"+ devJoao.getConteudosConcluidos());
        System.out.println("XP: "+devJoao.calcularTotalXp());




    }
}