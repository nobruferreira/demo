package com.lab.udemy.demo.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lab.udemy.demo.domain.enums.TipoPagamento;

@Entity
public class PagamentoBoleto extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	private Date dataVencimento;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	private Date dataPagamento;
	
	public PagamentoBoleto() {
		
	}

	public PagamentoBoleto(Integer id, TipoPagamento tipoPagamento, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, tipoPagamento, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;		
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
}
