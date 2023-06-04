package com.knf.dev.demo.crudapplication.entity;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name ="tb_categoria")
public class Categoria {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String tipo;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "categorias")
	private Set<Produto> produtos = new HashSet<>();
	
	public Categoria() {
		
	}


	public Categoria(Long id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	public Set<Produto> getProdutos() {
		return produtos;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
