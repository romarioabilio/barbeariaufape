package br.edu.ufape.poo.barbeariaufape.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String rua;
	private String bairro;
	private String estado;
	private String cep;
	private String numero;
    private String cidade;
	
	
	
	public Endereco(String logradouro, String bairro, String uf, String cep, String numero) {
		super();
		this.rua = logradouro;
		this.bairro = bairro;
		this.estado= uf;
		this.cep = cep;
		this.numero = numero;
	}
	public Endereco() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }

	
	
	

}
