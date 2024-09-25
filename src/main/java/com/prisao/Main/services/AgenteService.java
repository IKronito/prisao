package com.prisao.Main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prisao.Main.entities.AgenteEntity;
import com.prisao.Main.repositories.AgenteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AgenteService {

	@Autowired
	private AgenteRepository agenteRepository;

	public AgenteEntity saveAgente(AgenteEntity agenteEntity) {
		return agenteRepository.save(agenteEntity);
	}

	public List<AgenteEntity> findAllAgentes() {
		return agenteRepository.findAll();
	}

	public AgenteEntity findByIdAgente(Long id) {
		return agenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Agente não encontrado"));
	}

	public List<AgenteEntity> findByCargoAgente(String cargo) {
		return agenteRepository.findByCargo(cargo);
	}

	public AgenteEntity updateAgente(Long id, AgenteEntity agenteEntity) {
		AgenteEntity existingAgente = findByIdAgente(id);
		existingAgente.setNome(agenteEntity.getNome());
		existingAgente.setCpf(agenteEntity.getCpf());
		existingAgente.setCargo(agenteEntity.getCargo());
		return agenteRepository.save(existingAgente);
	}

	public void deleteAgente(Long id) {
		agenteRepository.deleteById(id);
	}

	public void deleteAllAgentes() {
		agenteRepository.deleteAll();
	}

	public AgenteEntity findAgenteById(long id) {
		return findByIdAgente(id);
	}

	public AgenteEntity createAgente(AgenteEntity agente) {
		return saveAgente(agente);
	}
}
