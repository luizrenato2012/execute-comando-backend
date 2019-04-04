package br.com.teste.resource;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.model.MensagemOutput;
import br.com.teste.model.MensagemStatus;

@RestController
@RequestMapping("/websocket")
public class ComandoResource {
	
	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public MensagemOutput envia(MensagemStatus mensagem) {
		System.out.println("Enviando " + mensagem);
		SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		mensagem.setDataHora(fmt.format(new Date()));
		return new MensagemOutput(mensagem);
	}

}
