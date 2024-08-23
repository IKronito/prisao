package com.prisao.Main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prisao.Main.entities.AgenteEntity;

@Repository
public interface AgenteRepository extends JpaRepository<AgenteEntity,Long> {

	 List<AgenteEntity> findByCargo(String cargo);

	    @Query(value = "select count(id) from agente where cargo=?", nativeQuery = true)
	    int totalCargo(String cargo);
		
	
}
