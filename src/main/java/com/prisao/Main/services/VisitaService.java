package com.prisao.Main.services;

import com.prisao.Main.entities.VisitaEntity;
import com.prisao.Main.repositories.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitaService {

    @Autowired
    private VisitaRepository visitaRepository;

    public VisitaEntity saveVisita(VisitaEntity visitaEntity) {
        return visitaRepository.save(visitaEntity);
    }

    public List<VisitaEntity> findAllVisitas() {
        return visitaRepository.findAll();
    }

    public VisitaEntity findByIdVisita(Long id) {
        return visitaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visita não encontrada"));
    }

    public void deleteVisita(Long id) {
        visitaRepository.deleteById(id);
    }
}
