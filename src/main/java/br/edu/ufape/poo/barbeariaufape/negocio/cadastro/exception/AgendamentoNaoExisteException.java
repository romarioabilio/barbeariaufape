package br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception;

public class AgendamentoNaoExisteException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AgendamentoNaoExisteException(String msg) {
		super(msg);
	}

}
