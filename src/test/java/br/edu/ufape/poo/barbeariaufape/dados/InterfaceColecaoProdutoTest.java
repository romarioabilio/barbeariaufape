package br.edu.ufape.poo.barbeariaufape.dados;

import java.util.List;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;

public interface InterfaceColecaoProdutoTest {
    Produto salvarProduto(Produto produto);
    List<Produto> listarProdutos();
}