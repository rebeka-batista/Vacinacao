package br.com.vacinacao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "usuario")
@Data
@NoArgsConstructor
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "data_nascimento")
    private String dataNascimento;

}
