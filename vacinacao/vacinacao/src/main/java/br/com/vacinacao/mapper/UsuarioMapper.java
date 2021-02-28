package br.com.vacinacao.mapper;

import br.com.vacinacao.entity.UsuarioEntity;
import br.com.vacinacao.model.UsuarioEntrada;
import br.com.vacinacao.model.UsuarioSaida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper MAPPER = Mappers.getMapper(UsuarioMapper.class);
    UsuarioEntity toEntity(UsuarioEntrada usuarioEntrada);
    UsuarioSaida toSaida(UsuarioEntity usuarioEntity);

}
