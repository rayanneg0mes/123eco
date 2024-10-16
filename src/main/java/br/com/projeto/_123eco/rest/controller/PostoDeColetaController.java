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
import br.com.projeto._123eco.model.entity.Posto_Produto;
import br.com.projeto._123eco.service.PostoDeColetaService;

@RestController
@RequestMapping("/postoDeColeta/")
public class PostoDeColetaController {

	private PostoDeColetaService postodecoletaService;
	// ADICIONAR O OBJETO DA CLASSE SERVICE AO CONSTRUTOR DA CLASSE

	public PostoDeColetaController(PostoDeColetaService postodecoletaService) {
		super();
		this.postodecoletaService = postodecoletaService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<PostoDeColeta>> findAll() {
		List<PostoDeColeta> postosdecoleta = postodecoletaService.findAll();

		return new ResponseEntity<List<PostoDeColeta>>(postosdecoleta, HttpStatus.OK);
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<PostoDeColeta> findById(@PathVariable long id) {
		PostoDeColeta postodecoleta = postodecoletaService.findById(id);
		return new ResponseEntity<PostoDeColeta>(postodecoleta, HttpStatus.OK);
	}

	@PostMapping("create")
	public ResponseEntity<PostoDeColeta> create(@RequestBody PostoDeColeta postoDeColeta) {
		PostoDeColeta _postoDeColeta = postodecoletaService.create(postoDeColeta);

		return new ResponseEntity<PostoDeColeta>(_postoDeColeta, HttpStatus.OK);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<PostoDeColeta> update(@PathVariable long id) {

		PostoDeColeta postodecoleta = postodecoletaService.update(id);

		return new ResponseEntity<PostoDeColeta>(postodecoleta, HttpStatus.OK);
	}

	@PutMapping("inativar/{id}")
	public ResponseEntity<PostoDeColeta> inativar(@PathVariable long id) {

		PostoDeColeta postodecoleta = postodecoletaService.inativar(id);

		return new ResponseEntity<PostoDeColeta>(postodecoleta, HttpStatus.OK);
	}

}
