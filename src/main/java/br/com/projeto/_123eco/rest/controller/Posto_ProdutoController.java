package br.com.projeto._123eco.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto._123eco.model.entity.Mensagem;
import br.com.projeto._123eco.model.entity.Posto_Produto;
import br.com.projeto._123eco.service.Posto_ProdutoService;

@RestController
@RequestMapping("/Posto_Produto/")
public class Posto_ProdutoController {
	private Posto_ProdutoService  posto_produtoService;
	  // ADICIONAR O OBJETO DA CLASSE SERVICE AO CONSTRUTOR DA CLASSE

	  public Posto_ProdutoController(Posto_ProdutoService posto_produtoService) {
		 this.posto_produtoService = posto_produtoService;
	  }

	  @GetMapping("findAll")
	  public ResponseEntity<List<Posto_Produto>> findAll(){
		List<Posto_Produto> posto_produtos = posto_produtoService.findAll();
		
		return new ResponseEntity<List<Posto_Produto>>
						(posto_produtos, HttpStatus.OK);
	  }
	
	  @GetMapping("findById/{id}")
		public ResponseEntity<Posto_Produto> findById(@PathVariable long id) {
		  Posto_Produto posto_produto = posto_produtoService.findById(id);
			return new ResponseEntity<Posto_Produto>(posto_produto, HttpStatus.OK);
		}
		
		@PostMapping("create")
		public ResponseEntity<Posto_Produto> create(@RequestBody Posto_Produto mensagem) {
			Posto_Produto _posto_produto = posto_produtoService.create(mensagem);

			return new ResponseEntity<Posto_Produto>(_posto_produto, HttpStatus.OK);
		}
		
		@PutMapping("update/{id}")
		public ResponseEntity<Posto_Produto> update(@PathVariable long id) {

			Posto_Produto posto_produto = posto_produtoService.update(id);

			return new ResponseEntity<Posto_Produto>(posto_produto, HttpStatus.OK);
		}
		
		@PutMapping("inativar/{id}")
		public ResponseEntity<Posto_Produto> inativar(@PathVariable long id) {

			Posto_Produto posto_produto = posto_produtoService.inativar(id);

			return new ResponseEntity<Posto_Produto>(posto_produto, HttpStatus.OK);
		}
	
	
}
