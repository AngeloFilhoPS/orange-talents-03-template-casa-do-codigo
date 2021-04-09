package br.com.zupacademy.angelo.casadocodigo.form;

import br.com.zupacademy.angelo.casadocodigo.compartilhado.UniqueValue;
import br.com.zupacademy.angelo.casadocodigo.entity.Autor;
import br.com.zupacademy.angelo.casadocodigo.entity.Categoria;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AutorForm {
    @NotBlank
    private String nome;

    @NotBlank
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;

    @Size(max = 400, message = "Sua descrição não pode ter mais de 400 caracteres")
    @NotBlank
    private String descricao;
    private LocalDateTime criadoEm = LocalDateTime.now();


    public AutorForm(String nome, String email, String descricao, LocalDateTime criadoEm){
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.criadoEm = LocalDateTime.now();
    }

    public String getEmail() {
        return this.email;
    }

    public Autor converter(){ return new Autor(nome,email,descricao);}


}
