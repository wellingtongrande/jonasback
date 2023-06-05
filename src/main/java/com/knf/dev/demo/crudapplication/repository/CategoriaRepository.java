package com.knf.dev.demo.crudapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knf.dev.demo.crudapplication.entity.Categoria;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{

}
