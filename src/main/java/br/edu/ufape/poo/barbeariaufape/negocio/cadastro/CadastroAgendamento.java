package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Agendamento;
import br.edu.ufape.poo.barbeariaufape.dados.InterfaceColecaoAgendamento;

@Service
public class CadastroAgendamento implements InterfaceCadastroAgendamento {

    @Autowired
    private InterfaceColecaoAgendamento colecaoAgendamento;

    @Autowired
    public CadastroAgendamento(InterfaceColecaoAgendamento colecaoAgendamento) {
        this.colecaoAgendamento = colecaoAgendamento;
    }

    @Override
    public List<Agendamento> listarAgendamentos() {
        return this.colecaoAgendamento.findAll();
    }

    @Override
    public Agendamento encontrarPorId(Long id) {
        return this.colecaoAgendamento.findById(id).orElse(null);
    }

    @Override
    public Agendamento cadastrarAgendamento(Agendamento agendamento) {
        Agendamento novoAgendamento = this.colecaoAgendamento.save(agendamento);
        BigDecimal totalServicos = colecaoAgendamento.getTotalServicos(novoAgendamento.getId());
        novoAgendamento.setTotal(totalServicos);
        return this.colecaoAgendamento.save(novoAgendamento);
    }

    @Override
    public void deletarAgendamento(Long id) {
        this.colecaoAgendamento.deleteById(id);
    }

    @Override
    public Agendamento atualizarAgendamento(Long id, Agendamento agendamento) {
        Agendamento agendamentoExistente = encontrarPorId(id);
        if (agendamentoExistente != null) {
            atualizarDados(agendamento, agendamentoExistente);
            return this.colecaoAgendamento.save(agendamentoExistente);
        }
        return null;
    }

    @Override
    public void atualizarDados(Agendamento novoAgendamento, Agendamento agendamento) {
        agendamento.setCliente(novoAgendamento.getCliente());
        agendamento.setBarbeiro(novoAgendamento.getBarbeiro());
        agendamento.setServicos(novoAgendamento.getServicos());
        agendamento.setData(novoAgendamento.getData());
        agendamento.setHora(novoAgendamento.getHora());
        agendamento.setObservacao(novoAgendamento.getObservacao());
        agendamento.setTotal(novoAgendamento.getTotal());
    }
}