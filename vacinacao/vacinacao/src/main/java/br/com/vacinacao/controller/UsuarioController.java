package br.com.vacinacao.controller;


import br.com.vacinacao.model.UsuarioEntrada;
import br.com.vacinacao.model.UsuarioSaida;
import br.com.vacinacao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioSaida> save(@RequestBody UsuarioEntrada usuarioEntrada) {
        UsuarioSaida usuarioSaida = usuarioService.save(usuarioEntrada);
        if (usuarioSaida == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.created(URI.create("http://localhost:8080/usuario")).body(usuarioSaida);
    }

}

