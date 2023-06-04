package com.knf.dev.demo.crudapplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.knf.dev.demo.crudapplication.entity.Funcionario;
import com.knf.dev.demo.crudapplication.exception.ResourceNotFoundException;
import com.knf.dev.demo.crudapplication.repository.FuncionarioRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")

public class FuncionarioController {
	@Autowired
    private FuncionarioRepository funcionarioRepository;
	
	@GetMapping("/funcionario")
	public ResponseEntity<List<Funcionario>> findAll() {

		List<Funcionario> list = funcionarioRepository.findAll();
		return ResponseEntity.ok().body(list);

	}

	
	 @GetMapping("/funcionario/{id}")
	    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
	        Funcionario f = funcionarioRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException
	                      ("Id  do funcionário não existe :" + id));
	        return ResponseEntity.ok(f);

	}
	
	 @PostMapping("/funcionario")
	    public Funcionario createFuncionario(@RequestBody Funcionario f) {
	        return funcionarioRepository.save(f);
	    }
	
	 @DeleteMapping("/funcionario/{id}")
	    public ResponseEntity<Map<String, Boolean>> deleteFuncionario
	               (@PathVariable Long id) {
	        Funcionario f = funcionarioRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException
	            ("Id do funcionário não existe :" + id));
	        funcionarioRepository.delete(f);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deletado", Boolean.TRUE);
	        return ResponseEntity.ok(response);
	 }
	
	@PutMapping("/funcionario/{id}")
    public ResponseEntity<Funcionario> updatedFuncionario(@PathVariable Long id,
             @RequestBody Funcionario funcionarioDetails) {
        Funcionario f = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                      ("Id do funcionário não existe :" + id));
       f.setNome(funcionarioDetails.getNome());
       f.setIdade(funcionarioDetails.getIdade());
       f.setTelefone(funcionarioDetails.getTelefone());
       f.setSenha(funcionarioDetails.getSenha());
       f.setEmail(funcionarioDetails.getEmail());
        
        Funcionario updatedFuncionario = funcionarioRepository.save(f);
        return ResponseEntity.ok(updatedFuncionario);
	}
}

