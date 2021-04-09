package br.com.zupacademy.angelo.casadocodigo.form;

import br.com.zupacademy.angelo.casadocodigo.entity.Categoria;

public class CategoriaResponseForm {
    private String nome;

    public CategoriaResponseForm(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
