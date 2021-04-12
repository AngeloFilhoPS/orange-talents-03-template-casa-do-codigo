package br.com.zupacademy.angelo.casadocodigo.form;

import br.com.zupacademy.angelo.casadocodigo.entity.Categoria;
import br.com.zupacademy.angelo.casadocodigo.entity.Livro;

public class LivroResponse {
    private String titulo;

    public LivroResponse(Livro livro){
        this.titulo= livro.getTitulo();
    }

    public String getTitulo() {
        return titulo;
    }
}
