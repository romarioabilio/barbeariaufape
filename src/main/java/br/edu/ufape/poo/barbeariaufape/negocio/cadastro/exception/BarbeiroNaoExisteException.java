package br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception;

public class BarbeiroNaoExisteException extends Exception{
    private static final long serialVersionUID = 1L;
	private String email;
	
	public BarbeiroNaoExisteException(String email) {
		super("Não existe no sistema um barbeiro com o email informado");
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
}
