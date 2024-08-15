package com.prisao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prisao.entities.SelaEntity;

@Repository
public interface SelaRepository extends JpaRepository<SelaEntity,Long> {

}
