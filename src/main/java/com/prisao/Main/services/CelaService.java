package com.prisao.Main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prisao.Main.entities.CelaEntity;
import com.prisao.Main.repositories.CelaRepository;

import java.util.List;

@Service
public class CelaService {

    @Autowired
    private CelaRepository celaRepository;

    public CelaEntity saveCela(CelaEntity celaEntity) {
        return celaRepository.save(celaEntity);
    }

    public List<CelaEntity> findAllCelulas() {
        return celaRepository.findAll();
    }

    public CelaEntity findByIdCela(Long id) {
        return celaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cela não encontrada"));
    }

    public CelaEntity updateCela(Long id, CelaEntity celaEntity) {
        CelaEntity existingCela = findByIdCela(id);

        existingCela.setNumero(celaEntity.getNumero());
        existingCela.setDescricao(celaEntity.getDescricao());
        existingCela.setCapacidade(celaEntity.getCapacidade());
        existingCela.setLocalizacao(celaEntity.getLocalizacao());

        return celaRepository.save(existingCela);
    }


    public void deleteCela(Long id) {
        celaRepository.deleteById(id);
    }

    public void deleteAllCelulas() {
        celaRepository.deleteAll();
    }
}
