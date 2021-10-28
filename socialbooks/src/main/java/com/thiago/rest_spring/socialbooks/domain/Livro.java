package com.thiago.rest_spring.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Livro {
	
	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O nome do livro é obrigatório.")
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "A data de publicação é obrigatória.")
	private Date publicacao;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "O nome da editora é obrigatório.")
	private String editora;
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "O resumo deve ser preenchido.")
	@Size(max = 1500, message = "O resumo deve conter um máximo de 1500 caracteres")
	private String resumo;
	
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "livro")
	private List<Comentario> comentarios;
	
	@ManyToOne
	@JoinColumn(name = "AUTOR_ID")
	@JsonInclude(Include.NON_NULL)
	private Autor autor;
	
	public Livro() {
		
	}
	
	public Livro(String nome) {
		this.nome = nome;
	}
	
}
