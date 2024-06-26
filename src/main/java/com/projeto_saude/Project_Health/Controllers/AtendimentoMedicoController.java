package com.projeto_saude.Project_Health.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto_saude.Project_Health.Models.AtendimentoMedico;
import com.projeto_saude.Project_Health.Models.Paciente;
import com.projeto_saude.Project_Health.Services.AtendimentoMedicoService;
import com.projeto_saude.Project_Health.Services.PacienteService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoMedicoController {

    @Autowired
    private AtendimentoMedicoService atendimentoService;
    
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<AtendimentoMedico>> getAllAtendimentos() {
        List<AtendimentoMedico> atendimentos = atendimentoService.getAllAtendimentos();
        return new ResponseEntity<>(atendimentos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoMedico> getAtendimentoById(@PathVariable Long id) {
        Optional<AtendimentoMedico> atendimento = atendimentoService.getAtendimentoById(id);
        return atendimento.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                          .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<AtendimentoMedico> createAtendimento(@Valid @RequestBody AtendimentoMedico atendimento) {
        Paciente paciente = pacienteService.getPacienteById(atendimento.getPaciente().getId())
                                           .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        atendimento.setPaciente(paciente);
        AtendimentoMedico createdAtendimento = atendimentoService.createAtendimento(atendimento);
        return new ResponseEntity<>(createdAtendimento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtendimentoMedico> updateAtendimento(@PathVariable Long id, @Valid @RequestBody AtendimentoMedico atendimento) {
        Paciente paciente = pacienteService.getPacienteById(atendimento.getPaciente().getId())
                                           .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        atendimento.setPaciente(paciente);
        AtendimentoMedico updatedAtendimento = atendimentoService.updateAtendimento(id, atendimento);
        return new ResponseEntity<>(updatedAtendimento, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtendimento(@PathVariable Long id) {
        atendimentoService.deleteAtendimento(id);
        return ResponseEntity.noContent().build();
    }
}