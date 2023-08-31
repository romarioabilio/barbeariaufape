package br.edu.ufape.poo.barbeariaufape.negocio.basica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Login {

	private String tipoUsuario;
	private boolean logado;

}
