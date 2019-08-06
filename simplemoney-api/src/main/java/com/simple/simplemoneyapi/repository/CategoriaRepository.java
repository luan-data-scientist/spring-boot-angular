package com.simple.simplemoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.simplemoneyapi.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
}
