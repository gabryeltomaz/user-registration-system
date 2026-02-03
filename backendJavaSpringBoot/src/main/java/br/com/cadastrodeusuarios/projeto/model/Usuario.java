package br.com.cadastrodeusuarios.projeto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @NotEmpty
    @NotNull
    @NotBlank

    @Size(min = 3, message = "Este campo deve ter no minímo 3 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name="nome", length = 100, nullable = false)
    private String nome;

    @Email(message = "Insira um email válido.")
    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name="email", length = 100, nullable = false)
    private String email;

    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name="senha", columnDefinition = "TEXT", nullable = false)
    private String senha;

    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name="telefone", length = 15, nullable = false)
    private String telefone;

}
