package com.prisao.Main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prisao.Main.entities.AgenteEntity;
import com.prisao.Main.enums.CargosEnum;
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
	public AgenteEntity saveagente(AgenteEntity agenteEntity) {
		if (agenteEntity.getCargo().equalsIgnoreCase(CargosEnum.Chefe.toString())
				|| agenteEntity.getCargo().equalsIgnoreCase(CargosEnum.Sub_chefe.toString())
				|| agenteEntity.getCargo().equalsIgnoreCase(CargosEnum.Oficial.toString())
				|| agenteEntity.getCargo().equalsIgnoreCase(CargosEnum.Supervisor.toString())
				) {
			return agenteRepository.save(agenteEntity);
		} else {
			agenteEntity.setCargo(CargosEnum.Guarda.toString());
		}

		return agenteRepository.save(agenteEntity);
	}

	//Deletar Agente Por ID
	public void deleteAgente(Long id) {
		AgenteEntity agente = findById(id);
		agenteRepository.delete(agente);
	}
	
	public void deleteAgenteById(Long id) {
        AgenteEntity agente = findById(id);
        agenteRepository.delete(agente);
    }

	public AgenteEntity updateAgente(Long id, AgenteEntity updateAgente) {
        AgenteEntity agenteExistente = findById(id);

        // Atualizar dados de agente
        agenteExistente.setNome(updateAgente.getNome());
        agenteExistente.setSobrenome(updateAgente.getSobrenome());
        agenteExistente.setTelefone(updateAgente.getTelefone());
        agenteExistente.setCargo(updateAgente.getCargo());
        agenteExistente.setCpf(updateAgente.getCpf());
       
        return agenteRepository.save(agenteExistente);
    }
}
