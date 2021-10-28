package com.thiago.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.thiago.socialbooks.client.LivrosClient;
import com.thiago.socialbooks.client.domain.Livro;

public class Aplicacao {
	
	public static void main(String[] args) throws ParseException {
		
		LivrosClient cliente = new LivrosClient("http://localhost:8080", "james", "p4ssw0rd");
		
		List<Livro> listaLivros = cliente.listarLivros();
		
		for(Livro livro : listaLivros) {
			System.out.println("Livro : " + livro.getNome());
		}
		
		Livro livro = new Livro();
		livro.setNome("Quem pouco escuta muito ouve");
		livro.setEditora("Companhia da Pamonha");
		
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yy");
		livro.setPublicacao(publicacao.parse("28/02/2022"));
		
		livro.setResumo("Conta a história de um surdo com Alzheimer.");
		
		String localizacao = cliente.salvar(livro);
		
		System.out.println("URI do livro salvo: " + localizacao);
		
		Livro livroBuscado = cliente.buscar(localizacao);
		
		System.out.println("Livro buscado: " + livroBuscado.getNome());
	}
}
