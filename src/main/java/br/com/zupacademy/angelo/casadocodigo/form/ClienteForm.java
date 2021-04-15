package br.com.zupacademy.angelo.casadocodigo.form;

import br.com.zupacademy.angelo.casadocodigo.compartilhado.CpfOrCnpj;
import br.com.zupacademy.angelo.casadocodigo.compartilhado.ExistValue;
import br.com.zupacademy.angelo.casadocodigo.compartilhado.UniqueValue;
import br.com.zupacademy.angelo.casadocodigo.entity.Cliente;
import br.com.zupacademy.angelo.casadocodigo.entity.Estado;
import br.com.zupacademy.angelo.casadocodigo.entity.Pais;
import br.com.zupacademy.angelo.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.angelo.casadocodigo.repository.PaisRepository;

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
    @UniqueValue(domainClass = Cliente.class,fieldName = "cpfOrCnpj")
    private String cpfOrCnpj;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotNull
    private Long paisId;

    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public ClienteForm(String email, String nome, String sobrenome, String cpfOrCnpj, String endereco, String complemento, Long paisId, Long estadoId, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpfOrCnpj = cpfOrCnpj;
        this.endereco = endereco;
        this.complemento= complemento;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    @Override
    public String  toString() {
        return "ClienteForm{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cpfOrCnpj='" + cpfOrCnpj + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", pais='" + paisId + '\'' +
                ", estado='" + estadoId + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

    public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        Pais pais = paisRepository.findPaisById(paisId);
        Estado estado = null;

        if(estadoId!=null){
            estado=estadoRepository.findEstadoById(estadoId);
        }

        return new Cliente(email,nome,sobrenome,cpfOrCnpj,endereco,complemento, pais, estado,telefone,cep);
    }
}
