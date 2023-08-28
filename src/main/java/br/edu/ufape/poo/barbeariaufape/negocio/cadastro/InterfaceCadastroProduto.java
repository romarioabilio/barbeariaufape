package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;


import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoNaoExisteException;


public interface InterfaceCadastroProduto {

	Produto procurarProdutoNome(String nome) throws ProdutoNaoExisteException;

	Produto salvarProduto(Produto entity) throws ProdutoDuplicadoException;

	List<Produto> listarProdutos();

	boolean verificarExistenciaProdutoId(Long id) throws ProdutoNaoExisteException;

	Produto localizarProdutoId(Long id) throws ProdutoNaoExisteException;

	void removerProdutoNome(String nome) throws ProdutoNaoExisteException;

	Produto atualizarProduto(Produto produto) throws ProdutoNaoExisteException;

}