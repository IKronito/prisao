package com.prisao.Main.controllers;

import com.prisao.Main.entities.VisitaEntity;
import com.prisao.Main.entities.PresoEntity;
import com.prisao.Main.services.VisitaService;
import com.prisao.Main.services.PresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visita")
public class VisitaController {

    @Autowired
    private VisitaService visitaService;

    @Autowired
    private PresoService presoService;

    @PostMapping("/salvar")
    public ResponseEntity<VisitaEntity> saveVisita(@RequestBody VisitaEntity visitaEntity) {
        PresoEntity preso = presoService.findByIdPreso(visitaEntity.getPreso().getId());
        visitaEntity.setPreso(preso);
        return ResponseEntity.ok(visitaService.saveVisita(visitaEntity));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<VisitaEntity>> findAllVisitas() {
        return ResponseEntity.ok(visitaService.findAllVisitas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitaEntity> findByIdVisita(@PathVariable Long id) {
        return ResponseEntity.ok(visitaService.findByIdVisita(id));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteVisita(@PathVariable Long id) {
        visitaService.deleteVisita(id);
        return ResponseEntity.noContent().build();
    }
}
