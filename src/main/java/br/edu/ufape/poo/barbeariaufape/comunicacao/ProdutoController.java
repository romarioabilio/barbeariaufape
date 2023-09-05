package br.edu.ufape.poo.barbeariaufape.comunicacao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.fachada.Fachada;

@RestController
@CrossOrigin(origins = "*")

public class ProdutoController {

	@Autowired
	private Fachada fachada;

	@GetMapping("/listarProdutos")
	public List<Produto> listarProdutos() {
		return fachada.listarProdutos();
	}

	@PutMapping("/atualizarProduto")
	public Produto atualizarProduto( @RequestBody Produto produto)  {
		return fachada.atualizarProduto(produto);
	}

	@GetMapping("/verificarExistenciaProdutoId/{id}")
	public boolean verificarExistenciaProdutoId(@PathVariable Long id) throws ProdutoNaoExisteException{
		return fachada.verificarExistenciaProdutoId(id);
	}

	@GetMapping("/localizarProdutoId/{id}")
	public Produto localizarProdutoId(@PathVariable Long id) throws ProdutoNaoExisteException{
		return fachada.localizarProdutoId(id);
	}

	@GetMapping("/procurarProduto/{id}")
	public Produto procurarProduto(@PathVariable Long id) {
		return fachada.procurarProduto(id);
	}

	@PostMapping("/salvarProduto")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return fachada.salvarProduto(produto);
	}

	@DeleteMapping("/removerProduto/{id}")
	public void removerProduto(@PathVariable long id) {
		fachada.removerProduto(id);
	}
}