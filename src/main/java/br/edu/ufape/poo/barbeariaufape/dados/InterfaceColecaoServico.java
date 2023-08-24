package br.edu.ufape.poo.barbeariaufape.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;

@Repository
public interface InterfaceColecaoServico
	extends JpaRepository<Servico, Long>{
	
	
	public Servico findByNome(String nome);
}