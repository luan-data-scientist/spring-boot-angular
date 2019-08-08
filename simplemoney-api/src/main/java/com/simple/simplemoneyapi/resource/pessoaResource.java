package com.simple.simplemoneyapi.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simple.simplemoneyapi.model.Pessoa;
import com.simple.simplemoneyapi.repository.pessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class pessoaResource {

	@Autowired
	private pessoaRepository pessoaRepository;
	
	@GetMapping
	public List<Pessoa> listar(){
		return((JpaRepository<Pessoa, Long>) pessoaRepository).findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long codigo){
		Pessoa pessoa = pessoaRepository.findOne(codigo);
		return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();	
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response){
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(pessoaSalva.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(pessoaSalva);
	}
	
}
