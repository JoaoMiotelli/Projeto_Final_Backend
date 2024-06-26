package com.projeto_saude.Project_Health.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto_saude.Project_Health.Models.AtendimentoMedico;
import com.projeto_saude.Project_Health.Repositories.AtendimentoMedicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoMedicoService {

    @Autowired
    private AtendimentoMedicoRepository atendimentoRepository;

    public List<AtendimentoMedico> getAllAtendimentos() {
        return atendimentoRepository.findAll();
    }

    public Optional<AtendimentoMedico> getAtendimentoById(Long id) {
        return atendimentoRepository.findById(id);
    }

    public AtendimentoMedico createAtendimento(AtendimentoMedico atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public AtendimentoMedico updateAtendimento(Long id, AtendimentoMedico atendimento) {
        atendimento.setId(id);
        return atendimentoRepository.save(atendimento);
    }

    public void deleteAtendimento(Long id) {
        atendimentoRepository.deleteById(id);
    }
}