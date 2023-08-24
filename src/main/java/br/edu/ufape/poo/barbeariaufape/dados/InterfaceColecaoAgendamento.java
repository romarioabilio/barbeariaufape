package br.edu.ufape.poo.barbeariaufape.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Agendamento;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Cliente;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface InterfaceColecaoAgendamento 
    extends JpaRepository<Agendamento, Long>{
    
    public Agendamento findById(ID id);
    
    List<Agendamento> findByCliente(Cliente cliente);
    
    List<Agendamento> findByBarbeiro(Barbeiro barbeiro);
    
    List<Agendamento> findByServico(Servico servico);
    
    List<Agendamento> findByDataHora(LocalDateTime start);
    
}
