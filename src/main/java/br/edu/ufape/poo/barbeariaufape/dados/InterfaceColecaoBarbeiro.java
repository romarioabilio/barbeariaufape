package br.edu.ufape.poo.barbeariaufape.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;

@Repository
public interface InterfaceColecaoBarbeiro 
    extends JpaRepository<Barbeiro, Long>{
	
	public List<Barbeiro> findByNomeContaining(String nome);
    public Barbeiro findByEmail(String email);
}

