package com.jvrskt.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jvrskt.cursomc.domain.Cliente;
import com.jvrskt.cursomc.dto.ClienteDTO;
import com.jvrskt.cursomc.repository.ClienteRepository;
import com.jvrskt.cursomc.service.exceptions.DataIntegrityException;
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
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	//Metodo para atualizar os dados que estão na memoria com os parametros do ClienteDTO
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possvel deletar um cliente que possui produtos");
		}
	}
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDTO) {
		return new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null);
	}
}
