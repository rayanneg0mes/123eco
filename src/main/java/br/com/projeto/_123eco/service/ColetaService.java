package br.com.projeto._123eco.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projeto._123eco.model.entity.Coleta;
import br.com.projeto._123eco.model.entity.PostoDeColeta;
import br.com.projeto._123eco.model.entity.Usuario;
import br.com.projeto._123eco.model.repository.ColetaRepository;
import br.com.projeto._123eco.model.repository.PostoDeColetaRepository;
import br.com.projeto._123eco.model.repository.UsuarioRepository;
import jakarta.transaction.Transactional;


@Service
public class ColetaService {

	private ColetaRepository coletaRepository;
	private UsuarioRepository usuarioRepository;
	private PostoDeColetaRepository postoDeColetaRepository;
	// ADICIONAR O OBJETO DA INTERFACE REPOSITORY AO CONSTRUTOR DA CLASSE

	public ColetaService(ColetaRepository coletaRepository, UsuarioRepository usuarioRepository,
			PostoDeColetaRepository postoDeColetaRepository) {
		super();
		this.coletaRepository = coletaRepository;
		this.usuarioRepository = usuarioRepository;
		this.postoDeColetaRepository = postoDeColetaRepository;
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
	public Coleta create(Coleta coleta, String email){
		
		Usuario usuario = usuarioRepository.findByEmail(email);
		//PostoDeColeta postoDeColeta = postoDeColetaRepository.findById(postodecoleta_id).get();
		
		coleta.setUsuario(usuario);
		coleta.setDataColeta(LocalDateTime.now());
		coleta.setStatusColeta("ATIVO");
		
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
