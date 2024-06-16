package com.projeto_saude.Project_Health.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto_saude.Project_Health.Models.RecomendacaoMedica;

public interface RecomendacaoMedicaRepository extends JpaRepository<RecomendacaoMedica, Long> {
}