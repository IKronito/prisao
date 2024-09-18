package com.prisao.Main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prisao.Main.entities.AgenteEntity;

import java.util.List;

@Repository
public interface AgenteRepository extends JpaRepository<AgenteEntity, Long> {
	List<AgenteEntity> findByCargo(String cargo);
}
