package br.com.zupacademy.angelo.casadocodigo.form;

import br.com.zupacademy.angelo.casadocodigo.compartilhado.CpfOrCnpj;
import br.com.zupacademy.angelo.casadocodigo.compartilhado.ExistValue;
import br.com.zupacademy.angelo.casadocodigo.compartilhado.UniqueValue;
import br.com.zupacademy.angelo.casadocodigo.entity.Cliente;
import br.com.zupacademy.angelo.casadocodigo.entity.Estado;
import br.com.zupacademy.angelo.casadocodigo.entity.Pais;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteForm {

    @Email
    @NotBlank
    @UniqueValue(domainClass = Cliente.class,fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @CpfOrCnpj
    @NotBlank
    @UniqueValue(domainClass = Cliente.class,fieldName = "cpf")
    private String cpf;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    @ExistValue(entity = Pais.class,campo = "nome")
    private String pais;

    @NotBlank
    @ExistValue(entity = Estado.class,campo = "nome")
    private String estado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public ClienteForm(String email, String nome, String sobrenome, String cpf, String endereco, String complemento, String pais, String estado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.complemento= complemento;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    @Override
    public String  toString() {
        return "ClienteForm{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", pais='" + pais + '\'' +
                ", estado='" + estado + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

    public Cliente converter() {
        return new Cliente(email,nome,sobrenome,cpf,endereco,complemento,pais,estado,telefone,cep);
    }
}
