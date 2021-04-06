package br.com.zupacademy.angelo.casadocodigo.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotNull
    private String nome;
    @Column(unique = true,nullable = false)
    @Email(message = "Insira um email válido")
    @NotNull
    private String email;
    @NotNull
    @Size(max = 400, message = "Sua descrição não pode ter mais de 400 caracteres")
    private String descricao;
    private LocalDateTime criadoEm = LocalDateTime.now();

    //@deprecated Hibernate only
    public Autor(){
    }

    public Autor(String nome, String email, String descricao, LocalDateTime criadoEm){
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.criadoEm = criadoEm;
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
