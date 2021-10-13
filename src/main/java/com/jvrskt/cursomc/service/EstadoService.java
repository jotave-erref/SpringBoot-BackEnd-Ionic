package com.jvrskt.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvrskt.cursomc.domain.Categoria;
import com.jvrskt.cursomc.domain.Estado;
import com.jvrskt.cursomc.repository.EstadoRepository;
import com.jvrskt.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {
	
	@Autowired
	public EstadoRepository repo;
	
	public Estado find(Integer id) {
		Optional<Estado> list = repo.findById(id);
			return list.orElseThrow(() -> new ObjectNotFoundException("Object not found. Id: " + id
					+ ", Type: " + Categoria.class.getName()));
	}
}
