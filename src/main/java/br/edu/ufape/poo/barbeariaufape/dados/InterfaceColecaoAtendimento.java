package br.edu.ufape.poo.barbeariaufape.dados;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Atendimento;

public interface InterfaceColecaoAtendimento 
    extends JpaRepository<Atendimento, Long>{

    List<Atendimento> findAllByBarbeiroAndData(Barbeiro barbeiro, LocalDate data);

    @Query("SELECT SUM(s.preco) FROM Atendimento a JOIN a.servicos s WHERE a.id = :atendimentoId")
    BigDecimal getTotalServicos(@Param("atendimentoId") Long atendimentoId);

    @Query("SELECT SUM(p.preco) FROM Atendimento a JOIN a.produtos p WHERE a.id = :atendimentoId")
    BigDecimal getTotalProdutos(@Param("atendimentoId") Long atendimentoId);
}
