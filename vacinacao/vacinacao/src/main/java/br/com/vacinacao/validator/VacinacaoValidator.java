package br.com.vacinacao.validator;

import br.com.vacinacao.model.VacinacaoEntrada;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class VacinacaoValidator {

    private static final String NOME_INVALIDO = "O nome não pose der nulo ou vazio.";
    private static final String EMAIL_INVALIDO = "O email não pode ser nulo ou vazio.";
    private static final String EMAIL_INVALIDO_2 = "O email deve ser por exemplo: nome@outlook.com";

    public void validarNomeVacina(VacinacaoEntrada vacinacaoEntrada) {
        if (vacinacaoEntrada.getNomeVacina() == null || vacinacaoEntrada.getNomeVacina().isEmpty()) {
            throw new RuntimeException(NOME_INVALIDO);
        }
    }

    public void validarEmailUsuario(VacinacaoEntrada vacinacaoEntrada) {
        if (vacinacaoEntrada.getEmailUsuario() == null || vacinacaoEntrada.getEmailUsuario().isEmpty()) {
            throw new RuntimeException(EMAIL_INVALIDO);
        }
        if (!vacinacaoEntrada.getEmailUsuario().contains("@")) {
            throw new RuntimeException(EMAIL_INVALIDO_2);
        }
    }

    public String validarDataVacinacao(VacinacaoEntrada vacinacaoEntrada) throws ParseException {
        vacinacaoEntrada.setDataVacinacao(vacinacaoEntrada.getDataVacinacao());
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dataFormatada.parse(vacinacaoEntrada.getDataVacinacao());
        SimpleDateFormat data = new SimpleDateFormat("dd.MMMM.yyyy");
        String dataF = data.format(date);
        return dataF;
    }

    @SneakyThrows
    public void validarVacinacao(VacinacaoEntrada vacinacaoEntrada) {
        validarNomeVacina(vacinacaoEntrada);
        validarDataVacinacao(vacinacaoEntrada);
        validarEmailUsuario(vacinacaoEntrada);
    }

}