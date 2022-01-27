package com.jvrskt.cursomc.service;

import org.springframework.mail.SimpleMailMessage;

import com.jvrskt.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	void sendEmail(SimpleMailMessage msg);

}