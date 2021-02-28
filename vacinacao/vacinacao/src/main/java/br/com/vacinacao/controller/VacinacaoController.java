package br.com.vacinacao.controller;

import br.com.vacinacao.model.VacinacaoEntrada;
import br.com.vacinacao.model.VacinacaoSaida;
import br.com.vacinacao.service.VacinacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/vacinacao")
public class VacinacaoController {

    @Autowired
    VacinacaoService vacinacaoService;

    @PostMapping
    public ResponseEntity<VacinacaoSaida> save(@RequestBody VacinacaoEntrada vacinacaoEntrada) {
        VacinacaoSaida vacinacaoSaida = vacinacaoService.save(vacinacaoEntrada);
        if (vacinacaoSaida == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.created(URI.create("http://localhost:8080/vacinacao")).body(vacinacaoSaida);
    }
}
