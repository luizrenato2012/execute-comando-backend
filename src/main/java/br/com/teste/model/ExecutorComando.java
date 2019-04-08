package br.com.teste.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ExecutorComando {

	private final String POSTGRE_CLASS="org.postgresql.Driver";
	private String URL="jdbc:postgresql://%s:5432/%s";
	private final String USER="teste";
	private final String PASSWORD="teste123";
	
	public String executa(String host, String database, String comando) {
		try (Connection conn = DriverManager.getConnection(String.format(URL, host,database ), USER, PASSWORD)) {
			Class.forName(POSTGRE_CLASS);
			comando = comando.trim().toUpperCase();
			if (comando.startsWith("SELECT")) {
				return executaSelect(comando, conn);
			} else {
				return executaUpdate(comando);
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Erro ao carregar driver " , e);
		} catch (SQLException e1) {
			throw new RuntimeException("Erro ao executar comando" , e1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private String executaSelect(String comandoSelect, Connection conn) {
		LinkedHashMap<String,Integer> colunas = null;
		int columnIndex=1;
		StringBuilder strb = new StringBuilder();
		strb.append("\n");
		try (PreparedStatement pst =conn.prepareStatement(comandoSelect);
				ResultSet rs = pst.executeQuery()){
			if (rs!=null ) {
				ResultSetMetaData rsmt = rs.getMetaData();
				colunas = (LinkedHashMap<String, Integer>) this.getColunas(rsmt);
				colunas.keySet().stream().
					forEach(nome -> strb.append(nome+"-"));
				strb.append("\n");
				while(rs.next()) {
					strb.append(rs.getObject(columnIndex) +" - ");
					columnIndex++;
				}
				System.out.println(strb);
				return strb.toString();
			}
			return "";
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Map<String, Integer> getColunas(ResultSetMetaData rsmt) {
		Map<String,Integer> map = new LinkedHashMap<String, Integer>();
		try {
			for(int coluna=1; coluna < rsmt.getColumnCount(); coluna++) {
				map.put(rsmt.getColumnName(coluna), rsmt.getColumnType(coluna));
			}
			return map;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao obter colunas " , e);
		}
	}
	
	private String executaUpdate(String comandoUpdate) {
		return "Nao implementado";
	}
	
}
