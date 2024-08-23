package com.prisao.Main.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prisao.Main.entities.AgenteEntity;
import com.prisao.Main.entities.PresoEntity;
import com.prisao.Main.enums.CargosEnum;
import com.prisao.Main.repositories.AgenteRepository;
import com.prisao.Main.repositories.PresoRepository;

@Service
public class AgenteService {

	@Autowired
	private AgenteRepository agenteRepository;

	@Autowired
	private PresoRepository presoRepository;

	// Encontrar por ID
	public AgenteEntity findById(Long id) {
		try {
			return agenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Agente não encontrado"));
		} catch (Exception e) {
			return new AgenteEntity();
		}
	}

	public List<AgenteEntity> findAll() {
		return agenteRepository.findAll();
	}

	public AgenteEntity saveAgente(AgenteEntity agenteEntity) {

		if (!isValidCargo(agenteEntity.getCargo())) {
			agenteEntity.setCargo(CargosEnum.Guarda.toString());
		}

		// Salva o agente
		AgenteEntity salvoAgente = agenteRepository.save(agenteEntity);

		if (salvoAgente.getPresoIds() != null) {
			for (Long presoId : salvoAgente.getPresoIds()) {

				if (!presoRepository.existsById(presoId)) {
					throw new RuntimeException("Preso com ID " + presoId + " não encontrado");
				} else {

					PresoEntity existingPreso = presoRepository.findById(presoId).orElseThrow();

					if (!existingPreso.getAgentes().contains(salvoAgente)) {
						existingPreso.getAgentes().add(salvoAgente);

						presoRepository.save(existingPreso);
					}
				}
			}
		}

		if (salvoAgente.getPresos() != null) {
	        for (PresoEntity preso : salvoAgente.getPresos()) {
	            if (!preso.getAgentes().contains(salvoAgente)) {
	                preso.getAgentes().add(salvoAgente);
	                presoRepository.save(preso);
	            }
	        }
	    }

		return salvoAgente;
	}

	// Deletar Agente Por ID
	public void deleteAgente(Long id) {
		AgenteEntity agente = findById(id);

		if (agente.getPresos() != null) {
			for (PresoEntity preso : agente.getPresos()) {
				preso.getAgentes().remove(agente);
				presoRepository.save(preso);
			}
		}

		agenteRepository.delete(agente);
	}

	public void deleteAllAgentes() {
		List<AgenteEntity> agentes = agenteRepository.findAll();

		for (AgenteEntity agente : agentes) {
			if (agente.getPresos() != null) {
				for (PresoEntity preso : agente.getPresos()) {
					preso.getAgentes().remove(agente);
					presoRepository.save(preso);
				}
			}
		}

		agenteRepository.deleteAll();
	}

	public List<AgenteEntity> findByCargo(String cargo) {
		return agenteRepository.findByCargo(cargo);
	}

	public int countCargo(String cargo) {
		return agenteRepository.totalCargo(cargo);
	}

	public AgenteEntity updateAgente(Long id, AgenteEntity updateAgente) {
		AgenteEntity agenteExistente = findById(id);

		// Atualizar dados de agente
		agenteExistente.setNome(updateAgente.getNome());
		agenteExistente.setDataNasc(updateAgente.getDataNasc());
		agenteExistente.setTelefone(updateAgente.getTelefone());
		agenteExistente.setCargo(updateAgente.getCargo());
		agenteExistente.setCpf(updateAgente.getCpf());
		if (agenteExistente.getPresoIds() != null) {
			agenteExistente.setPresoIds(updateAgente.getPresoIds());
		} else {
			throw new RuntimeException();
		}

		if (!isValidCargo(agenteExistente.getCargo())) {
			agenteExistente.setCargo(CargosEnum.Guarda.toString());
		}

		if (agenteExistente.getPresoIds() != null) {
			for (Long presoId : agenteExistente.getPresoIds()) {
				if (!presoRepository.existsById(presoId)) {
					throw new RuntimeException("Preso com ID " + presoId + " não encontrado");
				}
			}
		}

		if (agenteExistente.getPresoIds() != null) {
			for (Long presoId : agenteExistente.getPresoIds()) {
				PresoEntity preso = presoRepository.findById(presoId).orElseThrow();
				if (!preso.getAgentes().contains(agenteExistente)) {
					preso.getAgentes().add(agenteExistente);
					presoRepository.save(preso);
				}
			}
		}

		return agenteExistente;
	}

	private boolean isValidCargo(String cargo) {
		return cargo.equalsIgnoreCase(CargosEnum.Chefe.toString())
				|| cargo.equalsIgnoreCase(CargosEnum.Sub_chefe.toString())
				|| cargo.equalsIgnoreCase(CargosEnum.Oficial.toString())
				|| cargo.equalsIgnoreCase(CargosEnum.Supervisor.toString());
	}
}
