package br.com.teste.model;

public class MensagemRetorno {
	
	private String mensagem;
	private String dataHora;

	public MensagemRetorno(String mensagem, String dataHora) {
		super();
		this.mensagem = mensagem;
		this.dataHora = dataHora;
	}


	public MensagemRetorno() {
		super();
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
		return "MensagemRetorno [mensagem=" + mensagem + ", dataHora=" + dataHora + "]";
	}
	
}
