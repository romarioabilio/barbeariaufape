package br.edu.ufape.poo.barbeariaufape.negocio.basica;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Agendamento agendamento;

    private LocalDate dataPagamento;
    private double valorTotal;
    private boolean pago;
    
    // Novo atributo para o tipo de pagamento
    private String tipoPagamento;

    public Pagamento() {
        // Construtor vazio necessário para JPA
    }

    public Pagamento(Agendamento agendamento, LocalDate dataPagamento, double valorTotal, boolean pago, String tipoPagamento) {
        this.agendamento = agendamento;
        this.dataPagamento = dataPagamento;
        this.valorTotal = valorTotal;
        this.pago = pago;
        this.tipoPagamento = tipoPagamento;
    }

    // Getters e setters
    
   

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
    public Agendamento getAgendamento() {
        return agendamento;
    }
    public void setAgendamento(Agendamento agendamento){
        this.agendamento = agendamento;
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
