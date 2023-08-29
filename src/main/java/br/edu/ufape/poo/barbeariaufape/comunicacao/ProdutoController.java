package br.edu.ufape.poo.barbeariaufape.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.CadastroProduto;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")

public class ProdutoController {

	@Autowired
	private CadastroProduto produtoService;

	@GetMapping("/listarProdutos")
	public List<Produto> listarProdutos() {
		return produtoService.listarProdutos();
	}

	@PutMapping("/atualizarProduto")
	public Produto atualizarProduto( @RequestBody Produto produto)  {
		return produtoService.atualizarProduto(produto);
	}

	@GetMapping("/verificarExistenciaProdutoId/{id}")
	public boolean verificarExistenciaProdutoId(@PathVariable Long id) {
		return produtoService.verificarExistenciaProdutoId(id);
	}

	@GetMapping("/localizarProdutoId/{id}")
	public Produto localizarProdutoId(@PathVariable Long id) {
		return produtoService.localizarProdutoId(id);
	}

	@GetMapping("/procurarProdutoNome/{nome}")
	public Produto procurarProduto(@PathVariable Long id) {
		return produtoService.procurarProduto(id);
	}

	@PostMapping("/salvarProduto")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoService.salvarProduto(produto);
	}

	@DeleteMapping("/removerProduto/{id}")
	public void removerProduto(@PathVariable long id) {
		produtoService.removerProduto(id);
	}

}