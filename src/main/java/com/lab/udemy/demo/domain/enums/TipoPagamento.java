package com.lab.udemy.demo.domain.enums;

public enum TipoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int codigo;
	private String descricao; 
	
	private TipoPagamento(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoPagamento toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		
		for (TipoPagamento tipoPagamento : TipoPagamento.values()) {
			if (codigo.equals(tipoPagamento.getCodigo())) {
				return tipoPagamento;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
