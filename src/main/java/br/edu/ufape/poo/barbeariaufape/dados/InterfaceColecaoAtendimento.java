package br.edu.ufape.poo.barbeariaufape.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Atendimento;

@Repository
public interface InterfaceColecaoAtendimento
    extends JpaRepository<Atendimento, Long> {

    public List<Atendimento> findById(long id);
}