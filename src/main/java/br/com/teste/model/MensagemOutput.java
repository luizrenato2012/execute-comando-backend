package br.com.teste.model;

public class MensagemOutput {
	
	private MensagemStatus mensagemStatus;

	public MensagemStatus getMensagemStatus() {
		return mensagemStatus;
	}

	public void setMensagemStatus(MensagemStatus mensagemStatus) {
		this.mensagemStatus = mensagemStatus;
	}

	public MensagemOutput() {
		super();
	}

	public MensagemOutput(MensagemStatus mensagemStatus) {
		super();
		this.mensagemStatus = mensagemStatus;
	}

}
