package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.barbeariaufape.dados.InterfaceColecaoProduto;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoNaoExisteException;

@Service
public class CadastroProduto implements InterfaceCadastroProduto {
	@Autowired
	private InterfaceColecaoProduto colecaoProduto;

	
	public Produto procurarProdutoNome(String nome)
			throws ProdutoNaoExisteException {
		Produto p = colecaoProduto.findByNome(nome);
		if(p == null) {
			throw new ProdutoNaoExisteException(nome);
		}
		return p;
	}
	
	public Produto salvarProduto(Produto entity)
				throws ProdutoDuplicadoException {
		try {
			procurarProdutoNome(entity.getNome());
			throw new ProdutoDuplicadoException(entity.getNome());
		} catch(ProdutoNaoExisteException err) {
			return colecaoProduto.save(entity);
		}
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
	
	public void removerProdutoNome(String nome) 
			throws ProdutoNaoExisteException {
		Produto p = procurarProdutoNome(nome);
		colecaoProduto.delete(p);
	}
	public Produto atualizarProduto(Produto produto) throws ProdutoNaoExisteException {
		Produto p = procurarProdutoNome(produto.getNome());
		p.setNome(produto.getNome());
		p.setPreco(produto.getPreco());
		p.setDescricao(produto.getDescricao());
		return colecaoProduto.save(p);
	}

   

	
}