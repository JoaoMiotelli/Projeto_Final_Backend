package com.projeto_saude.Project_Health.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.projeto_saude.Project_Health.Models.RecomendacaoMedica;
import com.projeto_saude.Project_Health.Repositories.RecomendacaoMedicaRepository;
import java.util.Optional;

@Service
public class RecomendacaoMedicaService {

    @Autowired
    private RecomendacaoMedicaRepository recomendacaoMedicaRepository;

    public Page<RecomendacaoMedica> getAllRecomendacoes(Pageable pageable) {
        return recomendacaoMedicaRepository.findAll(pageable);
    }

    public Optional<RecomendacaoMedica> getRecomendacaoById(Long id) {
        return recomendacaoMedicaRepository.findById(id);
    }

    public RecomendacaoMedica createRecomendacao(RecomendacaoMedica recomendacao) {
        return recomendacaoMedicaRepository.save(recomendacao);
    }

    public RecomendacaoMedica updateRecomendacao(Long id, RecomendacaoMedica recomendacao) {
        recomendacao.setId(id);
        return recomendacaoMedicaRepository.save(recomendacao);
    }

    public void deleteRecomendacao(Long id) {
        recomendacaoMedicaRepository.deleteById(id);
    }
}

