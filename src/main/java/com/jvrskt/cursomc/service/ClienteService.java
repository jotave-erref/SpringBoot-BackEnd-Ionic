package com.jvrskt.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvrskt.cursomc.domain.Cliente;
import com.jvrskt.cursomc.repository.ClienteRepository;
import com.jvrskt.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	public ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> list = repo.findById(id);
			return list.orElseThrow(() -> new ObjectNotFoundException("Object not found. Id: " + id
					+ ", Type: " + Cliente.class.getName()));
	}
}
