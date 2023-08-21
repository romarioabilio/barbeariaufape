package br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception;

public class ProdutoNaoExisteException extends Exception{
	private static final long serialVersionUID = 1L;
	private String nome;
	
	public ProdutoNaoExisteException(String nome) {
		super("Não existe no sistema um produto com o nome informado");
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
}