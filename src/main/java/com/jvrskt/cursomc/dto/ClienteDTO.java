package com.jvrskt.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.jvrskt.cursomc.domain.Cliente;

public class ClienteDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatorio!")
	@Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 120 caracteres")
	public String nome;
	
	@NotEmpty(message = "Preenchimento obrigatorio!")
	@Email(message = "Email inválido")
	public String email;
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
