package com.thiago.rest_spring.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.rest_spring.socialbooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long>{

}
