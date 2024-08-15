package com.prisao.Main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prisao.Main.entities.AgenteEntity;
import com.prisao.Main.services.AgenteService;

@RestController
@RequestMapping("/agente")
public class AgenteController {

    @Autowired
    private AgenteService agenteService;

    @PostMapping("/saveagente")
    public AgenteEntity saveagente(@RequestBody AgenteEntity agenteEntity){
        return agenteService.saveagente(agenteEntity);
    }

}