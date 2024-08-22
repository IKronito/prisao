package com.prisao.Main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prisao.Main.entities.PresoEntity;
import com.prisao.Main.enums.ComportamentoEnum;
import com.prisao.Main.repositories.PresoRepository;

@Service
public class PresoService {

	@Autowired
	private PresoRepository presoRepository;
	private String dataNasc;

	// Encontrar por ID
	public PresoEntity findById(Long Id) {

		try {
			return presoRepository.findById(Id).orElseThrow();
		} catch (Exception e) {
			return new PresoEntity();
		}

	}

	// Encontrar Todos os Presos
	public List<PresoEntity> findAll() {
		return presoRepository.findAll();
	}

	// Salvar Preso
	public PresoEntity savepreso(PresoEntity presoEntity) {
		if (presoEntity.getComportamento().equalsIgnoreCase(ComportamentoEnum.Muito_Bom.toString())
				|| presoEntity.getComportamento().equalsIgnoreCase(ComportamentoEnum.Bom.toString())
				|| presoEntity.getComportamento().equalsIgnoreCase(ComportamentoEnum.Mediano.toString())
				|| presoEntity.getComportamento().equalsIgnoreCase(ComportamentoEnum.Ruim.toString())
				|| presoEntity.getComportamento().equalsIgnoreCase(ComportamentoEnum.Muito_Ruim.toString())) {
			return presoRepository.save(presoEntity);
		} else {
			presoEntity.setComportamento(ComportamentoEnum.Mediano.toString());
		}

		if (presoEntity.getDataNasc() != null && presoEntity.getDataNasc().length() == 9) {

			return presoRepository.save(presoEntity);
		} else {

			throw new IllegalArgumentException("A data de nascimento precisa ter 9 characters. Ex: '25012005'");
		}
	}

	// Deletar Preso Por ID
	public void deletePreso(Long id) {
		PresoEntity preso = findById(id);
		presoRepository.delete(preso);
	}

	public void deletePresoById(Long id) {
		PresoEntity preso = findById(id);
		presoRepository.delete(preso);
	}

	public PresoEntity updatePreso(Long id, PresoEntity updatePreso) {
		PresoEntity presoExistente = findById(id);

		// Atualizar dados de agente
		presoExistente.setNome(updatePreso.getNome());
		presoExistente.setComportamento(updatePreso.getComportamento());
		presoExistente.setDataNasc(updatePreso.getDataNasc());
		presoExistente.setSentenca(updatePreso.getSentenca());
		presoExistente.setCpf(updatePreso.getCpf());

		if (presoExistente.getComportamento().equalsIgnoreCase(ComportamentoEnum.Muito_Bom.toString())
				|| presoExistente.getComportamento().equalsIgnoreCase(ComportamentoEnum.Bom.toString())
				|| presoExistente.getComportamento().equalsIgnoreCase(ComportamentoEnum.Mediano.toString())
				|| presoExistente.getComportamento().equalsIgnoreCase(ComportamentoEnum.Ruim.toString())
				|| presoExistente.getComportamento().equalsIgnoreCase(ComportamentoEnum.Muito_Ruim.toString())) {
			return presoRepository.save(presoExistente);
		} else {
			presoExistente.setComportamento(ComportamentoEnum.Mediano.toString());
		}

		if (presoExistente.getDataNasc() != null && presoExistente.getDataNasc().length() == 9) {

			return presoRepository.save(presoExistente);
		} else {

			throw new IllegalArgumentException("A data de nascimento precisa ter 9 characters. Ex: '25012005'");
		}
	}

}
