package com.prisao.Main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prisao.Main.entities.CelaEntity;
import com.prisao.Main.services.CelaService;

import java.util.List;

@RestController
@RequestMapping("/cela")
public class CelaController {

    @Autowired
    private CelaService celaService;

    @PostMapping("/salvar")
    public ResponseEntity<CelaEntity> saveCela(@RequestBody CelaEntity celaEntity) {
        return ResponseEntity.ok(celaService.saveCela(celaEntity));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<CelaEntity>> findAllCelulas() {
        return ResponseEntity.ok(celaService.findAllCelulas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CelaEntity> findByIdCela(@PathVariable Long id) {
        return ResponseEntity.ok(celaService.findByIdCela(id));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<CelaEntity> updateCela(@PathVariable Long id, @RequestBody CelaEntity celaEntity) {
        return ResponseEntity.ok(celaService.updateCela(id, celaEntity));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteCela(@PathVariable Long id) {
        celaService.deleteCela(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deletarTodos")
    public ResponseEntity<Void> deleteAllCelulas() {
        celaService.deleteAllCelulas();
        return ResponseEntity.noContent().build();
    }
}
