package br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception;

public class ClienteNaoExisteException extends Exception {
    private static final long serialVersionUID = 1L;
	private String email;
	
	public ClienteNaoExisteException(String email) {
		super("Não existe no sistema um Cliente com o email informado");
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
}
