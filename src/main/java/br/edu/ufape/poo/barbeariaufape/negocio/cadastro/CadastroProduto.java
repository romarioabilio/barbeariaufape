package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.barbeariaufape.dados.InterfaceColecaoProduto;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoNaoExisteException;

@Service
public class CadastroProduto implements InterfaceCadastroProduto {
	@Autowired
	private InterfaceColecaoProduto colecaoProduto;

	
	public Produto salvarProduto(Produto entity) {
		return colecaoProduto.save(entity);
	}

	public List<Produto> listarProdutos() {
		return colecaoProduto.findAll();
	}

	public boolean verificarExistenciaProdutoId(Long id) {
		return colecaoProduto.existsById(id);
	}

	public Produto localizarProdutoId(Long id) {
		return colecaoProduto.findById(id).orElse(null);
	}
	
	public Produto atualizarProduto(Produto produto)  {
		Produto p = procurarProduto(produto.getId());
		p.setNome(produto.getNome());
		p.setPreco(produto.getPreco());
		p.setDescricao(produto.getDescricao());
		p.setQuantidade(produto.getQuantidade());
		return colecaoProduto.save(p);
	}

	public void removerProduto(Long id) {
		Produto p = procurarProduto(id);
		colecaoProduto.delete(p);
	}


	public Produto procurarProduto(Long id) {
		Produto p = colecaoProduto.findById(id).orElse(null);
		return p;		

	}

   

	
}