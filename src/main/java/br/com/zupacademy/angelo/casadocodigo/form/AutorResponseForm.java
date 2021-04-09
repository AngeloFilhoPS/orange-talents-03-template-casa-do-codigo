package br.com.zupacademy.angelo.casadocodigo.form;

import br.com.zupacademy.angelo.casadocodigo.entity.Autor;

public class AutorResponseForm {
    private Long id;
    private String nome;

    public AutorResponseForm(Autor autor){
        this.id =autor.getId();
        this.nome= autor.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
