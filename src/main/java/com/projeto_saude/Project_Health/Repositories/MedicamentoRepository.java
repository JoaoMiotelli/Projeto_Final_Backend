package com.projeto_saude.Project_Health.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto_saude.Project_Health.Models.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
}