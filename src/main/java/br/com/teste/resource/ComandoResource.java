package br.com.teste.resource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import br.com.teste.model.MensagemExecucao;
import br.com.teste.model.MensagemRetorno;

@Controller
public class ComandoResource {
	
	
	@MessageMapping("/executa") // endereco de envio dos clientes /app/executa
	@SendTo("/topic/respostas")  //fila de mensagens  que os client´s se inscrevem (subscript)
	public MensagemRetorno envia(MensagemExecucao mensagem) { // menssagem recebidas dos client´s
		System.out.println("Enviando " + mensagem);
//		try {
//			Thread.sleep(1 * 1_000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		StringBuilder strb = new StringBuilder();
		strb.append("[Retorno] - executado: ")
			.append(mensagem.getHost()+" - ")
			.append(mensagem.getDatabase() + " - ");
		return new MensagemRetorno(strb.toString(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
	}

}
