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

import br.com.projeto._123eco.model.entity.PostoDeColeta;
import br.com.projeto._123eco.model.entity.Produto_Coletado;
import br.com.projeto._123eco.service.Produto_ColetadoService;

@RestController
@RequestMapping("/produtocoletado/")
public class Produto_ColetadoController {

	private Produto_ColetadoService produtocoletaService;
	// ADICIONAR O OBJETO DA CLASSE SERVICE AO CONSTRUTOR DA CLASSE

	public Produto_ColetadoController(Produto_ColetadoService produtocoletaService) {
		this.produtocoletaService = produtocoletaService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Produto_Coletado>> findAll() {
		List<Produto_Coletado> produtocoleta = produtocoletaService.findAll();

		return new ResponseEntity<List<Produto_Coletado>>(produtocoleta, HttpStatus.OK);
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Produto_Coletado> findById(@PathVariable long id) {
		Produto_Coletado produtocoleta = produtocoletaService.findById(id);
		return new ResponseEntity<Produto_Coletado>(produtocoleta, HttpStatus.OK);
	}

	@PostMapping("create")
	public ResponseEntity<Produto_Coletado> create(@RequestBody Produto_Coletado produto_coletado) {
		Produto_Coletado _produtocoleta = produtocoletaService.create(produto_coletado);

		return new ResponseEntity<Produto_Coletado>(_produtocoleta, HttpStatus.OK);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<Produto_Coletado> update(@PathVariable long id) {

		Produto_Coletado produtocoleta = produtocoletaService.update(id);

		return new ResponseEntity<Produto_Coletado>(produtocoleta, HttpStatus.OK);
	}

	@PutMapping("inativar/{id}")
	public ResponseEntity<Produto_Coletado> inativar(@PathVariable long id) {

		Produto_Coletado produtocoleta = produtocoletaService.inativar(id);

		return new ResponseEntity<Produto_Coletado>(produtocoleta, HttpStatus.OK);
	}
}