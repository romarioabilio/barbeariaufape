package br.edu.ufape.poo.barbeariaufape.negocio.basica;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
public class Atendimento implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@NonNull
    private LocalDate data;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    @NonNull
    private LocalTime hora;

    @NonNull
    private BigDecimal total = BigDecimal.ZERO;

    public Atendimento(LocalDate data, LocalTime hora, Barbeiro barbeiro, Cliente cliente) {
        this.data = data;
        this.hora = hora;
        this.barbeiro = barbeiro;
        this.cliente = cliente;
        this.total = BigDecimal.ZERO; // Inicialize o campo total
    }
    
    private String pagamento;
    
    @ManyToOne
    @NonNull
    private Barbeiro barbeiro;
    
    @ManyToOne
    @NonNull
    private Cliente cliente;

    
    @ManyToMany
	@JoinTable(name = "tb_atendimento_servico", joinColumns = @JoinColumn(name = "atendimento_id"), inverseJoinColumns = @JoinColumn(name = "servico_id"))
	private Set<Servico> servicos = new HashSet<>();
    
    @ManyToMany
    @JoinTable(name = "tb_atendimento_produto", joinColumns = @JoinColumn(name = "atendimento_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private Set<Produto> produtos = new HashSet<>();
    
    public void adicionarServico(Servico servico) {
        servicos.add(servico);
        total = total.add(servico.getPreco()); // Atualiza o total
    }
    
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        total = total.add(produto.getPreco()); // Atualiza o total
    }

    public BigDecimal getTotal() {
        total = BigDecimal.ZERO; // Inicialize o total
        if (servicos != null) {
            for (Servico servico : servicos) {
                if (servico.getPreco() != null) {
                    total = total.add(servico.getPreco());
                }
            }
        }
        if (produtos != null) {
            for (Produto produto : produtos) {
                if (produto.getPreco() != null) {
                    total = total.add(produto.getPreco());
                }
            }
        }
        return total;
    }
    
    @Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atendimento other = (Atendimento) obj;
		return Objects.equals(id, other.id);
	}

}