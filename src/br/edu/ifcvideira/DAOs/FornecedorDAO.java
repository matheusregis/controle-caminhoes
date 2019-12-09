package br.edu.ifcvideira.DAOs;

import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import br.edu.ifcvideira.controllers.views.*;

import br.edu.ifcvideira.beans.Caminhao;
import br.edu.ifcvideira.beans.Fornecedor;
import br.edu.ifcvideira.beans.Motorista;
import br.edu.ifcvideira.utils.Conexao;



public class FornecedorDAO{
	
	public void cadastrarFornecedor(Fornecedor fornecedor) throws SQLException, Exception{
		try{
			java.sql.PreparedStatement sqlPrep = Conexao.conectar().prepareStatement("INSERT INTO fornecedor (nome, cidade, estado) VALUES (?,?,?)");
			sqlPrep.setString(1, fornecedor.getNomeFornecedor());
			sqlPrep.setString(2, fornecedor.getCidade());
			sqlPrep.setString(3, fornecedor.getEstado());
			
			sqlPrep.execute();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}

	public void alterarFornecedor(Fornecedor fornecedor) throws Exception {
		try{
			PreparedStatement sqlPrep = Conexao.conectar().prepareStatement("UPDATE fornecedor SET nome=?, cidade=?, estado=? WHERE idfornecedor=?");
			sqlPrep.setString(1, fornecedor.getNomeFornecedor());
			sqlPrep.setString(2, fornecedor.getCidade());
			sqlPrep.setString(3, fornecedor.getEstado());
			sqlPrep.setInt(4, fornecedor.getIdFornecedor());
			sqlPrep.execute();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void deletarFornecedor(Fornecedor fornecedor) throws Exception{
		try{
			PreparedStatement sqlPrep = (PreparedStatement) Conexao.conectar().prepareStatement("DELETE FROM fornecedor WHERE idfornecedor=?");
			sqlPrep.setInt(1, fornecedor.getIdFornecedor());
			sqlPrep.execute();
			
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public Fornecedor buscarDadosFornecedor(String nome) throws SQLException, Exception{
		Fornecedor fornecedor = null;
		try {
			PreparedStatement sqlPrep = (PreparedStatement) Conexao.conectar().prepareStatement("SELECT * FROM fornecedor WHERE nome = ?");
			sqlPrep.setString(1, nome);
			
			ResultSet rs = sqlPrep.executeQuery();
			
			if(rs.next()){
				fornecedor = new Fornecedor(rs.getInt("idfornecedor"), rs.getString("nome"), rs.getString("cidade"), rs.getString("estado"));
					
			}	
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return fornecedor;
			
	}
	
}













