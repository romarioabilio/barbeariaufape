package br.edu.ufape.poo.barbeariaufape.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double preco;
    private String descricao;
    private int quantidade;
    //ESTÁ CERTO ????
    //quantidade  retira estoque? 
    // quantidade e estoque estão interligados, se sai 1 da quantidade retira 1 do estoque, quantidade == estoque
    public Produto() {
        
    }

    public Produto(String nome, double preco,String produto,int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.descricao=produto;
        this.quantidade=quantidade;
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
    }
}
