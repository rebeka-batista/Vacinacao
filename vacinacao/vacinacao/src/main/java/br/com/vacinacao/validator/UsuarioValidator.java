package br.com.vacinacao.validator;

import br.com.vacinacao.model.UsuarioEntrada;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class UsuarioValidator {

    public static final String EMAIL_INVALIDO = "O email não pode ser nulo ou vazio!";
    public static final String EMAIL_INVALIDO_2 = "O email de ser por exemplo: nome@outlook.com";
    public static final String CPF_INVALIDO = "O cpf não pode ser nulo.";
    public static final String NOME_INVALIDO = "O nome não pode ser nulo ou vazio.";

    public void validarEmailDoUsuario(UsuarioEntrada usuarioEntrada) {
        if (usuarioEntrada.getEmail() == null || usuarioEntrada.getEmail().isEmpty()) {
            throw new RuntimeException(EMAIL_INVALIDO);
        }
        if (!usuarioEntrada.getEmail().contains("@")) {
            throw new RuntimeException(EMAIL_INVALIDO_2);
        }
    }

    public void validarCpfDoUsuario(UsuarioEntrada usuarioEntrada) {
        if (usuarioEntrada.getCpf() == null || usuarioEntrada.getCpf() < 0) {
            throw new RuntimeException(CPF_INVALIDO);
        }
    }

    public void validarNomeDoUsuario(UsuarioEntrada usuarioEntrada) {
        if (usuarioEntrada.getNomeCompleto() == null || usuarioEntrada.getNomeCompleto().isEmpty()) {
            throw new RuntimeException(NOME_INVALIDO);
        }
    }

    public String validarDataNascimentoUsuario(UsuarioEntrada usuarioEntrada) throws ParseException {
        usuarioEntrada.setDataNascimento(usuarioEntrada.getDataNascimento());
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dataFormatada.parse(usuarioEntrada.getDataNascimento());
        SimpleDateFormat data = new SimpleDateFormat("dd.MMMM.yyyy");
        String dataF = data.format(date);
        return dataF;
    }

    @SneakyThrows
    public void validarUsuario(UsuarioEntrada usuarioEntrada) {
        validarNomeDoUsuario(usuarioEntrada);
        validarEmailDoUsuario(usuarioEntrada);
        validarCpfDoUsuario(usuarioEntrada);
        validarDataNascimentoUsuario(usuarioEntrada);
    }

}
