package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;

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
	public List<Usuario> listarUsuarios() {
		return colecaoUsuario.findAll();
	}

	@Override
	public Usuario cadastrar(Usuario usuario) {
		return colecaoUsuario.save(usuario);
	}

	@Override
	public void deletarUsuario(Long id) {
		colecaoUsuario.deleteById(id);
	}

	@Override
	public Usuario atualizarUsuario(Long id, Usuario usuario) {
		Usuario usuarioExistente = colecaoUsuario.findById(id).orElse(null);
		if (usuarioExistente != null) {
			usuarioExistente.setLogin(usuario.getLogin());
			usuarioExistente.setSenha(usuario.getSenha());
			usuarioExistente.setTipo(usuario.getTipo());
			return colecaoUsuario.save(usuarioExistente);
		}
		return null;
	}
}
//usuario