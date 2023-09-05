package br.edu.ufape.poo.barbeariaufape.comunicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Cliente;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ClienteNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.fachada.Fachada;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ClienteDuplicadoException;

@RestController
@CrossOrigin(origins = "*")
public class ClienteController {

	@Autowired
	private Fachada fachada;

	@PostMapping(value = "/adicionarCliente")
	public ResponseEntity<Cliente> adicionarCliente(@RequestBody Cliente c) {
		return ResponseEntity.ok(fachada.salvarCliente(c));
	}

	@GetMapping("/exibirCliente/{id}")
	public Cliente exibirCliente(@PathVariable long id) {
		return fachada.procurarClienteId(id);
	}

	@PutMapping("/atualizarCliente/{id}")
	public Cliente atualizarDados(@PathVariable long id, @RequestBody Cliente c) throws ClienteDuplicadoException {
		c.setId(id);
		return fachada.salvarCliente(c);
	}

	@GetMapping("/listarCliente")
	public List<Cliente> listarClientes() {
		return fachada.listarClientes();
	}


	@DeleteMapping(value = "/deletarClienteId/{id}")
	public void deletarClienteId(@PathVariable Long id) {
		fachada.deletarClienteId(id);
	}

	@DeleteMapping("/deletarClienteEmail/{email}")
	public String deletarClienteEmail(@PathVariable String email)
			throws ClienteNaoExisteException {
		fachada.deletarClienteEmail(email);
		return "ok";
	}
}