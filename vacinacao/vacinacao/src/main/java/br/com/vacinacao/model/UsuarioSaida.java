package br.com.vacinacao.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioSaida {

    @JsonProperty("id_usuario")
    private Integer idUsuario;

    @JsonProperty("nome_completo")
    private String nomeCompleto;

    @JsonProperty("email")
    private String email;

    @JsonProperty("cpf")
    private Long cpf;

    @JsonProperty("data_nascimento")
    private String dataNascimento;

}


