package com.medico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.entity.especialidad;
import com.medico.repository.especialidadRepository;

@Service
public class especialidadService {


@Autowired
private especialidadRepository eR;

public especialidad guardar(especialidad request) {
	especialidad nuevo = new especialidad();
	nuevo.setNombre(request.getNombre());
	return eR.save(nuevo);
}


public List<especialidad> listar(){
	return eR.findAll();
}

public especialidad get(Integer id) {
	return eR.findById(id).orElse(null);
}

public especialidad actualizar(Integer id,especialidad r) {
	Optional<especialidad> e = eR.findById(id);
	if(e.isPresent()) {
		especialidad eN = e.get();
		eN.setNombre(r.getNombre());
		return eR.save(eN);
	}else {
		return null;
	}
}
public void eliminar(Integer id) {
	eR.deleteById(id);
	}
}

