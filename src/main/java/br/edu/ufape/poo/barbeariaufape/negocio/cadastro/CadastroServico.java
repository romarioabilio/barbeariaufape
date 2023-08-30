package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.barbeariaufape.dados.InterfaceColecaoServico;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;

@Service
public class CadastroServico implements InterfaceCadastroServico {
	@Autowired
	private InterfaceColecaoServico colecaoServico;
	
	public Servico salvarServico(Servico entity) {
			return colecaoServico.save(entity);
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

	public Servico procurarServico(Long id) {
		Servico s = colecaoServico.findById(id).orElse(null);
		return s;		

	}

	public void removerServico(Long id) {
		Servico s = procurarServico(id);
		colecaoServico.delete(s);
	}

	public Servico atualizarServico(Servico servico) {
        Servico s = procurarServico(servico.getId());
        s.setNome(servico.getNome());
        s.setPreco(servico.getPreco());
        s.setDescricao(servico.getDescricao());
        return colecaoServico.save(s);
    }
   

	
}