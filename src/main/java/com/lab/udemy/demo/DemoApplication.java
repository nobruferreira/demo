package com.lab.udemy.demo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lab.udemy.demo.domain.Categoria;
import com.lab.udemy.demo.domain.Cidade;
import com.lab.udemy.demo.domain.Cliente;
import com.lab.udemy.demo.domain.Endereco;
import com.lab.udemy.demo.domain.Estado;
import com.lab.udemy.demo.domain.ItemPedido;
import com.lab.udemy.demo.domain.Pagamento;
import com.lab.udemy.demo.domain.PagamentoBoleto;
import com.lab.udemy.demo.domain.PagamentoCartao;
import com.lab.udemy.demo.domain.Pedido;
import com.lab.udemy.demo.domain.Produto;
import com.lab.udemy.demo.domain.enums.TipoCliente;
import com.lab.udemy.demo.domain.enums.TipoPagamento;
import com.lab.udemy.demo.repositories.CategoriaRepository;
import com.lab.udemy.demo.repositories.CidadeRepository;
import com.lab.udemy.demo.repositories.ClienteRepository;
import com.lab.udemy.demo.repositories.EnderecoRepository;
import com.lab.udemy.demo.repositories.EstadoRepository;
import com.lab.udemy.demo.repositories.ItemPedidoRepository;
import com.lab.udemy.demo.repositories.PagamentoRepository;
import com.lab.udemy.demo.repositories.PedidoRepository;
import com.lab.udemy.demo.repositories.ProdutoRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto prod1 = new Produto(null, "Computador", 2000.00);
		Produto prod2 = new Produto(null, "Impressora", 800.00);
		Produto prod3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");
		
		Cidade cidade1 = new Cidade(null, "Uberlândia", estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
		Cidade cidade3 = new Cidade(null, "Campinas", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
		Cliente cliente1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "44265815839", TipoCliente.PESSOAFISICA);
		cliente1.getTelefones().addAll(Arrays.asList("981092958", "981092959"));
		Endereco endereco1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "03477000", cliente1, cidade1);
		Endereco endereco2 = new Endereco(null, "Av. Matos", "105", "Sala 800", "Centro", "03477000", cliente1, cidade2);
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
		
		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Pedido pedido1 = new Pedido(null, sdf.parse("11/09/2018 09:00:00"), cliente1, endereco1);
		Pedido pedido2 = new Pedido(null, sdf.parse("11/09/2018 09:05:00"), cliente1, endereco2);
		
		Pagamento pgto1 = new PagamentoCartao(null, TipoPagamento.QUITADO, pedido1, 6);
		pedido1.setPagamento(pgto1);
		
		Pagamento pgto2 = new PagamentoBoleto(null, TipoPagamento.PENDENTE, pedido2, sdf.parse("20/09/2018 23:59:59"), null);
		pedido2.setPagamento(pgto2);
		
		cliente1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
		
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));
		
	    ItemPedido itemPedido1 = new ItemPedido(pedido1, prod1, 0.00, 1, 2000.00);
	    ItemPedido itemPedido2 = new ItemPedido(pedido1, prod3, 0.00, 2, 80.00);
	    ItemPedido itemPedido3 = new ItemPedido(pedido2, prod2, 100.00, 1, 800.00);
	    
	    pedido1.getItens().addAll(Arrays.asList(itemPedido1, itemPedido2));
	    pedido2.getItens().addAll(Arrays.asList(itemPedido3));
	    
	    prod1.getItens().addAll(Arrays.asList(itemPedido1));
	    prod2.getItens().addAll(Arrays.asList(itemPedido3));
	    prod3.getItens().addAll(Arrays.asList(itemPedido2));
	    
	    itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));
	}
}
