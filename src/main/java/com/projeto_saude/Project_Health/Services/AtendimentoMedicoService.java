package com.projeto_saude.Project_Health.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.projeto_saude.Project_Health.Models.AtendimentoMedico;
import com.projeto_saude.Project_Health.Repositories.AtendimentoMedicoRepository;
import java.util.Optional;

@Service
public class AtendimentoMedicoService {

    @Autowired
    private AtendimentoMedicoRepository atendimentoMedicoRepository;

    public Page<AtendimentoMedico> getAllAtendimentos(Pageable pageable) {
        return atendimentoMedicoRepository.findAll(pageable);
    }

    public Optional<AtendimentoMedico> getAtendimentoById(Long id) {
        return atendimentoMedicoRepository.findById(id);
    }

    public AtendimentoMedico createAtendimento(AtendimentoMedico atendimento) {
        return atendimentoMedicoRepository.save(atendimento);
    }

    public AtendimentoMedico updateAtendimento(Long id, AtendimentoMedico atendimento) {
        atendimento.setId(id);
        return atendimentoMedicoRepository.save(atendimento);
    }

    public void deleteAtendimento(Long id) {
        atendimentoMedicoRepository.deleteById(id);
    }
}


