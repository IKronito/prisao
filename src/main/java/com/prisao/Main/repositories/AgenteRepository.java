package com.prisao.Main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prisao.Main.entities.AgenteEntity;

@Repository
public interface AgenteRepository extends JpaRepository<AgenteEntity,Long> {

	 //List<PresoEntity> findByPreso(String preso);

	   // @Query(value = "select count(id) from veiculos where marca=?", nativeQuery = true)
	   // int totalMarcas(String marca);
		
	
}
