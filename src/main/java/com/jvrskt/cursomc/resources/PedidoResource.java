package com.jvrskt.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jvrskt.cursomc.domain.Pedido;
import com.jvrskt.cursomc.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
 
	@Autowired
	public PedidoService service;
	
	@RequestMapping(value = "/{id}",  method = RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable  Integer id) {
		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
}
