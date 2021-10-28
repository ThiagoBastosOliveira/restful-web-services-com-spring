package com.thiago.rest_spring.socialbooks.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Comentario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O comentario deve ser preenchido.")
	@Size(max = 1500, message = "O comentario deve conter um máximo de 1500 caracteres.")
	@JsonProperty("comentario")
	private  String texto;
	
	@JsonInclude(Include.NON_NULL)
	private String usuario;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LIVRO_ID")
	@JsonIgnore
	private Livro livro;
}
