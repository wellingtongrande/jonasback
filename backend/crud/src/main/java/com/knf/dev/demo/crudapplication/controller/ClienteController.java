package com.knf.dev.demo.crudapplication.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knf.dev.demo.crudapplication.entity.Cliente;
import com.knf.dev.demo.crudapplication.exception.ResourceNotFoundException;
import com.knf.dev.demo.crudapplication.repository.ClienteRepository;


@RestController
@RequestMapping("/api/v1")

public class ClienteController {
	@Autowired
    private ClienteRepository clienteRepository;
	
	@GetMapping("/cliente")
	public ResponseEntity<List<Cliente>> cindAll() {
		List<Cliente> list = clienteRepository.findAll();
		return ResponseEntity.ok().body(list);

	}
	
	 @GetMapping("/cliente/{id}")
	    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
	        Cliente c = clienteRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException
	                      ("Id  do cuncionário não existe :" + id));
	        return ResponseEntity.ok(c);

	}
	
	 @PostMapping("/clientes")
	    public Cliente createCliente(@RequestBody Cliente c) {
	        return clienteRepository.save(c);
	    }
	
	 @DeleteMapping("/clientes/{id}")
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
	
	@PutMapping("/clientes/{id}")
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

