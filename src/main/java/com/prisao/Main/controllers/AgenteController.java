package com.prisao.Main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prisao.Main.entities.AgenteEntity;
import com.prisao.Main.services.AgenteService;

import java.util.List;

@RestController
@RequestMapping("/agente")
public class AgenteController {

	@Autowired
	private AgenteService agenteService;

	@PostMapping("/salvar")
	public ResponseEntity<AgenteEntity> saveAgente(@RequestBody AgenteEntity agenteEntity) {
		return ResponseEntity.ok(agenteService.saveAgente(agenteEntity));
	}

	@GetMapping("/todos")
	public ResponseEntity<List<AgenteEntity>> findAllAgentes() {
		return ResponseEntity.ok(agenteService.findAllAgentes());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AgenteEntity> findByIdAgente(@PathVariable Long id) {
		return ResponseEntity.ok(agenteService.findByIdAgente(id));
	}

	@GetMapping("/cargo/{cargo}")
	public ResponseEntity<List<AgenteEntity>> findByCargoAgente(@PathVariable String cargo) {
		return ResponseEntity.ok(agenteService.findByCargoAgente(cargo));
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<AgenteEntity> updateAgente(@PathVariable Long id, @RequestBody AgenteEntity agenteEntity) {
		return ResponseEntity.ok(agenteService.updateAgente(id, agenteEntity));
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deleteAgente(@PathVariable Long id) {
		agenteService.deleteAgente(id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/deletarTodos")
	public ResponseEntity<Void> deleteAllAgentes() {
		agenteService.deleteAllAgentes();
		return ResponseEntity.noContent().build();
	}
}
