package br.edu.ufape.poo.barbeariaufape.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@PutMapping("/atualizarProduto")
	public Produto atualizarProduto(@RequestBody Produto produto) throws ProdutoNaoExisteException {
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
	public Produto procurarProdutoNome(@PathVariable String nome) throws ProdutoNaoExisteException {
		return produtoService.procurarProdutoNome(nome);
	}

	@PostMapping("/salvarProduto")
	public Produto salvarProduto(@RequestBody Produto produto)
			throws ProdutoNaoExisteException, ProdutoDuplicadoException {
		return produtoService.salvarProduto(produto);
	}

	@DeleteMapping("/removerProdutoNome/{nome}")
	public void removerProdutoNome(@PathVariable String nome) throws ProdutoNaoExisteException {
		produtoService.removerProdutoNome(nome);
	}

}