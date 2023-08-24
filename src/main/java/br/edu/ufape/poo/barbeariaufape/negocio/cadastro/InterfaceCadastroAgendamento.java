package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.time.LocalDateTime;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Cliente;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Agendamento;

public interface InterfaceCadastroAgendamento {

    public void cadastrarAgendamento(String data, String horaInicio, Barbeiro barbeiro, Cliente cliente, Servico servico);
    
    public Agendamento salvarAgendamento(Agendamento agendamento);

    public Agendamento consultarAgendamento(Long id);

    public void alterarAgendamento(Agendamento agendamento);

    public void excluirAgendamento(Long id);

    public Agendamento consultarAgendamentoPorDataHora(LocalDateTime dataHora);

    public Agendamento consultarAgendamentoPorBarbeiro(Barbeiro barbeiro);

    public Agendamento consultarAgendamentoPorCliente(Cliente cliente);

    public Agendamento consultarAgendamentoPorServico(Servico servico);

    

    
}