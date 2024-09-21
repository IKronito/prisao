package com.prisao.Main.repositories;

import com.prisao.Main.entities.VisitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaRepository extends JpaRepository<VisitaEntity, Long> {
}
