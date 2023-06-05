package com.knf.dev.demo.crudapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knf.dev.demo.crudapplication.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
