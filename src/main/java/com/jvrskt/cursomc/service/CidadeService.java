package com.jvrskt.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvrskt.cursomc.domain.Categoria;
import com.jvrskt.cursomc.domain.Cidade;
import com.jvrskt.cursomc.repository.CidadeRepository;
import com.jvrskt.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	
	@Autowired
	public CidadeRepository repo;
	
	public Cidade find(Integer id) {
		Optional<Cidade> list = repo.findById(id);
			return list.orElseThrow(() -> new ObjectNotFoundException("Object not found. Id: " + id
					+ ", Type: " + Categoria.class.getName()));
	}
}
