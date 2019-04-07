package br.com.teste.model;

public class MensagemExecucao {

	private String host;
	private String database;
	private String comando;
	
	public MensagemExecucao() {
		super();
	}

	public MensagemExecucao(String mensagem) {
		super();
		this.host = mensagem;
	}
	
	public MensagemExecucao(String host, String database, String comando) {
		super();
		this.host = host;
		this.database = database;
		this.comando = comando;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String mensagem) {
		this.host = mensagem;
	}
	
	public String getDatabase() {
		return database;
	}

	public String getComando() {
		return comando;
	}

	@Override
	public String toString() {
		return "MensagemStatus [mensagem=" + host + "]";
	}

}
