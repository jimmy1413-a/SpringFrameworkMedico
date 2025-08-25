package com.medico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medico.entity.paciente;


public interface pacienteRepository extends JpaRepository<paciente, Integer> {

}