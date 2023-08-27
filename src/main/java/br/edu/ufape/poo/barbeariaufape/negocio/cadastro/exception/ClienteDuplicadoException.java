package br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception;

public class ClienteDuplicadoException extends Exception {
    private static final long serialVersionUID = 1L;
	private String email;
	
	public ClienteDuplicadoException(String email) {
		super("Não é possível cadastrar dois clientes com o mesmo email");
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
}
