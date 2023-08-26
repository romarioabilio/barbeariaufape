package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;


import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ServicoDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ServicoNaoExisteException;


public interface InterfaceCadastroServico {

	Servico procurarServicoNome(String nome) throws ServicoNaoExisteException;

	Servico salvarServico(Servico entity) throws ServicoDuplicadoException;

	List<Servico> listarServicos();

	boolean verificarExistenciaServicoId(Long id);

	Servico localizarServicoId(Long id);

	void removerServicoNome(String nome) throws ServicoNaoExisteException;

	Servico atualizarServico(Servico servico) throws ServicoNaoExisteException;
}