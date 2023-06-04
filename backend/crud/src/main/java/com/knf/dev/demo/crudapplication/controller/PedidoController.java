package com.knf.dev.demo.crudapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.knf.dev.demo.crudapplication.entity.Pedido;
import com.knf.dev.demo.crudapplication.exception.ResourceNotFoundException;
import com.knf.dev.demo.crudapplication.repository.PedidoRepository;

public class PedidoController {

	
	@Autowired
    private PedidoRepository pedidoRepository;

	
	@GetMapping("/pedido")
	public ResponseEntity<List<Pedido>> findAll() {
		List<Pedido> list = pedidoRepository.findAll();
		return ResponseEntity.ok().body(list);

	}
	
	 @GetMapping("/pedido/{id}")
	    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
	        Pedido pedido = pedidoRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException
	                      ("Id  do pedido não existe :" + id));
	        return ResponseEntity.ok(pedido);

	}
}

