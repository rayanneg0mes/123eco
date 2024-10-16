package br.com.projeto._123eco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projeto._123eco.model.entity.Mensagem;
import br.com.projeto._123eco.model.entity.PostoDeColeta;
import br.com.projeto._123eco.model.repository.PostoDeColetaRepository;
import jakarta.transaction.Transactional;

@Service
public class PostoDeColetaService {
	 private PostoDeColetaRepository postodecoletaRepository;
	  // ADICIONAR O OBJETO DA INTERFACE REPOSITORY AO CONSTRUTOR DA CLASSE
	 
	  public PostoDeColetaService(PostoDeColetaRepository postodecoletaRepository) {
		 this.postodecoletaRepository = postodecoletaRepository;
	  }

	  public List<PostoDeColeta> findAll() {
		List<PostoDeColeta> postodecoleta = postodecoletaRepository.findAll();
		return postodecoleta;
	  }
	  
	  public PostoDeColeta findById(long id) {
		  PostoDeColeta postodecoleta = postodecoletaRepository.findById(id).orElseThrow();
			return postodecoleta;
		}

	  
		@Transactional
		public PostoDeColeta inativar(long id) {
			Optional<PostoDeColeta> _postodecoleta = postodecoletaRepository.findById(id);
			
			if (_postodecoleta.isPresent()) {
				PostoDeColeta postodecoletaAtualizada = _postodecoleta.get();
				postodecoletaAtualizada.setStatusPosto("INATIVO");
				
				return postodecoletaRepository.save(postodecoletaAtualizada);
			}
			return null;
		}
		
		@Transactional
		public PostoDeColeta update(long id) {
			Optional<PostoDeColeta> _postodecoleta = postodecoletaRepository.findById(id);
			
			if (_postodecoleta.isPresent()) {
				PostoDeColeta postodecoletaAtualizada = _postodecoleta.get();
				postodecoletaAtualizada.setStatusPosto("LIDA");
				
				return postodecoletaRepository.save(postodecoletaAtualizada);
			}
			return null;
		}

		@Transactional
		public PostoDeColeta create(PostoDeColeta postodecoleta){
			
			postodecoleta.setStatusPosto("ATIVO");
			return postodecoletaRepository.save(postodecoleta);
		}
		
		@Transactional
		public PostoDeColeta alterar(long id, PostoDeColeta postodecoleta) {
			Optional<PostoDeColeta> _postodecoleta = postodecoletaRepository.findById(id);
			
			if (_postodecoleta.isPresent()) {
				PostoDeColeta postodecoletaAtualizada =_postodecoleta.get();
				postodecoletaAtualizada.setNome(postodecoleta.getNome());
				postodecoletaAtualizada.setLogradouro(postodecoleta.getLogradouro());
				postodecoletaAtualizada.setNumero(postodecoleta.getNumero());
				postodecoletaAtualizada.setComplemento(postodecoleta.getComplemento());
				postodecoletaAtualizada.setCep(postodecoleta.getCep());
				postodecoletaAtualizada.setBairro(postodecoleta.getBairro());
				postodecoletaAtualizada.setCidade(postodecoleta.getCidade());
				postodecoletaAtualizada.setUf(postodecoleta.getUf());
				postodecoletaAtualizada.setPontoRef(postodecoleta.getStatusPosto());
				return postodecoletaRepository.save(postodecoletaAtualizada);
			}
			return null;
		}
}
