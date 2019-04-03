package br.com.teste.model;

public enum TipoConfiguracao {
	
	LOJA_ZIM("Loja Zim"),LOJA_JAP("Loja ZAP");
	private String descricao;

	private TipoConfiguracao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
