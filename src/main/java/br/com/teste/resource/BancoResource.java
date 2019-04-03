package br.com.teste.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.service.ConfiguracaoService;

@RestController
@RequestMapping("/api/banco")
public class BancoResource {
	
	@Autowired
	private ConfiguracaoService service;

	@GetMapping("/envia")
	public ResponseEntity enviaComando() {
		this.service.getLista().forEach(configuracao-> System.out.println(configuracao));
		return ResponseEntity.ok("Comando executado");
	}
}
