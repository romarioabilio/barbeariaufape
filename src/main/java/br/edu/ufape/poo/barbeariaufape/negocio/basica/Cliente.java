package br.edu.ufape.poo.barbeariaufape.negocio.basica;

import jakarta.persistence.Entity;

@Entity
public class Cliente extends Pessoa {

    private boolean vip;

    public Cliente() {
        
    }

    public Cliente(String nome, String cpf, String telefone, Endereco endereco, boolean vip) {
        super(nome, cpf, telefone, endereco);
        this.vip = vip;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
