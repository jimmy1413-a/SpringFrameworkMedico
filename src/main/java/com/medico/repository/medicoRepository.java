package com.medico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medico.entity.medico;

public interface medicoRepository extends JpaRepository<medico, Integer> {

}
