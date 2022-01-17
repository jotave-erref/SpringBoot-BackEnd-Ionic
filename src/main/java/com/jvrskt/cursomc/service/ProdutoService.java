package com.jvrskt.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jvrskt.cursomc.domain.Categoria;
import com.jvrskt.cursomc.domain.Produto;
import com.jvrskt.cursomc.repository.CategoriaRepository;
import com.jvrskt.cursomc.repository.ProdutoRepository;
import com.jvrskt.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	public ProdutoRepository repo;
	
	@Autowired
	public CategoriaRepository catRepo;
	
	public Produto find(Integer id) {
		Optional<Produto> list = repo.findById(id);
			return list.orElseThrow(() -> new ObjectNotFoundException("Object not found. Id: " + id
					+ ", Type: " + Produto.class.getName()));
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = catRepo.findAllById(ids);
		return repo.search(nome, categorias, pageRequest);
	} 
}
