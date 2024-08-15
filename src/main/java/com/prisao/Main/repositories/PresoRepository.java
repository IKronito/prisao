package com.prisao.Main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prisao.Main.entities.PresoEntity;

@Repository
public interface PresoRepository extends JpaRepository<PresoEntity,Long> {

}
