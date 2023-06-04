package com.knf.dev.demo.crudapplication.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.knf.dev.demo.crudapplication.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.knf.dev.demo.crudapplication.entity.Cliente;
import com.knf.dev.demo.crudapplication.exception.ResourceNotFoundException;
import com.knf.dev.demo.crudapplication.repository.ClienteRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")

public class ClienteController {
	@Autowired
    private ClienteRepository clienteRepository;

	@GetMapping("/cliente")
	public Page<Cliente> findAllPagination(
			@RequestParam(value = "page", defaultValue = "0") Integer pagina,
			@RequestParam(value = "size", defaultValue = "5") Integer tamanhoPagina) {
		PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina);
		return clienteRepository.findAll(pageRequest);
	}
	
	 @GetMapping("/cliente/{id}")
	    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
	        Cliente c = clienteRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException
	                      ("Id  do cuncionário não existe :" + id));
	        return ResponseEntity.ok(c);

	}
	
	 @PostMapping("/cliente")
	    public Cliente createCliente(@RequestBody Cliente c) {
			return clienteRepository.save(c);
	    }
	
	 @DeleteMapping("/cliente/{id}")
	    public ResponseEntity<Map<String, Boolean>> deleteCliente
	               (@PathVariable Long id) {
	        Cliente c = clienteRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException
	            ("Id do cuncionário não existe :" + id));
	        clienteRepository.delete(c);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deletado", Boolean.TRUE);
	        return ResponseEntity.ok(response);
	 }
	
	@PutMapping("/cliente/{id}")
    public ResponseEntity<Cliente> updatedCliente(@PathVariable Long id,
             @RequestBody Cliente clienteDetails) {
        Cliente c = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                      ("Id do cuncionário não existe :" + id));
       c.setNome(clienteDetails.getNome());
       c.setIdade(clienteDetails.getIdade());
       c.setTelefone(clienteDetails.getTelefone());
       c.setSenha(clienteDetails.getSenha());
       c.setEmail(clienteDetails.getEmail());
        
        Cliente updatedCliente = clienteRepository.save(c);
        return ResponseEntity.ok(updatedCliente);
	}
}

