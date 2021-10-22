package com.jvrskt.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jvrskt.cursomc.domain.Categoria;
import com.jvrskt.cursomc.repository.CategoriaRepository;
import com.jvrskt.cursomc.service.exceptions.DataIntegrityException;
import com.jvrskt.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	public CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> list = repo.findById(id);
			return list.orElseThrow(() -> new ObjectNotFoundException("Object not found. Id: " + id
					+ ", Type: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possivel deletar uma catagoria que possui produtos!");
		}
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
		
	}
}
