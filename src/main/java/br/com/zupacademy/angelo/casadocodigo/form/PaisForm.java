package br.com.zupacademy.angelo.casadocodigo.form;

import br.com.zupacademy.angelo.casadocodigo.compartilhado.UniqueValue;
import br.com.zupacademy.angelo.casadocodigo.entity.Pais;

import javax.validation.constraints.NotBlank;

public class PaisForm {
    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public PaisForm(){
    }

    public PaisForm(@NotBlank String nome){
        this.nome=nome;
    }

    public String getNome() {
        return nome;
    }

    public Pais converter() {
        return new Pais(nome);
    }
}
