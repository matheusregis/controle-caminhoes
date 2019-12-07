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
import br.edu.ifcvideira.utils.Conexao;



public class CaminhoesDAO{
	
	public void cadastrarCaminhao(Caminhao caminhao) throws SQLException, Exception{
		try{
			java.sql.PreparedStatement sqlPrep = Conexao.conectar().prepareStatement("INSERT INTO caminhao (placa, idtipocaminhao, idmodulo) VALUES (?,?,?)");
			sqlPrep.setString(1, caminhao.getPlaca());
			sqlPrep.setInt(2, caminhao.getTipoCaminhao());
			sqlPrep.setInt(3, caminhao.getModuloCaminhao());
			
			sqlPrep.execute();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}

	public void alterarCaminhao(Caminhao caminhao) throws Exception {
		try{
			String sql = "UPDATE caminhao SET placa=?, idtipocaminhao=?, idmodulo=? WHERE codigo=?";
			PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
			int contador = 1;
			sqlPrep.setString(contador++, caminhao.getPlaca());
			sqlPrep.setInt(contador++, caminhao.getTipoCaminhao());
			sqlPrep.setInt(contador++, caminhao.getModuloCaminhao());
			sqlPrep.setInt(contador++, caminhao.getCodigo());
			sqlPrep.execute();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void deletarCaminhao(Caminhao caminhao) throws Exception{
		try{
			PreparedStatement sqlPrep = (PreparedStatement) Conexao.conectar().prepareStatement("DELETE FROM caminhao WHERE idcaminhao=?");
			sqlPrep.setInt(1, caminhao.getCodigo());
			sqlPrep.execute();
			
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public Caminhao buscarPlacaCaminhao(String placa) throws SQLException, Exception{
		Caminhao caminhao = null;
		try {
			PreparedStatement sqlPrep = (PreparedStatement) Conexao.conectar().prepareStatement("CALL `controleaparas`.`sp_buscarPlaca` (?)");
			sqlPrep.setString(1, placa);
			
			ResultSet rs = sqlPrep.executeQuery();
			
			if(rs.next()){
				caminhao = new Caminhao(rs.getInt("idcaminhao"), rs.getString("placa"), rs.getInt("idtipocaminhao"), rs.getInt("idmodulo"));
					
			}	
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return caminhao;
			
	}
	public List<String> buscaTipoCaminhao() throws SQLException, Exception{
		List<String> tipoCaminhao = new ArrayList<String>();
		try {
			String sql = "SELECT * FROM tipocaminhao";
			java.sql.Statement state = Conexao.conectar().createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next()) {
				String linha = (rs.getString("nome"));
				tipoCaminhao.add(linha);
			}
			state.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return tipoCaminhao;
	}
	
	public List<String> buscaModuloCaminhao() throws SQLException, Exception{
		List<String> moduloCaminhao = new ArrayList<String>();
		try {
			String sql = "SELECT * FROM modulo";
			java.sql.Statement state = Conexao.conectar().createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next()) {
				String linha = (rs.getString("nome"));
				moduloCaminhao.add(linha);
			}
			state.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return moduloCaminhao;
	}
	
	public List<Object> buscarCaminhao() throws SQLException, Exception{
		List<Object> caminhao = new ArrayList<Object>();
		try {
			String sql = "SELECT * FROM caminhao";
			java.sql.Statement state = Conexao.conectar().createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next())
			{
				Object[] linha = {rs.getString(1), rs.getString(2), rs.getString(3)};
				caminhao.add(linha);
			}
			state.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return caminhao;
	}
	
}













