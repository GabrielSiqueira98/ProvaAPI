package org.serratec.curriculo.service;

import java.util.List;
import java.util.Optional;

import org.serratec.curriculo.dto.CandidatoDto;
import org.serratec.curriculo.model.Candidato;
import org.serratec.curriculo.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository repositorio;
	
	public List<CandidatoDto> obterTodos() {
		return repositorio.findAll().stream().map(c -> CandidatoDto.toDto(c)).toList();
	}
	public Optional<CandidatoDto> obterPorId(Long id) {
		if(!repositorio.existsById(id)) {
			return Optional.empty();
		}
	return Optional.of(CandidatoDto.toDto(repositorio.findById(id).get()));
	}

	public CandidatoDto salvarCandidato(CandidatoDto dto) {
		Candidato candidatoEntity = repositorio.save(dto.toEntity());
		return CandidatoDto.toDto(candidatoEntity);
	}
	
	public boolean apagarCandidato(Long id) {
		if(!repositorio.existsById(id)) {
			return false;
		}
		repositorio.deleteById(id);
		return true;
		}
		
		public Optional<CandidatoDto> alterarCandidato(Long id, CandidatoDto dto) {
			if (!repositorio.existsById(id)) {
				return Optional.empty();
			}
		Candidato candidatoEntity = dto.toEntity();
		repositorio.save(candidatoEntity);
		return Optional.of(CandidatoDto.toDto(candidatoEntity));
		}
		
		public List<CandidatoDto> obterPorVaga(String vaga){
			List<Candidato> candidatos = repositorio.findByVagaDesejada(vaga);
			return candidatos.stream().map(c -> CandidatoDto.toDto(c)).toList();
}
			
		public List<CandidatoDto> obterPorEscolaridade(String escolaridade) {
			 List<Candidato> candidatos = repositorio.findByEscolaridade(escolaridade);
			  return candidatos.stream().map(c -> CandidatoDto.toDto(c)).toList();
		}
		}
		
