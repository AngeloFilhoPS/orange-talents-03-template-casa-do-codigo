package br.com.zupacademy.angelo.casadocodigo.entity;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(unique = true)
    @NotNull
    private String email;

    @NotNull
    private String nome;

    @NotNull
    private String sobrenome;

    @NotNull
    @Column(unique = true)
    private String cpfOrCnpj;

    @NotNull
    private String endereco;

    @NotNull
    private String complemento;

    @NotNull
    private String pais;

    @NotNull
    private String estado;

    @NotNull
    private String telefone;

    @NotNull
    private String cep;

    public Cliente(){}

    public Cliente(String email, String nome, String sobrenome, String cpfOrCnpj, String endereco,String complemento, String pais, String estado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpfOrCnpj = cpfOrCnpj;
        this.endereco = endereco;
        this.complemento= complemento;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public String getComplemento() {
        return complemento;
    }
}
