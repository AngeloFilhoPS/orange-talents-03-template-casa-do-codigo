package br.com.zupacademy.angelo.casadocodigo.form;

import br.com.zupacademy.angelo.casadocodigo.entity.Autor;

public class AutorResponseForm {
    private Long id;
    private String nome;
    private String descricao;

    public AutorResponseForm(Autor autor){
        this.id =autor.getId();
        this.nome= autor.getNome();
        this.descricao= autor.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao(){
            return descricao;
    }
}
