package com.medico.entity;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name= "citas")
@Data
public class citas {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer estado;
	
	
	private Date fecha;
	private Date fechaasignacion;
	private Time hora;
	
	
	@OneToOne
	@JoinColumn(name="medico",referencedColumnName = "id")
	private medico medico;
	
	@OneToOne
	@JoinColumn(name="paciente",referencedColumnName = "id")
	private paciente paciente;
	
	
	

}
