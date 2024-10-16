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

import br.com.projeto._123eco.model.entity.Produto;
import br.com.projeto._123eco.model.entity.Produto_Coletado;
import br.com.projeto._123eco.service.ProdutoService;

@RestController
@RequestMapping("/produto/")
public class ProdutoController {

	private ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> produtos = produtoService.findAll();

		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);

	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Produto> findById(@PathVariable long id) {
		Produto produto = produtoService.findById(id);
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}

	@PostMapping("create")
	public ResponseEntity<Produto> create(@RequestBody Produto produto) {
		Produto _produto = produtoService.create(produto);

		return new ResponseEntity<Produto>(_produto, HttpStatus.OK);
	}

	@PutMapping("inativar/{id}")
	public ResponseEntity<Produto> inativar(@PathVariable long id) {

		Produto produto = produtoService.inativar(id);

		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}

	@PutMapping("alterar/{id}")
	public ResponseEntity<Produto> alterar(@PathVariable long id, @RequestBody Produto produto) {

		Produto _produto = produtoService.alterar(id, produto);

		return new ResponseEntity<Produto>(_produto, HttpStatus.OK);
	}
}
