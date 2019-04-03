package br.com.teste.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.com.teste.model.ConfiguracaoBanco;
import br.com.teste.model.TipoConfiguracao;


@Service
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ConfiguracaoService {

	private List<ConfiguracaoBanco> lista;
	
	@PostConstruct
	private void init() {
		System.out.println("Iniciando ConfiguracaoService");
		lista = new ArrayList<>();
		lista.add(new ConfiguracaoBanco(TipoConfiguracao.LOJA_ZIM, "http://localhot:5432", "teste", "teste123","pedido"));
		lista.add(new ConfiguracaoBanco(TipoConfiguracao.LOJA_ZIM, "http://localhot:5432", "teste", "teste123","rendimento"));
	}
	
	public List<ConfiguracaoBanco> getLista() {
		return this.lista;
	}
}
