package br.edu.ifcvideira.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {	
		//conexão MySQL
		public static Connection conectar() throws Exception {
			try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3307/controleaparas?user=root&password=&useSSL=false");
					return conexao;
			}catch(ClassNotFoundException | SQLException e){
	            throw new Exception(e.getMessage());
	        }
	}
		
}

	