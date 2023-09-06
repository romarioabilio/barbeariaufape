package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.barbeariaufape.dados.InterfaceColecaoAtendimento;
import br.edu.ufape.poo.barbeariaufape.dados.InterfaceColecaoItem;
import br.edu.ufape.poo.barbeariaufape.dados.InterfaceColecaoProduto;
import br.edu.ufape.poo.barbeariaufape.dados.InterfaceColecaoServico;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Atendimento;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Cliente;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Item;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;

@Service
public class CadastroAtendimento implements InterfaceCadastroAtendimento {

	@Autowired
	private InterfaceColecaoAtendimento colecaoAtendimento;

	@Autowired
	private InterfaceColecaoProduto colecaoProduto;

	@Autowired
	private InterfaceColecaoItem colecaoItem;

	@Autowired
	private InterfaceColecaoServico colecaoServico;

	@Autowired
	public CadastroAtendimento(InterfaceColecaoAtendimento colecaoAtendimento) {
		this.colecaoAtendimento = colecaoAtendimento;
	}

	@Override
	public List<Atendimento> listarAtentimento() {
		return colecaoAtendimento.findAll();
	}

	@Override
	public Atendimento encontrarPorId(Long id) {
		return this.colecaoAtendimento.findById(id).orElse(null);
	}

	@Override
	public Atendimento cadastrarAtendimento(Atendimento atendimento) {
		int n = atendimento.getProdutos().size();
		Item arr[] = new Item[n];
		int i = 0;
		for (Item x : atendimento.getProdutos()) {
			arr[i++] = x;
		}
		for (int j = 0; j < arr.length; j++) {
			Item item = arr[j];
			Optional<Item> itemReturn = colecaoItem.findById(item.getId());
			if (itemReturn.isPresent()) {
				itemReturn.get().setQuantidade(item.getQuantidade());
				atendimento.setTotal(atendimento.getTotal().add(itemReturn.get().getValorTotal()));
				Optional<Produto> produtoReturn = colecaoProduto.findById(item.getId());
				produtoReturn.get().setQuantidade(produtoReturn.get().getQuantidade().subtract(item.getQuantidade()));
				colecaoProduto.save(produtoReturn.get());
			}
			if (!itemReturn.isPresent()) {
				Optional<Produto> produtoReturn = colecaoProduto.findById(item.getId());
				if (produtoReturn.isPresent()) {
					Item itemInsert = new Item(produtoReturn.get().getId(), item.getQuantidade());
					itemInsert.setPreco(produtoReturn.get().getPreco());
					produtoReturn.get().setQuantidade(produtoReturn.get().getQuantidade().subtract(item.getQuantidade()));
					colecaoProduto.save(produtoReturn.get());
					itemInsert.setProduto(produtoReturn.get());
					this.colecaoItem.save(itemInsert);
				}
			}
		}
		int tamanhoServico = atendimento.getServicos().size();
		Servico arrServico[] = new Servico[tamanhoServico];
		i = 0;
		for (Servico x : atendimento.getServicos()) {
			arrServico[i++] = x;
		}
		for (int j = 0; j < arrServico.length; j++) {
			Servico item = arrServico[j];
			Optional<Servico> servicoReturn = colecaoServico.findById(item.getId());
			if (servicoReturn.isPresent()) {
				atendimento.setTotal(atendimento.getTotal().add(servicoReturn.get().getPreco()));
			}
		}

		return this.colecaoAtendimento.save(atendimento);
	}

	public BigDecimal calcularValorTotalAtendimento(Atendimento atendimento) {
		atendimento.recalcularTotal();
		return atendimento.getTotal();
	}

	@Override
	public void adicionarProduto(Atendimento atendimento, Produto produto) {
		Item item = new Item(produto.getId(), BigDecimal.ONE);
		atendimento.getProdutos().add(item);
		atendimento.setTotal(atendimento.getTotal().add(item.getPreco()));
	}

	@Override
	public void adicionarServico(Atendimento atendimento, Servico servico) {
		atendimento.getServicos().add(servico);
		atendimento.setTotal(atendimento.getTotal().add(servico.getPreco()));
	}

	@Override
	public void deletarAtendimento(Long id) {
		this.colecaoAtendimento.deleteById(id);
	}

	public Atendimento atualizarAtendimento(Long id, Atendimento atendimento) {
		Atendimento atendimentoExistente = colecaoAtendimento.findById(id).orElse(null);
		if (atendimentoExistente != null) {
			atualizarDados(atendimento, atendimentoExistente);
			return this.colecaoAtendimento.save(atendimentoExistente);
		}
		return null;
	}

	@Override
	public Atendimento criarNovoAtendimento(LocalDate data, LocalTime hora, Barbeiro barbeiro, Cliente cliente) {
		return new Atendimento(data, hora, barbeiro, cliente);
	}

	@Override
	public void atualizarDados(Atendimento novoAtendimento, Atendimento atendimento) {
		if (novoAtendimento.getData() != null) {
			atendimento.setData(novoAtendimento.getData());
		}
		if (novoAtendimento.getHora() != null) {
			atendimento.setHora(novoAtendimento.getHora());
		}
		if (novoAtendimento.getCliente() != null) {
			atendimento.setCliente(novoAtendimento.getCliente());
		}
		if (novoAtendimento.getBarbeiro() != null) {
			atendimento.setBarbeiro(novoAtendimento.getBarbeiro());
		}
		if (novoAtendimento.getServicos() != null) {
			atendimento.setServicos(novoAtendimento.getServicos());
		}
		if (novoAtendimento.getProdutos() != null) {
			atendimento.setProdutos(novoAtendimento.getProdutos());
		}
		if (novoAtendimento.getPagamento() != null) {
			atendimento.setPagamento(novoAtendimento.getPagamento());
		}
		if (novoAtendimento.getTotal() != null) {
			atendimento.setTotal(novoAtendimento.getTotal());
		}
	}
}