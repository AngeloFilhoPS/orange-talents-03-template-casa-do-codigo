package br.com.zupacademy.angelo.casadocodigo.form;

import br.com.zupacademy.angelo.casadocodigo.compartilhado.UniqueValue;
import br.com.zupacademy.angelo.casadocodigo.entity.Autor;
import br.com.zupacademy.angelo.casadocodigo.entity.Categoria;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoriaForm {
    @NotBlank
    @NotNull
    @NotEmpty
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
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
