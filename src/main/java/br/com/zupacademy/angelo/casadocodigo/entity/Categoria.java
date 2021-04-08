package br.com.zupacademy.angelo.casadocodigo.entity;

import br.com.zupacademy.angelo.casadocodigo.compartilhado.UniqueValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @UniqueValue(domainClass = Categoria.class,fieldName = "nome")
    private String nome;

    @Deprecated
    public Categoria(){}

    public Categoria( @NotBlank String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
