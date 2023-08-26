package br.edu.ufape.poo.barbeariaufape.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;
//import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ServicoDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ServicoNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.CadastroServico;

@RestController
public class ServicoController {

	@Autowired
	private CadastroServico servicoService;

	@GetMapping("/listarServicos")
	public List<Servico> listarServicos() {
		return servicoService.listarServicos();
	}

	@GetMapping("/verificarExistenciaServicoId/{id}")
	public boolean verificarExistenciaServicoId(@PathVariable Long id) {
		return servicoService.verificarExistenciaServicoId(id);
	}

	@GetMapping("/localizarServicoId/{id}")
	public Servico localizarServicoId(@PathVariable Long id) {
		return servicoService.localizarServicoId(id);
	}

	@GetMapping("/procurarServicoNome/{nome}")
	public Servico procurarServicoNome(@PathVariable String nome) throws ServicoNaoExisteException {
		return servicoService.procurarServicoNome(nome);
	}

	@PostMapping("/salvarServico")
	public Servico salvarServico(@RequestBody Servico servico)
			throws ServicoNaoExisteException, ServicoDuplicadoException {
		return servicoService.salvarServico(servico);
	}

	@PutMapping("/atualizarServico")
    public Servico atualizarServico(@RequestBody Servico servico) throws ServicoNaoExisteException {
        return servicoService.atualizarServico(servico);
    }



	@DeleteMapping("/removerServicoNome/{nome}")
	public void removerServicoNome(@PathVariable String nome) throws ServicoNaoExisteException {
		servicoService.removerServicoNome(nome);
	}

}