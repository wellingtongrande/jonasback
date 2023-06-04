package com.knf.dev.demo.crudapplication.entity;

import java.util.Objects;

import com.knf.dev.demo.crudapplication.enums.FuncionarioFuncao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "tb_nome")
	private String nome;
	@Column(name = "tb_idade")
	private Integer idade;
	@Column(name = "tb_telefone")
	private String telefone;
	@Column(name = "tb_senha")
	private String senha;
	@Column(name = "tb_email")
	private String email;
	
	private Integer funcionarioFuncao;
	
	public Funcionario() {
		
	}


	public Funcionario(Long id, String nome, Integer idade, String telefone, String senha, String email, FuncionarioFuncao funcionarioFuncao) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.telefone = telefone;
		this.senha = senha;
		this.email = email;
		setFuncionarioFuncao(funcionarioFuncao);
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getIdade() {
		return idade;
	}


	public void setIdade(Integer idade) {
		this.idade = idade;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public FuncionarioFuncao getFuncionarioFuncao() {
		return FuncionarioFuncao.valueOf(funcionarioFuncao);
	}

	public void setFuncionarioFuncao(FuncionarioFuncao funcionarioFuncao) {
		if (funcionarioFuncao != null) {
			this.funcionarioFuncao = funcionarioFuncao.getCodigo();

		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}
	
	
}

