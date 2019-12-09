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
import br.edu.ifcvideira.beans.Motorista;
import br.edu.ifcvideira.utils.Conexao;



public class MotoristaDAO{
	
	public void cadastrarMotorista(Motorista motorista) throws SQLException, Exception{
		try{
			java.sql.PreparedStatement sqlPrep = Conexao.conectar().prepareStatement("INSERT INTO motorista (nome, telefone, cpf) VALUES (?,?,?)");
			sqlPrep.setString(1, motorista.getNomeMotorista());
			sqlPrep.setString(2, motorista.getTelefone());
			sqlPrep.setString(3, motorista.getCpf());
			
			sqlPrep.execute();
			int idMotorista = 1;
			motorista.setIdMotorista(idMotorista++);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}

	public void alterarMotorista(Motorista motorista) throws Exception {
		try{
			PreparedStatement sqlPrep = Conexao.conectar().prepareStatement("UPDATE motorista SET nome=?, telefone=?, cpf=? WHERE idmotorista=?");
			sqlPrep.setString(1, motorista.getNomeMotorista());
			sqlPrep.setString(2, motorista.getTelefone());
			sqlPrep.setString(3, motorista.getCpf());
			sqlPrep.setInt(4, motorista.getIdMotorista());
			sqlPrep.execute();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void deletarMotorista(Motorista motorista) throws Exception{
		try{
			PreparedStatement sqlPrep = (PreparedStatement) Conexao.conectar().prepareStatement("DELETE FROM motorista WHERE idmotorista=?");
			sqlPrep.setInt(1, motorista.getIdMotorista());
			sqlPrep.execute();
			
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public Motorista buscarDadosMotorista(String nome) throws SQLException, Exception{
		Motorista motorista = null;
		try {
			PreparedStatement sqlPrep = (PreparedStatement) Conexao.conectar().prepareStatement("SELECT * FROM motorista WHERE nome = ?");
			sqlPrep.setString(1, nome);
			
			ResultSet rs = sqlPrep.executeQuery();
			
			if(rs.next()){
				motorista = new Motorista(rs.getInt("idmotorista"), rs.getString("nome"), rs.getString("telefone"), rs.getString("cpf"));
					
			}	
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return motorista;
			
	}
	
}













