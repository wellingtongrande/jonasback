package com.knf.dev.demo.crudapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.knf.dev.demo.crudapplication.entity.Categoria;
import com.knf.dev.demo.crudapplication.exception.ResourceNotFoundException;
import com.knf.dev.demo.crudapplication.repository.CategoriaRepository;

public class CategoriaController {

	

	@Autowired
    private CategoriaRepository categoriaRepository;

	
	@GetMapping("/categoria")
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> list = categoriaRepository.findAll();
		return ResponseEntity.ok().body(list);

	}
	
	 @GetMapping("/categoria/{id}")
	    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
	        Categoria categoria = categoriaRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException
	                      ("Id  do categoria não existe :" + id));
	        return ResponseEntity.ok(categoria);

	}
}


