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

public class CadastrarMotorista extends JFrame {

	private JPanel contentPane;
	private JTextField textBuscar;
	private JTextField textNomeMotorista;
	Motorista motorista;
	Motorista mo = new Motorista();
	MotoristaDAO dao = new MotoristaDAO();
	private JTextField textCpf;
	private JTextField textTelefone;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarMotorista frame = new CadastrarMotorista();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CadastrarMotorista() throws SQLException, Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeMotorista = new JLabel("Cadastro de Motoristas");
		lblCadastroDeMotorista.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblCadastroDeMotorista.setBounds(215, 40, 206, 24);
		contentPane.add(lblCadastroDeMotorista);
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblBuscar.setBounds(70, 97, 67, 24);
		contentPane.add(lblBuscar);
		
		textBuscar = new JTextField();
		textBuscar.setFont(new Font("SansSerif", Font.BOLD, 16));
		textBuscar.setBounds(147, 100, 250, 26);
		contentPane.add(textBuscar);
		textBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton();
		btnBuscar.setIcon(new ImageIcon(CadastrarCaminhao.class.getResource("/br/edu/ifcvideira/imgs/searchh.png")));
		btnBuscar.setBounds(407, 94, 43, 36);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					motorista = dao.buscarDadosMotorista(textBuscar.getText());
					textNomeMotorista.setText(motorista.getNomeMotorista());					
					textCpf.setText(motorista.getCpf());
					textTelefone.setText(motorista.getTelefone());
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		
		textNomeMotorista = new JTextField();
		textNomeMotorista.setFont(new Font("SansSerif", Font.BOLD, 16));
		textNomeMotorista.setColumns(10);
		textNomeMotorista.setBounds(130, 170, 250, 26);
		contentPane.add(textNomeMotorista);
		
		JLabel lblNomeMotorista = new JLabel("Nome:");
		lblNomeMotorista.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNomeMotorista.setBounds(50, 170, 67, 24);
		contentPane.add(lblNomeMotorista);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblCpf.setBounds(65, 230, 50, 24);
		contentPane.add(lblCpf);
		
		JLabel IconTruck = new JLabel("");
		IconTruck.setIcon(new ImageIcon(CadastrarMotorista.class.getResource("/br/edu/ifcvideira/imgs/driving-test1.png")));
		IconTruck.setBounds(138, 13, 67, 64);
		contentPane.add(IconTruck);
		
		textCpf = new JTextField();
		textCpf.setFont(new Font("SansSerif", Font.BOLD, 16));
		textCpf.setColumns(10);
		textCpf.setBounds(130, 230, 250, 26);
		contentPane.add(textCpf);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTelefone.setBounds(27, 290, 89, 24);
		contentPane.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setFont(new Font("SansSerif", Font.BOLD, 16));
		textTelefone.setColumns(10);
		textTelefone.setBounds(130, 290, 250, 26);
		contentPane.add(textTelefone);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dao.deletarMotorista(motorista);
					JOptionPane.showMessageDialog(null, "O Motorista Código: "+motorista.getIdMotorista()+"\n"
							+ "Nome: "+motorista.getNomeMotorista()+"\n"
									+ "CPF: "+motorista.getCpf()+"\n"
											+ "Telefone: "+motorista.getTelefone()+"\n"
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
		btnExcluir.setBounds(50, 409, 89, 36);
		contentPane.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mo = dao.buscarDadosMotorista(textBuscar.getText());
				} catch (SQLException e2) {
					e2.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				mo.setNomeMotorista(textNomeMotorista.getText());
				mo.setCpf(textCpf.getText());
				mo.setTelefone(textTelefone.getText());
				
				limpar();
				try {
					
					dao.alterarMotorista(mo);
					JOptionPane.showMessageDialog(null, "O Motorista Código: "+mo.getIdMotorista()+"\n"
							+ "Nome: "+motorista.getNomeMotorista()+"\n"
									+ "CPF: "+mo.getCpf()+"\n"
											+ "Telefone: "+mo.getTelefone()+"\n"
													+ "Foi Alterado com Sucesso!");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAlterar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnAlterar.setBackground(Color.YELLOW);
		btnAlterar.setBounds(200, 409, 111, 36);
		contentPane.add(btnAlterar);
		
		JButton btnConfirmar = new JButton("Cadastrar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mo.setNomeMotorista(textNomeMotorista.getText());
				mo.setCpf(textCpf.getText());
				mo.setTelefone(textTelefone.getText());
				
				limpar();
				
				try {
					dao.cadastrarMotorista(mo);
					JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConfirmar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnConfirmar.setBackground(Color.GREEN);
		btnConfirmar.setBounds(370, 409, 111, 36);
		contentPane.add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVoltar.setBounds(10, 11, 79, 27);
		contentPane.add(btnVoltar);
		
	}
	public void limpar() {
		textBuscar.setText(null);
		textNomeMotorista.setText(null);
		textCpf.setText(null);
		textTelefone.setText(null);
		
		try {
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
}
