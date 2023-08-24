package br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception;

public class ServicoDuplicadoException extends Exception {
    private static final long serialVersionUID = 1L;
	private String nome;
	
	public ServicoDuplicadoException(String nome) {
		super("Não é possível cadastrar dois Serviços com o mesmo nome");
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}
    

