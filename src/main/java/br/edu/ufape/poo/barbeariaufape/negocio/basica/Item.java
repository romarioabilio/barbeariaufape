package br.edu.ufape.poo.barbeariaufape.negocio.basica;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Item {

	@Id
	private Long id;
	@OneToOne
	private Produto produto;
	private BigDecimal preco;
	private BigDecimal quantidade;

	public Item(Long id, BigDecimal quantidade) {
		this.id = id;
		this.quantidade = quantidade;
	}

	public Item() {
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorTotal() {
		if (preco != null && quantidade.compareTo(BigDecimal.ZERO) > 0) {
			return preco.multiply(quantidade);
		} else {
			return BigDecimal.ZERO;
		}
	}

}
