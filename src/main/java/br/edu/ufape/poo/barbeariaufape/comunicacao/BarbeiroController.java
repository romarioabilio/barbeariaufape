package br.edu.ufape.poo.barbeariaufape.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.CadastroBarbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.BarbeiroNaoExisteException;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class BarbeiroController {

    @Autowired
    private CadastroBarbeiro barbeiroService;

    @PostMapping(value = "/adicionarBarbeiro")
	public ResponseEntity<Barbeiro> adicionarBarbeiro(@RequestBody Barbeiro b) {
		return ResponseEntity.ok(barbeiroService.salvarBarbeiro(b));
	}
    
    @GetMapping("/exibirBarbeiro/{id}")
	public Barbeiro exibirBarbeiro(@PathVariable long id) {
		return barbeiroService.procurarBarbeiroId(id);
	}

    @DeleteMapping(value = "/deletarBarbeiroId/{id}")
    public void deletarBarbeiroId(@PathVariable Long id) {
        barbeiroService.deletarBarbeiroId(id);
    }

    @PatchMapping("/atualizarBarbeiro/{id}")
	public Barbeiro atualizarDados(@PathVariable long id, @RequestBody Barbeiro b)  {
		b.setId(id);
		return barbeiroService.salvarBarbeiro(b);
	}
    @DeleteMapping("/deletarBarbeiro/{email}")
	public String deletarBarbeiroEmail(@PathVariable String email) 
		throws BarbeiroNaoExisteException {
		barbeiroService.deletarBarbeiroEmail(email);
		return"ok";
	}
    @GetMapping("/listarBarbeiro")
    public List<Barbeiro> listarBarbeiros() {
        return barbeiroService.listarBarbeiros();
    }
}