package com.thiago.rest_spring.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.rest_spring.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long> {
	
	
}
