package br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception;

public class ProdutoDuplicadoException extends Exception{
	private static final long serialVersionUID = 1L;
	private String nome;
	
	public ProdutoDuplicadoException(String nome) {
		super("Não é possível cadastrar dois produtos com o mesmo nome");
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}