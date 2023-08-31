package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.barbeariaufape.dados.InterfaceColecaoUsuario;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Login;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Usuario;

@Service
public class CadastroUsuario implements InterfaceCadastroUsuario {
	
	@Autowired
	private InterfaceColecaoUsuario colecaoUsuario;

	@Override
	public Login login(Usuario usuario) {
		Usuario usuarioCollection = colecaoUsuario.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());
		Login retorno = new Login();
		if (usuarioCollection != null) {
			retorno.setLogado(true);
			retorno.setTipoUsuario(usuarioCollection.getTipo());
		}
		return retorno;
	}

	@Override
	public Usuario cadastrar(Usuario usuario) {
		return colecaoUsuario.save(usuario);
	}

}