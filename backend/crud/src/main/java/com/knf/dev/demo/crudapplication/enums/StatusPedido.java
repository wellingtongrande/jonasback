package com.knf.dev.demo.crudapplication.enums;


public enum StatusPedido {

	PAGO(1),
	AGUARDANDO_PAGAMENTO(2),
	ENTREGUE(3),
	CANCELADO(4);
	
	
		
	
	private int numero;
	
	private StatusPedido(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public static StatusPedido valueOf( int numero) {
		for(StatusPedido value: StatusPedido.values()) {
			if(value.getNumero() == numero) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de Status do pedido inválido");
	}
}


