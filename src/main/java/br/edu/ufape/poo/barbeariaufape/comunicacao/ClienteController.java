package br.edu.ufape.poo.barbeariaufape.comunicacao;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Cliente;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.CadastroCliente;

@RestController
public class ClienteController {

    @Autowired
	private CadastroCliente clienteService;

    @PostMapping(value = "/cliente")
	public ResponseEntity<Cliente> adicionarCliente(@RequestBody Cliente c) {
		return ResponseEntity.ok(clienteService.salvarCliente(c));
	}
    
    @GetMapping(value = "/cliente/{id}")
	public ResponseEntity<Cliente> carregarCliente(@PathVariable long clienteId) {
		return ResponseEntity.ok(clienteService.procurarClienteId(clienteId));
	}

    @PatchMapping(value = "/cliente/{id}" )
	public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente c, @PathVariable long id) {
		return ResponseEntity.ok(clienteService.atualizarCliente(c));
	}

    



}

