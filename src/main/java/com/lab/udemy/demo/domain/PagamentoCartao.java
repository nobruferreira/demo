package com.lab.udemy.demo.domain;

import javax.persistence.Entity;

import com.lab.udemy.demo.domain.enums.TipoPagamento;

@Entity
public class PagamentoCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numeroParcelas;
	
	public PagamentoCartao() {
		
	}

	public PagamentoCartao(Integer id, TipoPagamento tipoPagamento, Pedido pedido, Integer numeroParcelas) {
		super(id, tipoPagamento, pedido);
		this.numeroParcelas = numeroParcelas;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
}
