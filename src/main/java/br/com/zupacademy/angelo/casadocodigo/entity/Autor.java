package br.com.zupacademy.angelo.casadocodigo.entity;

import br.com.zupacademy.angelo.casadocodigo.compartilhado.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @Email(message = "Insira um email válido")
    @NotBlank
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;
    @NotBlank
    @Size(max = 400, message = "Sua descrição não pode ter mais de 400 caracteres")
    private String descricao;
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Deprecated
    public Autor(){
    }

    public Autor(@NotBlank String nome,
                 @NotBlank @Email  String email,
                 @NotBlank @Size(max = 400, message = "Sua descrição não pode ter mais de 400 caracteres") String descricao){
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }


}
