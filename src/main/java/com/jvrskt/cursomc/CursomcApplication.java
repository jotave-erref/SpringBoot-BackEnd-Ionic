package com.jvrskt.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jvrskt.cursomc.domain.Categoria;
import com.jvrskt.cursomc.domain.Cidade;
import com.jvrskt.cursomc.domain.Cliente;
import com.jvrskt.cursomc.domain.Endereco;
import com.jvrskt.cursomc.domain.Estado;
import com.jvrskt.cursomc.domain.ItemPedido;
import com.jvrskt.cursomc.domain.Pagamento;
import com.jvrskt.cursomc.domain.PagamentoBoleto;
import com.jvrskt.cursomc.domain.PagamentoCartao;
import com.jvrskt.cursomc.domain.Pedido;
import com.jvrskt.cursomc.domain.Produto;
import com.jvrskt.cursomc.domain.enums.EstadoPagamento;
import com.jvrskt.cursomc.domain.enums.TipoCliente;
import com.jvrskt.cursomc.repository.CategoriaRepository;
import com.jvrskt.cursomc.repository.CidadeRepository;
import com.jvrskt.cursomc.repository.ClienteRepository;
import com.jvrskt.cursomc.repository.EnderecoRepository;
import com.jvrskt.cursomc.repository.EstadoRepository;
import com.jvrskt.cursomc.repository.ItemPedidoRepository;
import com.jvrskt.cursomc.repository.PagamentoRepository;
import com.jvrskt.cursomc.repository.PedidoRepository;
import com.jvrskt.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{


	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
