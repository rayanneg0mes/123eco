package br.com.projeto._123eco.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projeto._123eco.model.entity.Mensagem;
import br.com.projeto._123eco.model.entity.Posto_Produto;
import br.com.projeto._123eco.model.repository.Posto_ProdutoRepository;
import jakarta.transaction.Transactional;


@Service
public class Posto_ProdutoService {
	 private Posto_ProdutoRepository posto_produtoRepository;
	  // ADICIONAR O OBJETO DA INTERFACE REPOSITORY AO CONSTRUTOR DA CLASSE
	 
	  public Posto_ProdutoService(Posto_ProdutoRepository posto_produtoRepository) {
		 this.posto_produtoRepository = posto_produtoRepository;
	  }

	  public List<Posto_Produto> findAll() {
		List<Posto_Produto>  posto_produto = posto_produtoRepository.findAll();
		return  posto_produto;
	  }
	
	  public Posto_Produto findById(long id) {
		  Posto_Produto posto_produto = posto_produtoRepository.findById(id).orElseThrow();
			return posto_produto;
		}
	  
	  @Transactional
		public Posto_Produto create(Posto_Produto posto_produto) {
	
		  posto_produto.setStatusPosto_Produto("ATIVO");
			
			return posto_produtoRepository.save(posto_produto);
		}
	  
	  @Transactional
		public Posto_Produto update(long id) {
			Optional<Posto_Produto> _posto_produto = posto_produtoRepository.findById(id);
			
			if (_posto_produto.isPresent()) {
				Posto_Produto posto_produtoAtualizada = _posto_produto.get();
				posto_produtoAtualizada.setStatusPosto_Produto("LIDA");
				
				return posto_produtoRepository.save(posto_produtoAtualizada);
			}
			return null;
		}
	  
		@Transactional
		public Posto_Produto inativar(long id) {
			Optional<Posto_Produto> _posto_produto = posto_produtoRepository.findById(id);
			
			if (_posto_produto.isPresent()) {
				Posto_Produto posto_produtoAtualizada = _posto_produto.get();
				posto_produtoAtualizada.setStatusPosto_Produto("INATIVO");
				
				return posto_produtoRepository.save(posto_produtoAtualizada);
			}
			return null;
		}
}