package br.com.projeto._123eco.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projeto._123eco.model.entity.Mensagem;
import br.com.projeto._123eco.model.repository.MensagemRepository;
import jakarta.transaction.Transactional;
@Service
public class MensagemService {
	

		private MensagemRepository mensagemRepository;

		public MensagemService(MensagemRepository mensagemRepository) {
			this.mensagemRepository = mensagemRepository;
		}

		public List<Mensagem> findAll() {
			List<Mensagem> mensagens = mensagemRepository.findAll();
			return mensagens;
		}
		
		public Mensagem findById(long id) {
			Mensagem mensagem = mensagemRepository.findById(id).orElseThrow();
			return mensagem;
		}

		@Transactional
		public Mensagem create(Mensagem mensagem) {
			
			mensagem.setDataMensagem(LocalDateTime.now());
			mensagem.setStatusMensagem("ATIVO");
			mensagem.setTelefone(null);
			mensagem.setDataResposta(null);
			mensagem.setResposta(null);
			
			return mensagemRepository.save(mensagem);
		}
		
		@Transactional
		public Mensagem update(long id) {
			Optional<Mensagem> _mensagem = mensagemRepository.findById(id);
			
			if (_mensagem.isPresent()) {
				Mensagem mensagemAtualizada = _mensagem.get();
				mensagemAtualizada.setStatusMensagem("LIDA");
				
				return mensagemRepository.save(mensagemAtualizada);
			}
			return null;
		}
		
		@Transactional
		public Mensagem inativar(long id) {
			Optional<Mensagem> _mensagem = mensagemRepository.findById(id);
			
			if (_mensagem.isPresent()) {
				Mensagem mensagemAtualizada = _mensagem.get();
				mensagemAtualizada.setStatusMensagem("INATIVO");
				
				return mensagemRepository.save(mensagemAtualizada);
			}
			return null;
		}
	}


