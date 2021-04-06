package br.com.zupacademy.angelo.casadocodigo.form;

import br.com.zupacademy.angelo.casadocodigo.entity.Autor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AutorForm {
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    @Size(max = 400, message = "Sua descrição não pode ter mais de 400 caracteres")
    private String descricao;
    private LocalDateTime criadoEm = LocalDateTime.now();

    public AutorForm(String nome, String email, String descricao, LocalDateTime criadoEm){
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.criadoEm = LocalDateTime.now();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Autor converter(){ return new Autor(nome,email,descricao,criadoEm);}
}
