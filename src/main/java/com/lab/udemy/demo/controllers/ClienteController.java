package com.lab.udemy.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.client.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lab.udemy.demo.domain.Cliente;
import com.lab.udemy.demo.services.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("{id}")
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		return ResponseEntity.ok(clienteService.buscar(id));
	} 
}
