package br.com.teste.model;

public class MensagemExecucao {

	private String host;
	private String database;
	private String comando;
	
	public MensagemExecucao() {
		super();
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
	
	public void setDatabase(String database) {
		this.database = database;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}

	@Override
	public String toString() {
		return "MensagemExecucao [host=" + host + ", database=" + database + ", comando=" + comando + "]";
	}
	
	

	
}
