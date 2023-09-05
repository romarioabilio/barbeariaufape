package br.edu.ufape.poo.barbeariaufape.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.CadastroServico;
import br.edu.ufape.poo.barbeariaufape.negocio.fachada.Fachada;

@RestController
@CrossOrigin(origins = "*")

public class ServicoController {

	@Autowired
	

	private Fachada fachada;

	@GetMapping("/listarServicos")
	public List<Servico> listarServicos() {
		return fachada.listarServicos();
	}

	@PutMapping("/atualizarServico")
    public Servico atualizarServico(@RequestBody Servico servico) {
		return fachada.atualizarServico(servico);
    }
	
	@GetMapping("/verificarExistenciaServicoId/{id}")
	public boolean verificarExistenciaServicoId(@PathVariable Long id) {
		return fachada.verificarExistenciaServicoId(id);
	}
	
	@GetMapping("/localizarServicoId/{id}")
	public Servico localizarServicoId(@PathVariable Long id) {
		return fachada.localizarServicoId(id);
	}
	
	@GetMapping("/procurarServico/{id}")
	public Servico procurarServico(@PathVariable Long id) {
		return fachada.procurarServico(id);
	}
	
	@PostMapping("/salvarServico")
	public Servico salvarServico(@RequestBody Servico servico) {
		return fachada.salvarServico(servico);
	}
	
	@DeleteMapping("/removerServico/{id}")
	public void removerServico(@PathVariable long id) {
		fachada.removerServico(id);
	}
}