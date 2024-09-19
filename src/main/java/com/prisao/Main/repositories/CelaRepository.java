package com.prisao.Main.repositories;

import com.prisao.Main.entities.CelaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelaRepository extends JpaRepository<CelaEntity, Long> {
}
