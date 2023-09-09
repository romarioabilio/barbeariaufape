package br.edu.ufape.poo.barbeariaufape.comunicacao;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Atendimento;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.CadastroAtendimento;
import br.edu.ufape.poo.barbeariaufape.negocio.fachada.Fachada;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class AtendimentoController implements Serializable {
    
    @Autowired
	private Fachada fachada;

    @GetMapping("/listarAtendimentos")
    public List<Atendimento> listarAtendimentos() {
        return fachada.listarAtentimento();
    }

    @GetMapping("/procurarAtendimentoId/{id}")
    public Atendimento encontrarPorId(@PathVariable Long id) {
        return fachada.encontrarPorId(id);
    }

    @PostMapping("/novoAtendimento")
    public ResponseEntity<Atendimento> cadastrar(@RequestBody Atendimento atendimento){
		atendimento = fachada.cadastrarAtendimento(atendimento);
		URI uri = ServletUriComponentsBuilder.fromPath("/{id}").buildAndExpand(atendimento.getId()).toUri();
		return ResponseEntity.created(uri).body(atendimento);
	}
    
    @DeleteMapping("/deletarAtendimentoId/{id}")
    public void deletarAtendimento(@PathVariable Long id) {
        fachada.deletarAtendimento(id);
    }

    @PutMapping("/atualizarAtendimentoId/{id}")
    public Atendimento atualizarAtendimento(@PathVariable Long id, @RequestBody Atendimento atendimento) {
        return fachada.atualizarAtendimento(id, atendimento);
    }
}