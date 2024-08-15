package com.prisao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prisao.entities.AgenteEntity;

@Repository
public interface AgenteRepository extends JpaRepository<AgenteEntity,Long> {

}
