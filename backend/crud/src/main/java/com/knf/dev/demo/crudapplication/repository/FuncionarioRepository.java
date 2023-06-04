package com.knf.dev.demo.crudapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knf.dev.demo.crudapplication.entity.Funcionario;

public interface FuncionarioRepository  extends JpaRepository< Funcionario, Long>{

}
