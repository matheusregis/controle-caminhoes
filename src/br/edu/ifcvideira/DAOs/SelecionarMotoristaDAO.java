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
import br.edu.ifcvideira.beans.NotaFiscal;
import br.edu.ifcvideira.utils.Conexao;

public class SelecionarMotoristaDAO{
	
	public void cadastrarNF(NotaFiscal nf) throws SQLException, Exception{
		try{
			java.sql.PreparedStatement sqlPrep = Conexao.conectar().prepareStatement("INSERT INTO notafiscal (nota, dataemissao, produto, quantidade, valorunitario) VALUES (?,?,?,?,?)");
			sqlPrep.setString(1, nf.getNumeroNotaFiscal());
			sqlPrep.setString(2, nf.getDataEmissaoNotaFiscal());
			sqlPrep.setString(3, nf.getProduto());
			sqlPrep.setInt(4, nf.getQuantidade());
			sqlPrep.setFloat(5, nf.getValorUnitario());
			
			sqlPrep.execute();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
}













