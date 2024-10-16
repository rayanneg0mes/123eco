package br.com.projeto._123eco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projeto._123eco.model.entity.Mensagem;
import br.com.projeto._123eco.model.entity.Produto_Coletado;
import br.com.projeto._123eco.model.repository.Produto_ColetadoRepository;
import jakarta.transaction.Transactional;

@Service
public class Produto_ColetadoService {
	private Produto_ColetadoRepository produto_ColetadoRepository;
	  // ADICIONAR O OBJETO DA INTERFACE REPOSITORY AO CONSTRUTOR DA CLASSE
	 
	  public Produto_ColetadoService(Produto_ColetadoRepository produto_ColetadoRepository) {
		 this.produto_ColetadoRepository = produto_ColetadoRepository;
	  }

	  public List<Produto_Coletado> findAll() {
		List<Produto_Coletado> produto_Coletado = produto_ColetadoRepository.findAll();
		return produto_Coletado;
	  }
	  
	  public Produto_Coletado findById(long id) {
		  Produto_Coletado produto_Coletado = produto_ColetadoRepository.findById(id).orElseThrow();
			return produto_Coletado;
		}
	  
		@Transactional
		public Produto_Coletado create(Produto_Coletado produto_coletado) {
			
			return produto_ColetadoRepository.save(produto_coletado);
		}
		
		@Transactional
		public Produto_Coletado update(long id) {
			Optional<Produto_Coletado> _produto_coletado = produto_ColetadoRepository.findById(id);
			
			if (_produto_coletado.isPresent()) {
				Produto_Coletado produto_coletadoAtualizada = _produto_coletado.get();
			
				
				return produto_ColetadoRepository.save(produto_coletadoAtualizada);
			}
			return null;
		}
		
		@Transactional
		public Produto_Coletado alterar(long id, Produto_Coletado produto_coletado) {
			Optional<Produto_Coletado> _produto_coletado = produto_ColetadoRepository.findById(id);
			
			if (_produto_coletado.isPresent()) {
				Produto_Coletado produto_coletadoAtualizada =_produto_coletado.get();
				produto_coletadoAtualizada.setQuantidade(produto_coletado.getQuantidade());
				produto_coletadoAtualizada.setObs(produto_coletado.getObs());
				
				return produto_ColetadoRepository.save(produto_coletadoAtualizada);
			}
			return null;
		}

		@Transactional
		public Produto_Coletado inativar(long id) {
			Optional<Produto_Coletado> _mensagem = produto_ColetadoRepository.findById(id);
			
			if (_mensagem.isPresent()) {
				Produto_Coletado produto_coletadoAtualizada = _mensagem.get();
				
				
				return produto_ColetadoRepository.save(produto_coletadoAtualizada);
			}
			return null;
		}
}
