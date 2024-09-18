package com.prisao.Main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prisao.Main.entities.AgenteEntity;
import com.prisao.Main.repositories.AgenteRepository;
import com.prisao.Main.services.AgenteService;

@RestController
@RequestMapping("/agente")
public class AgenteController {

	@Autowired
	private AgenteService agenteService;

	@Autowired
	private AgenteRepository agenteRepository;

	@PostMapping("/salvar")
	public AgenteEntity saveagente(@RequestBody AgenteEntity agenteEntity) {
		return agenteService.saveAgente(agenteEntity);
	}

	@GetMapping("findbyid/{id}")
	public ResponseEntity<AgenteEntity> findById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(agenteService.findById(id));
		} catch (Exception e) {
			System.err.println(e.getCause());
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/cargo/{cargo}")
	public List<AgenteEntity> findByCargo(@PathVariable String cargo) {
		return agenteService.findByCargo(cargo);
	}

	// e
	@GetMapping("/findAll")
	public ResponseEntity<List<AgenteEntity>> findAll() {
		try {
			return ResponseEntity.ok(agenteService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<AgenteEntity>> deleteById(@PathVariable Long id) {
		try {
			agenteService.deleteAgente(id);

			List<AgenteEntity> agentes = agenteService.findAll();
			return ResponseEntity.ok(agentes);
		} catch (Exception e) {
			System.err.println(e.getCause());
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/delete/all")
    public ResponseEntity<Void> deleteAll() {
        try {
            agenteService.deleteAllAgentes();
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            System.err.println(e.getCause());
            return ResponseEntity.badRequest().build();
        }
    }

	@GetMapping("/count/{cargo}")
	public int countCargo(@PathVariable String cargo) {
		return agenteService.countCargo(cargo);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<AgenteEntity> updateAgente(@PathVariable Long id, @RequestBody AgenteEntity updateAgente) {
		try {
			AgenteEntity updateEntity = agenteService.updateAgente(id, updateAgente);
			return ResponseEntity.ok(updateEntity);
		} catch (Exception e) {
			System.err.println(e.getCause());
			return ResponseEntity.badRequest().build();
		}
	}
}