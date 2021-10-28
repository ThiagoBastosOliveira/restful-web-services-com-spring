package com.thiago.rest_spring.socialbooks.exceptions;

public class LivroNaoEncontrado extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -830865065304714699L;

	public LivroNaoEncontrado(String mensagem) {
		super(mensagem);
	}
	
	public LivroNaoEncontrado(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
