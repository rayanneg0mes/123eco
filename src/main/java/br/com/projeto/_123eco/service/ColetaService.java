package br.com.projeto._123eco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projeto._123eco.model.entity.Coleta;
import br.com.projeto._123eco.model.repository.ColetaRepository;
import jakarta.transaction.Transactional;


@Service
public class ColetaService {

	private ColetaRepository coletaRepository;
	// ADICIONAR O OBJETO DA INTERFACE REPOSITORY AO CONSTRUTOR DA CLASSE

	public ColetaService(ColetaRepository coletaRepository) {
		this.coletaRepository = coletaRepository;
	}

	public List<Coleta> findAll() {
		List<Coleta> coleta = coletaRepository.findAll();
		return coleta;
	}
	
	public Coleta findById(long id) {
		Coleta coleta = coletaRepository.findById(id).orElseThrow();
		return coleta;
	}
	
	@Transactional
	public Coleta inativar(long id) {
		Optional<Coleta> coleta = coletaRepository.findById(id);
		
		if (coleta.isPresent()) {
			Coleta coletaAtualizada = coleta.get();
			coletaAtualizada.setStatusColeta("INATIVO");
			
			return coletaRepository.save(coletaAtualizada);
		}
		return null;
	}

	@Transactional
	public Coleta create(Coleta coleta){
		
		return coletaRepository.save(coleta);
	}
	

	@Transactional
	public Coleta alterar(long id, Coleta coleta) {
		Optional<Coleta> _coleta = coletaRepository.findById(id);
		
		if (_coleta.isPresent()) {
			Coleta coletaAtualizada =_coleta.get();
			coletaAtualizada.setDataColeta(coleta.getDataColeta());
			coletaAtualizada.setDescricao(coleta.getDescricao());
			return coletaRepository.save(coletaAtualizada);
		}
		return null;
	}
}
