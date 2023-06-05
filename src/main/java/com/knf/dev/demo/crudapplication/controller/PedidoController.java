package com.knf.dev.demo.crudapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.knf.dev.demo.crudapplication.entity.Pedido;
import com.knf.dev.demo.crudapplication.exception.ResourceNotFoundException;
import com.knf.dev.demo.crudapplication.repository.PedidoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("/pedido")
	public Page<Pedido> findAllPagination(
			@RequestParam(value = "page", defaultValue = "0") Integer pagina,
			@RequestParam(value = "size", defaultValue = "5") Integer tamanhoPagina) {
		PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina);
		return pedidoRepository.findAll(pageRequest);
	}

	@GetMapping("/pedido/{id}")
	public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
		Pedido pedido = pedidoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id  do pedido não existe :" + id));
		return ResponseEntity.ok(pedido);

	}
}
