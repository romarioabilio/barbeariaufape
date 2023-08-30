package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ServicoNaoExisteException;

public interface InterfaceCadastroServico {
	
	Servico procurarServicoNome(String nome);
	Servico salvarServico(Servico entity);
	List<Servico> listarServicos();
	boolean verificarExistenciaServicoId(Long id) throws ServicoNaoExisteException;
	Servico localizarServicoId(Long id);
	void removerServico(Long id);
	Servico procurarServico(Long id);
	Servico atualizarServico(Servico servico);
}
