package br.com.vacinacao.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VacinacaoEntrada {

    @JsonProperty("nome_vacina")
    private String nomeVacina;

    @JsonProperty("data_vacinacao")
    private String dataVacinacao;

    @JsonProperty("email")
    private String emailUsuario;

}
