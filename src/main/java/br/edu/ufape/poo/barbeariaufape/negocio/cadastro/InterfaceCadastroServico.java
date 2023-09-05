package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;


public interface InterfaceCadastroServico {
	
	Servico procurarServico(Long id);
	Servico salvarServico(Servico entity);
	List<Servico> listarServicos();
	boolean verificarExistenciaServicoId(Long id) ;
	Servico localizarServicoId(Long id);
	void removerServico(Long id);
	Servico atualizarServico(Servico servico);
}
