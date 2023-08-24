package br.edu.ufape.poo.barbeariaufape.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;
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

	@GetMapping("/verificarExistenciaServicoId")
	public boolean verificarExistenciaServicoId(@RequestParam("id") Long id) {
		return servicoService.verificarExistenciaServicoId(id);
	}

	@GetMapping("/localizarServicoId")
	public Servico localizarServicoId(@RequestParam("id") Long id) {
		return servicoService.localizarServicoId(id);
	}

	@GetMapping("/procurarServicoNome")
	public Servico procurarServicoNome(@RequestParam("nome") String nome) throws ServicoNaoExisteException {
		return servicoService.procurarServicoNome(nome);
	}

	@PostMapping("/salvarServico")
	public Servico salvarServico(@RequestBody Servico servico)
			throws ServicoNaoExisteException, ServicoDuplicadoException {
		return servicoService.salvarServico(servico);
	}

	@DeleteMapping("/removerServicoNome")
	public void removerServicoNome(@RequestParam String nome) throws ServicoNaoExisteException {
		servicoService.removerServicoNome(nome);
	}

}