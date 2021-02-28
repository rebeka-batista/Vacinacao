package br.com.vacinacao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "vacinacao")
@Data
@NoArgsConstructor
public class VacinacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacinacao")
    private Integer idVacinacao;

    @Column(name = "nome_vacina")
    private String nomeVacina;

    @Column(name = "data_vacinacao")
    private String dataVacinacao;

    @Column(name = "email_usuario", unique = true)
    private String emailUsuario;

}
