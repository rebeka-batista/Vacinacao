package br.com.vacinacao.mapper;

import br.com.vacinacao.entity.VacinacaoEntity;
import br.com.vacinacao.model.VacinacaoEntrada;
import br.com.vacinacao.model.VacinacaoSaida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VacinacaoMapper {

    VacinacaoMapper MAPPER = Mappers.getMapper(VacinacaoMapper.class);
    VacinacaoEntity toEntity(VacinacaoEntrada vacinacaoEntrada);
    VacinacaoSaida toSaida(VacinacaoEntity vacinacaoEntity);

}
