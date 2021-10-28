package com.thiago.rest_spring.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.thiago.rest_spring.socialbooks.domain.DetalhesErro;
import com.thiago.rest_spring.socialbooks.exceptions.AutorExistente;
import com.thiago.rest_spring.socialbooks.exceptions.AutorNaoEncontrado;
import com.thiago.rest_spring.socialbooks.exceptions.LivroNaoEncontrado;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(LivroNaoEncontrado.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontrado(LivroNaoEncontrado e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O livro não foi encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.socialblocks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(AutorExistente.class)
	public ResponseEntity<DetalhesErro> handleAutorExistente(AutorExistente e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("O autor já existe.");
		erro.setMensagemDesenvolvedor("http://erros.socialblocks.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(AutorNaoEncontrado.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontrado(AutorNaoEncontrado e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O autor não foi encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.socialblocks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontrado(DataIntegrityViolationException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição inválida.");
		erro.setMensagemDesenvolvedor("http://erros.socialblocks.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
