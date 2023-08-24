package br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception;

public class ServicoNaoExisteException extends Exception{
	private static final long serialVersionUID = 1L;
	private String nome;
	
	public ServicoNaoExisteException(String nome) {
		super("Não existe no sistema um Serviço com o nome informado");
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
}