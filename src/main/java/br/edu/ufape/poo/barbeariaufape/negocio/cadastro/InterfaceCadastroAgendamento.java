package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Agendamento;

import java.util.List;

public interface InterfaceCadastroAgendamento {

	List<Agendamento> listarAgendamentos();
	Agendamento encontrarPorId(Long id);
	Agendamento cadastrarAgendamento(Agendamento agendamento);
	void deletarAgendamento(Long id);
	Agendamento atualizarAgendamento(Long id, Agendamento agendamento);
	void atualizarDados(Agendamento novoAgendamento, Agendamento agendamento);
}