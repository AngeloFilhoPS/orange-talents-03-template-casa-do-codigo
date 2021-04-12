package br.com.zupacademy.angelo.casadocodigo.form;

import br.com.zupacademy.angelo.casadocodigo.entity.Autor;
import br.com.zupacademy.angelo.casadocodigo.entity.Categoria;
import br.com.zupacademy.angelo.casadocodigo.entity.Livro;

public class LivroResponse {
    private String titulo;
    private String resumo;
    private String sumario;
    private double preco;
    private Integer numeroPaginas;
    private String isbn;
    private String autor;
    private Autor autorObj;


    public LivroResponse(Livro livro){
        this.titulo= livro.getTitulo();
        this.resumo= livro.getResumo();
        this.sumario=livro.getSumario();
        this.preco= livro.getPreco();
        this.numeroPaginas= livro.getNumeroPaginas();
        this.isbn=livro.getIsbn();
        this.autorObj= livro.getAutor();
        this.autor= autorObj.getNome();
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

    public String getAutor() {
        return autor;
    }
}
