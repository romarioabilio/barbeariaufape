package br.edu.ufape.poo.barbeariaufape.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Cliente;

@Repository
public interface InterfaceColecaoCliente 
	extends JpaRepository<Cliente, Long> {
	
	public List<Cliente> findByNomeContaining(String nome);
	public Cliente findByEmail(String email);

}