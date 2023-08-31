package br.edu.ufape.poo.barbeariaufape.comunicacao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Login;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Usuario;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.CadastroUsuario;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class UsuarioController implements Serializable {

	@Autowired
	private CadastroUsuario usuarioService;

	@PostMapping("/criarLogin")
	public ResponseEntity<Login> login(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(usuarioService.login(usuario));
	}

	@PostMapping("/criarUsuario")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
		return ResponseEntity.created(null).body(usuarioService.cadastrar(usuario));
	}

	@GetMapping("/listarUsuarios")
	public List<Usuario> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}
 
	@DeleteMapping("/deletarUsuario/{id}")
	public void deletarUsuario(@PathVariable Long id) {
		usuarioService.deletarUsuario(id);
	}

	@PutMapping("/atualizarUsuario/{id}")
	public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario agendamento) {
		return usuarioService.atualizarUsuario(id, agendamento);
	}
}
