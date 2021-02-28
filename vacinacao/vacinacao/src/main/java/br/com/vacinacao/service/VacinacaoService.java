package br.com.vacinacao.service;

import br.com.vacinacao.entity.VacinacaoEntity;
import br.com.vacinacao.mapper.VacinacaoMapper;
import br.com.vacinacao.model.VacinacaoEntrada;
import br.com.vacinacao.model.VacinacaoSaida;
import br.com.vacinacao.repository.VacinacaoRepository;
import br.com.vacinacao.validator.VacinacaoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacinacaoService {

    @Autowired
    VacinacaoValidator vacinacaoValidator;

    @Autowired
    VacinacaoRepository vacinacaoRepository;

    public VacinacaoSaida save(VacinacaoEntrada vacinacaoEntrada) {
        vacinacaoValidator.validarVacinacao(vacinacaoEntrada);
        VacinacaoEntity vacinacaoEntity = VacinacaoMapper.MAPPER.toEntity(vacinacaoEntrada);
        return VacinacaoMapper.MAPPER.toSaida(vacinacaoRepository.save(vacinacaoEntity));
    }

}
