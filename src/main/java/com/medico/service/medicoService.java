package com.medico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.entity.especialidad;
import com.medico.entity.medico;
import com.medico.repository.especialidadRepository;
import com.medico.repository.medicoRepository;

@Service
public class medicoService {
		
	 @Autowired
	 private medicoRepository mR;
	 
	 @Autowired
	 private especialidadRepository eR;
	 
	 public medico guardar(medico r) {
		 medico m = new medico();
		
		 m.setEspecialidad(r.getEspecialidad());
		 m.setNombre(r.getNombre());
		 return mR.save(m);
	 }
	 
	 public List<medico> listar(){
		 return mR.findAll();
}
	 
	public medico get(Integer id) {
		return mR.findById(id).orElse(null);
	}
	
	public medico actualizar(Integer id,medico r) {
		medico medico = mR.findById(id).orElseThrow(() -> new RuntimeException("Medico no encontrado id:" + medico.getId()));
		especialidad especialidad = eR.findById(r.getEspecialidad());
	
		medico.setNombre(r.getNombre());
		medico.setEspecialidad(especialidad);
		
		return mR.save(medico);
		
	}
	 
}
