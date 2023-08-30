package br.edu.ufape.poo.barbeariaufape.dados;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Agendamento;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;

public interface InterfaceColecaoAgendamento 
    extends JpaRepository<Agendamento, Long>{

    List<Agendamento> findAllByBarbeiroAndData(Barbeiro barbeiro, LocalDate data);
    @Query("SELECT SUM(s.preco) FROM Agendamento a JOIN a.servicos s WHERE a.id = :agendamentoId")
    BigDecimal getTotalServicos(@Param("agendamentoId") Long agendamentoId);


}