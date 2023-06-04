package com.knf.dev.demo.crudapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.knf.dev.demo.crudapplication.entity.Produto;
import com.knf.dev.demo.crudapplication.exception.ResourceNotFoundException;
import com.knf.dev.demo.crudapplication.repository.ProdutoRepository;

public class ProdutoController {

	@Autowired
    private ProdutoRepository produtoRepository;

	
	@GetMapping("/produto")
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> list = produtoRepository.findAll();
		return ResponseEntity.ok().body(list);

	}
	
	 @GetMapping("/produto/{id}")
	    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
	        Produto p = produtoRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException
	                      ("Id  do produto não existe :" + id));
	        return ResponseEntity.ok(p);

	}
}
