package com.prisao.Main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prisao.Main.entities.PresoEntity;
import com.prisao.Main.entities.CelaEntity;
import com.prisao.Main.services.PresoService;
import com.prisao.Main.services.CelaService;

import java.util.List;

@RestController
@RequestMapping("/preso")
public class PresoController {

	@Autowired
	private PresoService presoService;

	@Autowired
	private CelaService celaService;

	@PostMapping("/salvar")
	public ResponseEntity<PresoEntity> savePreso(@RequestBody PresoEntity presoEntity) {
		CelaEntity cela = celaService.findByIdCela(presoEntity.getCela().getId());
		presoEntity.setCela(cela);
		return ResponseEntity.ok(presoService.savePreso(presoEntity));
	}

	@GetMapping("/todos")
	public ResponseEntity<List<PresoEntity>> findAllPresos() {
		return ResponseEntity.ok(presoService.findAllPresos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PresoEntity> findByIdPreso(@PathVariable Long id) {
		return ResponseEntity.ok(presoService.findByIdPreso(id));
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<PresoEntity> updatePreso(@PathVariable Long id, @RequestBody PresoEntity presoEntity) {
		return ResponseEntity.ok(presoService.updatePreso(id, presoEntity));
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletePreso(@PathVariable Long id) {
		presoService.deletePreso(id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/deletarTodos")
	public ResponseEntity<Void> deleteAllPresos() {
		presoService.deleteAllPresos();
		return ResponseEntity.noContent().build();
	}
}
