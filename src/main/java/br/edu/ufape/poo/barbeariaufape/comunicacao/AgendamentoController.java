package br.edu.ufape.poo.barbeariaufape.comunicacao;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.edu.ufape.poo.barbeariaufape.negocio.fachada.Fachada;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Agendamento;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.CadastroAgendamento;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class AgendamentoController implements Serializable {

    @Autowired
	private Fachada fachada;

    

    @GetMapping("/listarAgendamentos")
    public List<Agendamento> listarAgendamentos() {
        return fachada.listarAgendamentos();
    }

    @PostMapping("/novoAgendamento")
    public ResponseEntity<Agendamento> cadastrar(@RequestBody Agendamento agendamento){
		agendamento = fachada.cadastrarAgendamento(agendamento);
		URI uri = ServletUriComponentsBuilder.fromPath("/{id}").buildAndExpand(agendamento.getId()).toUri();
		return ResponseEntity.created(uri).body(agendamento);
	}

    @DeleteMapping("/deletarAgendamentoId/{id}")
    public void deletarAgendamento(@PathVariable Long id) {
        fachada.deletarAgendamento(id);
    }

    @PutMapping("/atualizarAgendamentoId/{id}")
    public Agendamento atualizarAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamento) {
        return fachada.atualizarAgendamento(id, agendamento);
    }
}