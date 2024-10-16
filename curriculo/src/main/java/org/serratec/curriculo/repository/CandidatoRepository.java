package org.serratec.curriculo.repository;

import java.util.List;

import org.serratec.curriculo.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository  extends JpaRepository<Candidato, Long> {
	 List<Candidato> findByVagaDesejada(String vaga);
	 List<Candidato> findByEscolaridade(String escolaridade);
}
