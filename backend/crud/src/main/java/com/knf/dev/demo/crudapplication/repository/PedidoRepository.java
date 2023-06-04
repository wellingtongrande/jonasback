package com.knf.dev.demo.crudapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knf.dev.demo.crudapplication.entity.Pedido;

public interface PedidoRepository  extends JpaRepository<Pedido, Long>{

}
