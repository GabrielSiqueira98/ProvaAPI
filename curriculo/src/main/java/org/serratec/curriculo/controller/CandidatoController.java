package org.serratec.curriculo.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.curriculo.dto.CandidatoDto;
import org.serratec.curriculo.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {
	@Autowired
	private CandidatoService servico;
	
	
	@GetMapping
	public List<CandidatoDto> obterTodos(){
		return servico.obterTodos();
		}
	@GetMapping("/{id}")
	public ResponseEntity<CandidatoDto> obterPorId(@PathVariable Long id) {
        Optional<CandidatoDto> dto = servico.obterPorId(id);
        if (!dto.isPresent()) {
            return ResponseEntity.notFound().build();
            }
        return ResponseEntity.ok(dto.get());
	}
    
	@GetMapping("/vaga/{vaga}")
    public List<CandidatoDto> obterPorVaga(@PathVariable String vaga) {
        return servico.obterPorVaga(vaga);
        }
 
	 @GetMapping("/escolaridade/{escolaridade}")
	    public List<CandidatoDto> obterPorEscolaridade(@PathVariable String escolaridade) {
	        return servico.obterPorEscolaridade(escolaridade);
	    }
	  @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public CandidatoDto cadastrarCandidato(@RequestBody CandidatoDto dto) {
	        return servico.salvarCandidato(dto);
	    }
	  @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCandidato(@PathVariable Long id) {
	        if (!servico.apagarCandidato(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.noContent().build();
	    }
	  @PutMapping("/{id}")
	    public ResponseEntity<CandidatoDto> alterarCandidato(@PathVariable Long id, @RequestBody CandidatoDto dto) {
	        Optional<CandidatoDto> candidatoAlterado = servico.alterarCandidato(id, dto);
	        if (!candidatoAlterado.isPresent()) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(candidatoAlterado.get());
	    }
}
