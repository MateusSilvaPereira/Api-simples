package br.dev.msp.drogaria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drogaria")
public class DrogariaController {

	@GetMapping("/ola")
	public String mostarMensagem() {
		return "Olá Mundo!";
	}
}
