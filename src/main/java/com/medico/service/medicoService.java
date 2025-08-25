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
		 especialidad e = eR.findById(r.getEspecialidad().getId()).orElse(null);
		 r.setEspecialidad(e);
		 return mR.save(r);
	
	 }
	 
	 public List<medico> listar(){
		 return mR.findAll();
}
	 
	public medico get(Integer id) {
	return mR.findById(id).orElseThrow(() -> new RuntimeException("Medico no encontrado id:" + id));
	}
	
	public medico actualizar(Integer id,medico r) {
		medico medico = mR.findById(id).orElseThrow(() -> new RuntimeException("Medico no encontrado id:" + r.getId()));
		especialidad especialidad = eR.findById(r.getEspecialidad().getId()).orElseThrow(() -> new RuntimeException("Especialidad no encontrada id:" +r.getEspecialidad().getId()));
	
		medico.setNombre(r.getNombre());
		medico.setEspecialidad(especialidad);
		
		return mR.save(medico);
		
	}
	
	public boolean eliminar(Integer id) {
		if(mR.existsById(id)) {
			mR.deleteById(id);
			return true;
		}
		return false;
	}
	 
}
