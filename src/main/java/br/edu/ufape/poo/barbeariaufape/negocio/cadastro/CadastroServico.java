package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.barbeariaufape.dados.InterfaceColecaoServico;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ServicoDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ServicoNaoExisteException;

@Service
public class CadastroServico implements InterfaceCadastroServico {
	@Autowired
	private InterfaceColecaoServico colecaoServico;

	
	public Servico procurarServicoNome(String nome)
			throws ServicoNaoExisteException {
		Servico s = colecaoServico.findByNome(nome);
		if(s == null) {
			throw new ServicoNaoExisteException(nome);
		}
		return s;
	}
	
	public Servico salvarServico(Servico entity)
				throws ServicoDuplicadoException {
		try {
			procurarServicoNome(entity.getNome());
			throw new ServicoDuplicadoException(entity.getNome());
		} catch(ServicoNaoExisteException err) {
			return colecaoServico.save(entity);
		}
	}

	public List<Servico> listarServicos() {
		return colecaoServico.findAll();
	}

	public boolean verificarExistenciaServicoId(Long id) {
		return colecaoServico.existsById(id);
	}

	public Servico localizarServicoId(Long id) {
		return colecaoServico.findById(id).orElse(null);
	}
	
	public void removerServicoNome(String nome) 
			throws ServicoNaoExisteException {
		Servico s = procurarServicoNome(nome);
		colecaoServico.delete(s);
	}
	public Servico atualizarServico(Servico servico) throws ServicoNaoExisteException {
        Servico s = procurarServicoNome(servico.getNome());
        s.setNome(servico.getNome());
        s.setPreco(servico.getPreco());
        s.setDescricao(servico.getDescricao());
        return colecaoServico.save(s);
    }
   

	
}