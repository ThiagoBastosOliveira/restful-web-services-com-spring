package com.thiago.rest_spring.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.rest_spring.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{
	
}
