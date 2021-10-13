package com.jvrskt.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jvrskt.cursomc.domain.Cidade;
import com.jvrskt.cursomc.service.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {
 
	@Autowired
	public CidadeService service;
	
	@RequestMapping(value = "/{id}",  method = RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable  Integer id) {
		Cidade obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
}
