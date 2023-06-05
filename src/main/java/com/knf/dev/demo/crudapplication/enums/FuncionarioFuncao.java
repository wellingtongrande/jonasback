package com.knf.dev.demo.crudapplication.enums;


public enum FuncionarioFuncao {
	GERENTE (1),
	CHEFE_DE_COZINHA(2),
	AUXILIAR_DE_COZINHA(3),
	MOTOBOY(4),
	LIMPEZA(5);
	
	
		
	
	private int codigo;
	
	private FuncionarioFuncao(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public static FuncionarioFuncao valueOf( int codigo) {
		for(FuncionarioFuncao value: FuncionarioFuncao.values()) {
			if(value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de Funcionário inválido");
	}
}