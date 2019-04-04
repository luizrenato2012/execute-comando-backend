package br.com.teste.model;

public class MensagemStatus {

	private String mensagem;
	
	private String dataHora;
	
	public MensagemStatus() {
		super();
	}

	public MensagemStatus(String mensagem, String dataHora) {
		super();
		this.mensagem = mensagem;
		this.dataHora = dataHora;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public String toString() {
		return "MensagemStatus [mensagem=" + mensagem + ", dataHora=" + dataHora + "]";
	}
	
	
}
