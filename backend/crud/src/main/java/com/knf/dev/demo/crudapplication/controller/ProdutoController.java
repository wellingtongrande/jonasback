package com.knf.dev.demo.crudapplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.knf.dev.demo.crudapplication.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.knf.dev.demo.crudapplication.entity.Produto;
import com.knf.dev.demo.crudapplication.exception.ResourceNotFoundException;
import com.knf.dev.demo.crudapplication.repository.ProdutoRepository;

@CrossOrigin(origins = "http://localhost:4200/api/v1")
@RestController
@RequestMapping("/api/v1")
public class ProdutoController {

	@Autowired
    private ProdutoRepository produtoRepository;

//	@GetMapping("/produto")
//	public ResponseEntity<List<Produto>> findAll() {
//		List<Produto> list = produtoRepository.findAll();
//		return ResponseEntity.ok().body(list);
//	}

	@GetMapping("/produto")
	public Page<Produto> findAllPagination(
			@RequestParam(value = "page", defaultValue = "0") Integer pagina,
			@RequestParam(value = "size", defaultValue = "5") Integer tamanhoPagina) {
		PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina);
		return produtoRepository.findAll(pageRequest);
	}

	 @GetMapping("/produto/{id}")
	    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
	        Produto p = produtoRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException
	                      ("Id  do produto não existe :" + id));
	        return ResponseEntity.ok(p);
	}

	@PostMapping("/produto")
	public Produto createProduto(@RequestBody Produto p) {

		return produtoRepository.save(p);
	}
	@DeleteMapping("/produto/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCliente
			(@PathVariable Long id) {
		Produto p = produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException
						("Id do cuncionário não existe :" + id));
		produtoRepository.delete(p);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deletado", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
