package com.thiago.rest_spring.socialbooks.exceptions;

public class AutorNaoEncontrado extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -830865065304714699L;

	public AutorNaoEncontrado(String mensagem) {
		super(mensagem);
	}
	
	public AutorNaoEncontrado(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
