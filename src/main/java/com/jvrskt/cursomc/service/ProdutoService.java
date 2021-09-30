package com.jvrskt.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvrskt.cursomc.domain.Produto;
import com.jvrskt.cursomc.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	public ProdutoRepository repo;
	
	public Produto find(Integer id) {
		Optional<Produto> list = repo.findById(id);
		return list.orElse(null);
	}
}
