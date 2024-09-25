package com.prisao.Main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prisao.Main.entities.PresoEntity;
import com.prisao.Main.repositories.PresoRepository;
import java.util.List;

@Service
public class PresoService {

	@Autowired
	private PresoRepository presoRepository;

	public PresoEntity savePreso(PresoEntity presoEntity) {
		return presoRepository.save(presoEntity);
	}

	public List<PresoEntity> findAllPresos() {
		return presoRepository.findAll();
	}

	public PresoEntity findByIdPreso(Long id) {
		return presoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Preso não encontrado"));
	}

	public PresoEntity updatePreso(Long id, PresoEntity presoEntity) {
		PresoEntity existingPreso = findByIdPreso(id);
		existingPreso.setNome(presoEntity.getNome());
		existingPreso.setCpf(presoEntity.getCpf());
		existingPreso.setDataNasc(presoEntity.getDataNasc());
		existingPreso.setCrime(presoEntity.getCrime());
		existingPreso.setSentenca(presoEntity.getSentenca());
		existingPreso.setComportamento(presoEntity.getComportamento());
		existingPreso.setCela(presoEntity.getCela());
		return presoRepository.save(existingPreso);
	}

	public void deletePreso(Long id) {
		presoRepository.deleteById(id);
	}

	public void deleteAllPresos() {
		presoRepository.deleteAll();
	}
}
