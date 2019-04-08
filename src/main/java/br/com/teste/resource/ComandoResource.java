package br.com.teste.resource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import br.com.teste.model.ExecutorComando;
import br.com.teste.model.MensagemExecucao;
import br.com.teste.model.MensagemRetorno;

@Controller
public class ComandoResource {
	
	@Autowired
	private ExecutorComando executor;
	
	@MessageMapping("/executa") // endereco de envio dos clientes /app/executa
	@SendTo("/topic/respostas")  //fila de mensagens  que os client´s se inscrevem (subscript)
	public MensagemRetorno onRecebimento(MensagemExecucao mensagem) { // menssagem recebidas dos client´s
		System.out.println("Recebendo " + mensagem);
		String msg = "";
		String res = "";
		try {
			res = executor.executa(mensagem.getHost(), mensagem.getDatabase(), mensagem.getComando());
			msg=" executado: " + mensagem.getComando() + " em " + mensagem.getHost() +" - "
					+ mensagem.getDatabase()+"\n";
			msg+=res;
		} catch(Exception e ) {
			e.printStackTrace();
			msg="Erro ao executar " + mensagem.getComando() + " em " + mensagem.getHost() +" - "
					+ mensagem.getDatabase() + " : " +e.getMessage();
		}
		return new MensagemRetorno(msg, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
	}

}
