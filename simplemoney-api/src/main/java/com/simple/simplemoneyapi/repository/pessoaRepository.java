package com.simple.simplemoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.simplemoneyapi.model.Pessoa;

public interface pessoaRepository extends JpaRepository<Pessoa, Long>{

}
