package com.sena.adso.teamnoche.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.adso.teamnoche.entity.Especialidad;
import com.sena.adso.teamnoche.interfaces.IEspecialidadService;
import com.sena.adso.teamnoche.repository.EspecialidadRepository;

@Service
public class EspecialidadService implements IEspecialidadService {

	@Autowired
	private EspecialidadRepository repository;
	
	@Override
	public List<Especialidad> getAll() {
		 return repository.findAll();
	}

	@Override
	public Optional<Especialidad> getById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Especialidad save(Especialidad especialidad) {
		especialidad.setCreatedAt(LocalDateTime.now());
		return repository.save(especialidad);
	}
	
	/*
	 * consultar el registro por el id
	 * validar si el registro existe
	 * actualizar los valores, parametro -> parametro BD
	 * mandamos a actualizar 
	 */

	@Override
	public void update(Long id, Especialidad especialidad) {
		Optional<Especialidad> especialidadO = repository.findById(id);
		if (especialidadO.isEmpty()) return;
		
		Especialidad especialidadDatabase = especialidadO.get();
		especialidadDatabase.setNombre(especialidad.getNombre());
		especialidadDatabase.setUpdateAt(LocalDateTime.now());
		
		repository.save(especialidadDatabase);
	}

	@Override
	public void delete(Long id) {
	Optional<Especialidad>DeleteEspecialidad = repository.findById(id);
	if(DeleteEspecialidad.isEmpty()) return;
	
	repository.deleteById(id);;
		
	}

}
