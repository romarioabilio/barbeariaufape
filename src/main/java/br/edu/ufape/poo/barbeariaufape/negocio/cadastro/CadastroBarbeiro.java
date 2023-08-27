package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.poo.barbeariaufape.dados.InterfaceColecaoBarbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.BarbeiroNaoExisteException;

@Service
public class CadastroBarbeiro implements InterfaceCadastroBarbeiro {

    
    @Autowired
    private InterfaceColecaoBarbeiro colecaoBarbeiro;

    @Override
	public List<Barbeiro> procurarBarbeiroNome(String nome) {
		return colecaoBarbeiro.findByNomeContaining(nome);
	}
	
	@Override
	public Barbeiro procurarBarbeiroId(long id) {
		return colecaoBarbeiro.findById(id).orElse(null);
	}

    @Override
	public void deletarBarbeiroId(Long id) {
		colecaoBarbeiro.deleteById(id);
	}

    @Override
	public void deletarBarbeiro(Barbeiro barbeiro) {
		colecaoBarbeiro.delete(barbeiro);
	}
    public Barbeiro procurarBarbeiroEmail(String email)
		    throws BarbeiroNaoExisteException {
		Barbeiro b = colecaoBarbeiro.findByEmail(email); 
		if(b == null) {
			throw new BarbeiroNaoExisteException(email);
		}
		return b;
	}
    @Override
    public void deletarBarbeiroEmail(String email) 
		    throws BarbeiroNaoExisteException {
		Barbeiro b = procurarBarbeiroEmail(email);
		colecaoBarbeiro.delete(b);
	}
    @Override
    public Barbeiro atualizarBarbeiro(Barbeiro barbeiro) {
        return colecaoBarbeiro.save(barbeiro);
    }

    @Override
    public Barbeiro salvarBarbeiro(Barbeiro barbeiro) {
        return colecaoBarbeiro.save(barbeiro);
    }

    @Override
    public List<Barbeiro> listarBarbeiros() {
        return colecaoBarbeiro.findAll();
    }

    
}