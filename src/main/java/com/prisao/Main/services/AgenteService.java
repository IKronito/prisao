package com.prisao.Main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prisao.Main.entities.AgenteEntity;
import com.prisao.Main.repositories.AgenteRepository;

@Service
public class AgenteService {

	@Autowired
	private AgenteRepository agenteRepository;

	//Encontrar por ID
	public AgenteEntity findById(Long Id) {

		try {
			return agenteRepository.findById(Id).orElseThrow();
		} catch (Exception e) {
			return new AgenteEntity();
		}

	}

	//Encontrar Todos os Agentes
	public List<AgenteEntity> findAll() {
		return agenteRepository.findAll();
	}

	//SalvarAgente
	public AgenteEntity saveAgente(AgenteEntity agenteEntity) {

		return agenteRepository.save(agenteEntity);
	}

	//Deletar Agente Por ID
	public void deleteAgente(Long id) {
		AgenteEntity agente = findById(id);
		agenteRepository.delete(agente);
	}
	
	

}
