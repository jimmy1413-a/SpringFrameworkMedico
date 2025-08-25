package com.medico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medico.entity.citas;


public interface citasRepository extends JpaRepository<citas, Integer> {

}