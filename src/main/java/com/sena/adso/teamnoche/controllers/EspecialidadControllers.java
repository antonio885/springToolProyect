package com.sena.adso.teamnoche.controllers;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sena.adso.teamnoche.entity.Especialidad;
import com.sena.adso.teamnoche.services.EspecialidadService;

import jakarta.persistence.PostUpdate;
@RestController
//http://localhost:9000/especialidades
@RequestMapping("especialidades")
public class EspecialidadControllers {

	@Autowired
	private EspecialidadService service;
	
	
	@GetMapping
	public ResponseEntity<List<Especialidad>> getAll() {
		return ResponseEntity.ok(service.getAll()); 
	}
	//http://localhost:9000/especialidades/1
 @GetMapping("{id}")
 public ResponseEntity<Optional<Especialidad>> getById(@PathVariable Long id){
	Optional<Especialidad> especialidad = service.getById(id);
	return ResponseEntity.ok(especialidad);
 }
 @PostMapping
 public ResponseEntity<Especialidad>save(@RequestBody Especialidad especialidad){
	 Especialidad especialidadDaEspecialidad = service.save(especialidad);
	 return ResponseEntity.ok(especialidadDaEspecialidad);
 }
 @PutMapping("{id}")
 public ResponseEntity<Especialidad> update(@PathVariable Long id, @RequestBody Especialidad especialidad) {
	    Optional<Especialidad> especialidads = service.getById(id);
	    Especialidad updatedEspecialidad = especialidads.get();
        updatedEspecialidad.setNombre(especialidad.getNombre());
        Especialidad updatespecialidades = service.save(updatedEspecialidad);
		return ResponseEntity.ok(updatespecialidades);
 }
 @DeleteMapping("{id}")
 public ResponseEntity<Especialidad> delete(@PathVariable Long id){
service.delete(id);
	return ResponseEntity.ok(null);
 }
}