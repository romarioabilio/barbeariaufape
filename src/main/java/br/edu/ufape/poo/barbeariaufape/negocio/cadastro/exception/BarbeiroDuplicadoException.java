package br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception;

public class BarbeiroDuplicadoException extends Exception {
    private static final long serialVersionUID = 1L;
	private String email;
	
	public BarbeiroDuplicadoException(String email) {
		super("Não é possível cadastrar dois Barbeiros com o mesmo email");
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
}
