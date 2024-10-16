package br.com.projeto._123eco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projeto._123eco.model.entity.Produto;
import br.com.projeto._123eco.model.entity.Produto_Coletado;
import br.com.projeto._123eco.model.repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

	private ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public List<Produto> findAll(){
		List<Produto> produto = produtoRepository.findAll();
		return produto;
	}
	
	 public Produto findById(long id) {
		 Produto produto = produtoRepository.findById(id).orElseThrow();
			return produto;
		}
	
	@Transactional
	public Produto create(Produto produto) {
		
		produto.setStatusProd("ATIVO");
		
		return produtoRepository.save(produto);
	}
	
	@Transactional
	public Produto inativar(long id) {
		Optional<Produto> _produto = produtoRepository.findById(id);
		
		if (_produto.isPresent()) {
			Produto produtoAtualizada = _produto.get();
			produtoAtualizada.setStatusProd("INATIVO");
			
			return produtoRepository.save(produtoAtualizada);
		}
		return null;
	}
	
	@Transactional
	public Produto alterar(long id, Produto produto) {
		Optional<Produto> _produto = produtoRepository.findById(id);
		
		if (_produto.isPresent()) {
			Produto produtoAtualizada = _produto.get();
			produtoAtualizada.setDescricao(produto.getDescricao());
			
			return produtoRepository.save(produtoAtualizada);
		}
		return null;
	}
}
