package br.com.vacinacao.service;

import br.com.vacinacao.entity.UsuarioEntity;
import br.com.vacinacao.mapper.UsuarioMapper;
import br.com.vacinacao.model.UsuarioEntrada;
import br.com.vacinacao.model.UsuarioSaida;
import br.com.vacinacao.repository.UsuarioRepository;
import br.com.vacinacao.validator.UsuarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioValidator usuarioValidator;

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioSaida save(UsuarioEntrada usuarioEntrada) {
        usuarioValidator.validarUsuario(usuarioEntrada);
        UsuarioEntity usuarioEntity = UsuarioMapper.MAPPER.toEntity(usuarioEntrada);
        return UsuarioMapper.MAPPER.toSaida(usuarioRepository.save(usuarioEntity));
    }

}
