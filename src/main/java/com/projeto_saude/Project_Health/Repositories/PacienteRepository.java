package com.projeto_saude.Project_Health.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto_saude.Project_Health.Models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}