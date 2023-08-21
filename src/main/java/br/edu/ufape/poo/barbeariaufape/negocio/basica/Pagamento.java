package br.edu.ufape.poo.barbeariaufape.negocio.basica;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Atendimento atendimento;

    private LocalDate dataPagamento;
    private double valorTotal;
    private boolean pago;
    
    
    private String tipoPagamento;

    public Pagamento() {
        
    }

    public Pagamento(Atendimento atendimento, LocalDate dataPagamento, double valorTotal, boolean pago, String tipoPagamento) {
        this.atendimento = atendimento;
        this.dataPagamento = dataPagamento;
        this.valorTotal = valorTotal;
        this.pago = pago;
        this.tipoPagamento = tipoPagamento;
    }

    
    
   

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public Atendimento getAtendimento() {
        return atendimento;
    }
    public void setAtendimento(Atendimento atendimento){
        this.atendimento = atendimento;
    }
    public LocalDate getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(LocalDate dataPagamento){
        this.dataPagamento = dataPagamento;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal){
        this.valorTotal = valorTotal;
    }
    public boolean getPago() {
        return pago;
    }
    public void setPago(boolean pago){
        this.pago = pago;
    }
    
}
