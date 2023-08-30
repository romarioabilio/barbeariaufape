package br.edu.ufape.poo.barbeariaufape.comunicacao;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Agendamento;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.CadastroAgendamento;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class AgendamentoController implements Serializable {

    private final CadastroAgendamento agendamentoService;

    @Autowired
    public AgendamentoController(CadastroAgendamento cadastroAgendamento) {
        this.agendamentoService = cadastroAgendamento;
    }

    @GetMapping("/listarAgendamentos")
    public List<Agendamento> listarAgendamentos() {
        return agendamentoService.listarAgendamentos();
    }

    @GetMapping("/procurarAgendamentoId/{id}")
    public Agendamento encontrarPorId(@PathVariable Long id) {
        return agendamentoService.encontrarPorId(id);
    }

    @PostMapping("/novoAgendamento")
    public ResponseEntity<Agendamento> cadastrar(@RequestBody Agendamento agendamento){
		agendamento = agendamentoService.cadastrarAgendamento(agendamento);
		URI uri = ServletUriComponentsBuilder.fromPath("/{id}").buildAndExpand(agendamento.getId()).toUri();
		return ResponseEntity.created(uri).body(agendamento);
	}

    @DeleteMapping("/deletarAgendamentoId/{id}")
    public void deletarAgendamento(@PathVariable Long id) {
        agendamentoService.deletarAgendamento(id);
    }

    @PutMapping("/atualizarAgendamentoId/{id}")
    public Agendamento atualizarAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamento) {
        return agendamentoService.atualizarAgendamento(id, agendamento);
    }
}