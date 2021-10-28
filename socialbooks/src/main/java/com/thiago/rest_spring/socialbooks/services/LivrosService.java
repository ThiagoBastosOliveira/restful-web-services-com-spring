package com.thiago.rest_spring.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.thiago.rest_spring.socialbooks.domain.Comentario;
import com.thiago.rest_spring.socialbooks.domain.Livro;
import com.thiago.rest_spring.socialbooks.exceptions.LivroNaoEncontrado;
import com.thiago.rest_spring.socialbooks.repository.ComentariosRepository;
import com.thiago.rest_spring.socialbooks.repository.LivrosRepository;

@Service
public class LivrosService {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@Autowired
	private ComentariosRepository comentariosRepository;
	
	public List<Livro> listar() {
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		
		Livro livro = livrosRepository.findById(id).orElse(null);
		
		if(livro == null) {
			throw new LivroNaoEncontrado("O livro desejado não foi encontrado.");
		}
		
		return livro;
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		
		return livro = livrosRepository.save(livro);
	}
	
	public void deletar(Long id) {
		
		try {
			livrosRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new LivroNaoEncontrado("O livro desejado não foi encontrado.");
		}
	}
	
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livrosRepository.save(livro);
	}
	
	public void verificarExistencia(Livro livro) {
		buscar(livro.getId());
	}
	
	public Comentario salvarComentario(Long livroId, Comentario comentario) {
		
		Livro livro = buscar(livroId);
		
		comentario.setLivro(livro);
		comentario.setData(new Date());
		
		return comentariosRepository.save(comentario);
	}
	
	public List<Comentario> listarComentarios(Long livroId) {
		
		Livro livro = buscar(livroId);
		
		return livro.getComentarios();
	}
}
