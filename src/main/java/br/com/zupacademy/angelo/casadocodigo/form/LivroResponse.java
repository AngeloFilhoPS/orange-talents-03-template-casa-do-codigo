package br.com.zupacademy.angelo.casadocodigo.form;

import br.com.zupacademy.angelo.casadocodigo.entity.Autor;
import br.com.zupacademy.angelo.casadocodigo.entity.Categoria;
import br.com.zupacademy.angelo.casadocodigo.entity.Livro;

import java.time.LocalDate;

public class LivroResponse {
    private String titulo;
    private String resumo;
    private String sumario;
    private double preco;
    private Integer numeroPaginas;
    private String isbn;
    private AutorResponseForm autor;
    private LocalDate dataLancamento;


    public LivroResponse(Livro livro){
        this.titulo= livro.getTitulo();
        this.resumo= livro.getResumo();
        this.sumario=livro.getSumario();
        this.preco= livro.getPreco();
        this.numeroPaginas= livro.getNumeroPaginas();
        this.isbn=livro.getIsbn();
        this.autor= new AutorResponseForm(livro.getAutor());
        this.dataLancamento = livro.getDataLancamento();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public double getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }



    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public AutorResponseForm getAutor() {
        return autor;
    }
}
