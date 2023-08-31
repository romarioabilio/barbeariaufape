package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Login;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Usuario;

public interface InterfaceCadastroUsuario {
	Login login(Usuario usuario);
    List<Usuario> listarUsuarios();
	Usuario cadastrar(Usuario usuario);
    void deletarUsuario(Long id);
    Usuario atualizarUsuario(Long id, Usuario usuario);
}
