package com.simple.simplemoneyapi.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simple.simplemoneyapi.model.Categoria;
import com.simple.simplemoneyapi.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> listar(){
		return ((JpaRepository<Categoria, Long>) categoriaRepository).findAll();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria, HttpServletResponse response) {
	 	Categoria categoriaSalva = categoriaRepository.save(categoria);	
	 	
	 	URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
	 			.buildAndExpand(categoriaSalva.getCodigo()).toUri();
	 	
	 	return ResponseEntity.created(uri).body(categoriaSalva);
	}
}
