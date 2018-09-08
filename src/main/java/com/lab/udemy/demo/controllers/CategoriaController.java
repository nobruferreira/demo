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

import com.lab.udemy.demo.domain.Categoria;
import com.lab.udemy.demo.services.CategoriaService;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria categoria1 = new Categoria(1, "Informática");
		Categoria categoria2 = new Categoria(2, "Escritório");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(categoria1);
		lista.add(categoria2);
		
		return lista;
	} 
	
	@GetMapping("{id}")
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		return ResponseEntity.ok(categoriaService.buscar(id));
	} 
}
