package br.com.zupacademy.angelo.casadocodigo.form;

import br.com.zupacademy.angelo.casadocodigo.entity.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {
    @NotBlank
    private String nome;

    public CategoriaForm(){
    }

    public CategoriaForm(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
    public Categoria converter(){
        return new Categoria(nome);
    }
}
