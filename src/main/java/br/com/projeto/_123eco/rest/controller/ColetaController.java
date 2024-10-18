package br.com.projeto._123eco.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto._123eco.model.entity.Coleta;
import br.com.projeto._123eco.model.entity.Produto;
import br.com.projeto._123eco.service.ColetaService;


@RestController
@RequestMapping("/coleta/")
public class ColetaController {

	private ColetaService coletaService;

	public ColetaController(ColetaService coletaService) {
		super();
		this.coletaService = coletaService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Coleta>> findAll() {
		List<Coleta> coleta = coletaService.findAll();

		return new ResponseEntity<List<Coleta>>(coleta, HttpStatus.OK);
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Coleta> findById(@PathVariable long id) {
		Coleta coleta = coletaService.findById(id);
		return new ResponseEntity<Coleta>(coleta, HttpStatus.OK);
	}
	
	@PostMapping("create/{email}")
	public ResponseEntity<Coleta> create(
			@ModelAttribute Coleta coleta, 
			@PathVariable String email) {
		
		Coleta _coleta = coletaService.create(coleta, email);
		return new ResponseEntity<Coleta>(_coleta, HttpStatus.OK);
	}

}
