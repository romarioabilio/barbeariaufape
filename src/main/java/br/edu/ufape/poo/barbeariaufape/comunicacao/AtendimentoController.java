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

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class AtendimentoController implements Serializable {
    
    private final CadastroAtendimento atendimentoService;
    
    @Autowired
    public AtendimentoController(CadastroAtendimento cadastroAtendimento) {
        this.atendimentoService = cadastroAtendimento;
    }

    @GetMapping("/listarAtendimentos")
    public List<Atendimento> listarAtendimentos() {
        return atendimentoService.listarAtentimento();
    }

    @GetMapping("/procurarAtendimentoId/{id}")
    public Atendimento encontrarPorId(@PathVariable Long id) {
        return atendimentoService.encontrarPorId(id);
    }

    @PostMapping("/novoAtendimento")
    public ResponseEntity<Atendimento> cadastrar(@RequestBody Atendimento atendimento){
		atendimento = atendimentoService.cadastrarAtendimento(atendimento);
		URI uri = ServletUriComponentsBuilder.fromPath("/{id}").buildAndExpand(atendimento.getId()).toUri();
		return ResponseEntity.created(uri).body(atendimento);
	}
    
    @DeleteMapping("/deletarAtendimentoId/{id}")
    public void deletarAtendimento(@PathVariable Long id) {
        atendimentoService.deletarAtendimento(id);
    }

    @PutMapping("/atualizarAtendimentoId/{id}")
    public Atendimento atualizarAtendimento(@PathVariable Long id, @RequestBody Atendimento atendimento) {
        return atendimentoService.atualizarAtendimento(id, atendimento);
    }
}