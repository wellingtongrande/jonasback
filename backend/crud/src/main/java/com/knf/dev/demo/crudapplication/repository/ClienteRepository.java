package com.knf.dev.demo.crudapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knf.dev.demo.crudapplication.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
