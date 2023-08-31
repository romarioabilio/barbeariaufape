package br.edu.ufape.poo.barbeariaufape.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Usuario;

@Repository
public interface InterfaceColecaoUsuario extends JpaRepository<Usuario, Long> {

	Usuario findByLoginAndSenha(String login, String senha);
}