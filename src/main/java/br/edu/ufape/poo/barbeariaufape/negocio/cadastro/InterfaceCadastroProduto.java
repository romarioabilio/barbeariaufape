package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;


import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoNaoExisteException;


public interface InterfaceCadastroProduto {

	Produto procurarProduto(Long id);

	Produto salvarProduto(Produto entity);

	List<Produto> listarProdutos();

	boolean verificarExistenciaProdutoId(Long id) throws ProdutoNaoExisteException;

	Produto localizarProdutoId(Long id) throws ProdutoNaoExisteException;

	void removerProduto(Long id);

	Produto atualizarProduto(Produto produto) ;

}