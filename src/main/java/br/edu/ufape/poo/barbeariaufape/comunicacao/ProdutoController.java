package br.edu.ufape.poo.barbeariaufape.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.CadastroProduto;

@RestController
public class ProdutoController {

	@Autowired
	private CadastroProduto produtoService;

	@GetMapping("/listarProdutos")
	public List<Produto> listarProdutos() {
		return produtoService.listarProdutos();
	}

	@GetMapping("/verificarExistenciaProdutoId")
	public boolean verificarExistenciaProdutoId(@RequestParam("id") Long id) {
		return produtoService.verificarExistenciaProdutoId(id);
	}

	@GetMapping("/localizarProdutoId")
	public Produto localizarProdutoId(@RequestParam("id") Long id) {
		return produtoService.localizarProdutoId(id);
	}

	@GetMapping("/procurarProdutoNome")
	public Produto procurarProdutoNome(@RequestParam("nome") String nome) throws ProdutoNaoExisteException {
		return produtoService.procurarProdutoNome(nome);
	}

	@PostMapping("/salvarProduto")
	public Produto salvarProduto(@RequestBody Produto produto)
			throws ProdutoNaoExisteException, ProdutoDuplicadoException {
		return produtoService.salvarProduto(produto);
	}

	@DeleteMapping("/removerProdutoNome")
	public void removerProdutoNome(@RequestParam String nome) throws ProdutoNaoExisteException {
		produtoService.removerProdutoNome(nome);
	}

}