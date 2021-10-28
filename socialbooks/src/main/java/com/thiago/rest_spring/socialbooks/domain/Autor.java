package com.thiago.rest_spring.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O nome do autor é obrigatório.")
	private String nome;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "A data de nascimento é obrigatória.")
	private Date nascimento;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "A nacionalidade é obrigatória.")
	private String nacionalidade;
	
	@OneToMany(mappedBy = "autor")
	@JsonIgnore
	private List<Livro> livros;
}
