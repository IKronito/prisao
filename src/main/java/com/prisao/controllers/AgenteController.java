package com.prisao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prisao.entities.AgenteEntity;
import com.prisao.services.AgenteService;

import java.util.List;

@RestController
@RequestMapping("/agente")
public class AgenteController {

    @Autowired
    private AgenteService agenteService;

    @PostMapping("/saveagente")
    public AgenteEntity saveAgente(@RequestBody AgenteEntity agenteEntity){
        return agenteService.saveAgente(agenteEntity);
    }

}