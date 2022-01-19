package com.jvrskt.cursomc.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvrskt.cursomc.domain.ItemPedido;
import com.jvrskt.cursomc.domain.PagamentoBoleto;
import com.jvrskt.cursomc.domain.Pedido;
import com.jvrskt.cursomc.domain.enums.EstadoPagamento;
import com.jvrskt.cursomc.repository.ItemPedidoRepository;
import com.jvrskt.cursomc.repository.PagamentoRepository;
import com.jvrskt.cursomc.repository.PedidoRepository;
import com.jvrskt.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	public PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepo;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> list = repo.findById(id);
			return list.orElseThrow(() -> new ObjectNotFoundException("Object not found. Id: " + id
					+ ", Type: " + Pedido.class.getName()));
	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if(obj.getPagamento() instanceof PagamentoBoleto) {
			PagamentoBoleto pgto = (PagamentoBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pgto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepo.save(obj.getPagamento());
		for(ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepo.saveAll(obj.getItens());
		return obj;
		 
	}
	
}
