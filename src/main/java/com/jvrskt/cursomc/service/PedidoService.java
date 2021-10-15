package com.jvrskt.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvrskt.cursomc.domain.Pedido;
import com.jvrskt.cursomc.repository.PedidoRepository;
import com.jvrskt.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	public PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> list = repo.findById(id);
			return list.orElseThrow(() -> new ObjectNotFoundException("Object not found. Id: " + id
					+ ", Type: " + Pedido.class.getName()));
	}
}
