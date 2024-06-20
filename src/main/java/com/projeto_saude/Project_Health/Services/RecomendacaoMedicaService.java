package com.projeto_saude.Project_Health.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto_saude.Project_Health.Models.RecomendacaoMedica;
import com.projeto_saude.Project_Health.Repositories.RecomendacaoMedicaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecomendacaoMedicaService {

    @Autowired
    private RecomendacaoMedicaRepository recomendacaoMedicaRepository;

    public List<RecomendacaoMedica> getAllRecomendacoesMedicas() {
        return recomendacaoMedicaRepository.findAll();
    }

    public Optional<RecomendacaoMedica> getRecomendacaoMedicaById(Long id) {
        return recomendacaoMedicaRepository.findById(id);
    }

    public RecomendacaoMedica createRecomendacaoMedica(RecomendacaoMedica recomendacaoMedica) {
        return recomendacaoMedicaRepository.save(recomendacaoMedica);
    }

    public RecomendacaoMedica updateRecomendacaoMedica(Long id, RecomendacaoMedica recomendacaoMedica) {
        recomendacaoMedica.setId(id);
        return recomendacaoMedicaRepository.save(recomendacaoMedica);
    }

    public void deleteRecomendacaoMedica(Long id) {
        recomendacaoMedicaRepository.deleteById(id);
    }
}