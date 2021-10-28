package com.thiago.rest_spring.socialbooks.exceptions;

public class AutorExistente extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -830865065304714699L;

	public AutorExistente(String mensagem) {
		super(mensagem);
	}
	
	public AutorExistente(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
