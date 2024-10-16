package br.com.projeto._123eco.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

	@GetMapping("test")
	public String getTest() {
		return "Palmeiras maior campeão do BR!";
	}
			// END POINT
	@GetMapping("message")
	public String getMessage() {
		return "Outra Mensagem!";
	}
	
	@GetMapping("john")
	public String getjohn() {
		return "john john gostoso";
	}
	
}





