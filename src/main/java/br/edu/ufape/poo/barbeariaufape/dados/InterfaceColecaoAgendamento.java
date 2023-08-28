package br.edu.ufape.poo.barbeariaufape.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Agendamento;


public interface InterfaceColecaoAgendamento extends JpaRepository<Agendamento, Long>{

}
