package br.edu.ifcvideira.controllers.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifcvideira.beans.*;
import br.edu.ifcvideira.controllers.views.*;
import br.edu.ifcvideira.DAOs.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class CadastrarFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField textBuscar;
	private JTextField textFornecedor;
	Fornecedor fo = new Fornecedor();
	FornecedorDAO dao = new FornecedorDAO();
	private JTextField textCidade;
	private JTextField textEstado;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarFornecedor frame = new CadastrarFornecedor();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CadastrarFornecedor() throws SQLException, Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel iconFornecedor = new JLabel("");
		iconFornecedor.setIcon(new ImageIcon(CadastrarFornecedor.class.getResource("/br/edu/ifcvideira/imgs/businessman32x32.png")));
		iconFornecedor.setBounds(130, 11, 67, 64);
		contentPane.add(iconFornecedor);
		
		JLabel lblCadastroDeFornecedores = new JLabel("Cadastro de Fornecedores");
		lblCadastroDeFornecedores.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblCadastroDeFornecedores.setBounds(215, 40, 236, 24);
		contentPane.add(lblCadastroDeFornecedores);
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblBuscar.setBounds(70, 97, 67, 24);
		contentPane.add(lblBuscar);
		
		textBuscar = new JTextField();
		textBuscar.setFont(new Font("SansSerif", Font.BOLD, 16));
		textBuscar.setBounds(147, 100, 250, 26);
		contentPane.add(textBuscar);
		textBuscar.setColumns(10);
		
		textCidade = new JTextField();
		textCidade.setFont(new Font("SansSerif", Font.BOLD, 16));
		textCidade.setColumns(10);
		textCidade.setBounds(128, 230, 250, 26);
		contentPane.add(textCidade);
		
		textEstado = new JTextField();
		textEstado.setFont(new Font("SansSerif", Font.BOLD, 16));
		textEstado.setColumns(10);
		textEstado.setBounds(130, 290, 35, 26);
		contentPane.add(textEstado);
		
		JButton btnBuscar = new JButton();
		btnBuscar.setIcon(new ImageIcon(CadastrarFornecedor.class.getResource("/br/edu/ifcvideira/imgs/searchh.png")));
		btnBuscar.setBounds(407, 94, 43, 36);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					fo = dao.buscarDadosFornecedor(textBuscar.getText());
					textFornecedor.setText(fo.getNomeFornecedor());					
					textCidade.setText(fo.getCidade());
					textEstado.setText(fo.getEstado());
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		
		textFornecedor = new JTextField();
		textFornecedor.setFont(new Font("SansSerif", Font.BOLD, 16));
		textFornecedor.setColumns(10);
		textFornecedor.setBounds(180, 170, 250, 26);
		contentPane.add(textFornecedor);
		
		JLabel lblNomeFornecedor = new JLabel("Fornecedor:");
		lblNomeFornecedor.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNomeFornecedor.setBounds(48, 170, 105, 24);
		contentPane.add(lblNomeFornecedor);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblCidade.setBounds(48, 230, 70, 24);
		contentPane.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblEstado.setBounds(48, 290, 67, 24);
		contentPane.add(lblEstado);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dao.deletarFornecedor(fo);
					JOptionPane.showMessageDialog(null, "O Caminhão Código: "+fo.getIdFornecedor()+"\n"
							+ "Fornecedor: "+fo.getNomeFornecedor()+"\n"
									+ "Cidade: "+fo.getCidade()+"\n"
											+ "Estado: "+fo.getEstado()+"\n"
													+ "Foi Excluído com Sucesso!");
					limpar();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBackground(Color.RED);
		btnExcluir.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnExcluir.setBounds(50, 359, 89, 36);
		contentPane.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fo= dao.buscarDadosFornecedor(textBuscar.getText());
				} catch (SQLException e2) {
					e2.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				fo.setNomeFornecedor(textFornecedor.getText());
				fo.setCidade(textCidade.getText());
				fo.setEstado(textEstado.getText());
					
					limpar();
					try {
						
						dao.alterarFornecedor(fo);
						JOptionPane.showMessageDialog(null, "O Caminhão Código: "+fo.getIdFornecedor()+"\n"
								+ "Fornecedor: "+fo.getNomeFornecedor()+"\n"
										+ "Cidade: "+fo.getCidade()+"\n"
												+ "Estado: "+fo.getEstado()+"\n"
														+ "Foi Alterado com Sucesso!");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnAlterar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnAlterar.setBackground(Color.YELLOW);
		btnAlterar.setBounds(200, 359, 111, 36);
		contentPane.add(btnAlterar);
		
		JButton btnConfirmar = new JButton("Cadastrar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fo.setNomeFornecedor(textFornecedor.getText());
				fo.setCidade(textCidade.getText());
				fo.setEstado(textEstado.getText());
				
					limpar();
					
					try {
						dao.cadastrarFornecedor(fo);
						JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnConfirmar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnConfirmar.setBackground(Color.GREEN);
		btnConfirmar.setBounds(370, 359, 111, 36);
		contentPane.add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVoltar.setBounds(10, 11, 79, 27);
		contentPane.add(btnVoltar);
		


	}
	public void limpar() {
		textBuscar.setText(null);
		textFornecedor.setText(null);
		textCidade.setText(null);
		textEstado.setText(null);
		
		try {
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
		
}
