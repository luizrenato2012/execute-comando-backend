package br.com.teste.model;

public class ConfiguracaoBanco {
	
	private TipoConfiguracao tipo;
	private String ipServidor;
	private String user;
	private String password;
	private String banco;
	
	public ConfiguracaoBanco(TipoConfiguracao tipo, String url, String user, String password, String banco) {
		super();
		this.tipo = tipo;
		this.ipServidor = url;
		this.user = user;
		this.password = password;
		this.banco = banco;
	}

	public TipoConfiguracao getTipo() {
		return tipo;
	}

	public String getIpServidor() {
		return ipServidor;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getUrl() {
//		jdbc:postgresql://<database_host>:<port>/<database_name>
		return "jdbc:postgresql://" + ipServidor + ":5432/" + banco;
	}

	@Override
	public String toString() {
		return "ConfiguracaoBanco [tipo=" + tipo + ", ipServidor=" + ipServidor + ", user=" + user + ", password="
				+ password + ", banco=" + banco + "]";
	}
	
}
