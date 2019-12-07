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

public class CadastrarCaminhao extends JFrame {

	private JPanel contentPane;
	private JTextField textBuscar;
	private JTextField textPlaca;
	
	JComboBox cbModulo = new JComboBox();
	JComboBox cbTipo = new JComboBox();
	Caminhao caminhao;
	Caminhao ca = new Caminhao();
	CaminhoesDAO dao = new CaminhoesDAO();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCaminhao frame = new CadastrarCaminhao();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CadastrarCaminhao() throws SQLException, Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel iconCaminhao = new JLabel("");
		iconCaminhao.setIcon(new ImageIcon(CadastrarCaminhao.class.getResource("/br/edu/ifcvideira/imgs/truckPluss.png")));
		iconCaminhao.setBounds(115, 26, 100, 49);
		contentPane.add(iconCaminhao);
		
		JLabel lblCadastroDeCaminhes = new JLabel("Cadastro de Caminh\u00F5es");
		lblCadastroDeCaminhes.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblCadastroDeCaminhes.setBounds(215, 40, 206, 24);
		contentPane.add(lblCadastroDeCaminhes);
		
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
					
					caminhao = dao.buscarPlacaCaminhao(textBuscar.getText());
					textPlaca.setText(caminhao.getPlaca());
					cbTipo.setSelectedIndex(caminhao.getTipoCaminhao());
					cbModulo.setSelectedIndex(caminhao.getModuloCaminhao());
					
					
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		
		textPlaca = new JTextField();
		textPlaca.setFont(new Font("SansSerif", Font.BOLD, 16));
		textPlaca.setColumns(10);
		textPlaca.setBounds(130, 170, 250, 26);
		contentPane.add(textPlaca);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPlaca.setBounds(48, 170, 67, 24);
		contentPane.add(lblPlaca);
		
		JLabel lblMdulo = new JLabel("M\u00F3dulo:");
		lblMdulo.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblMdulo.setBounds(48, 230, 70, 24);
		contentPane.add(lblMdulo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTipo.setBounds(48, 290, 67, 24);
		contentPane.add(lblTipo);
		
		//cria comboBox Modulo e popula com dados da tabela modulo - coluna nome
		
		cbModulo.setFont(new Font("SansSerif", Font.BOLD, 16));
		cbModulo.setBounds(130, 230, 200, 26);
		contentPane.add(cbModulo);
		
		CaminhoesDAO modulo = new CaminhoesDAO();
		List<String> listaModulo = modulo.buscaModuloCaminhao();
		cbModulo.addItem("Selecione uma Opção");
		for(int i = 0; i < listaModulo.size(); i++) {
			cbModulo.addItem(listaModulo.get(i));
		}
		
		//cria comboBox Tipo e popula com dados da tabela tipocaminhao - coluna nome
		
		cbTipo.setFont(new Font("SansSerif", Font.BOLD, 16));
		cbTipo.setBounds(130, 290, 200, 26);
		contentPane.add(cbTipo);
				
		CaminhoesDAO tipo = new CaminhoesDAO();
		List<String> listaTipo = tipo.buscaTipoCaminhao();
		cbTipo.addItem("Selecione uma Opção");
		for(int i = 0; i < listaTipo.size(); i++) {
			cbTipo.addItem(listaTipo.get(i));
		}
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dao.deletarCaminhao(caminhao);
					JOptionPane.showMessageDialog(null, "O Caminhão Código: "+caminhao.getCodigo()+"\n"
							+ "Placa: "+caminhao.getPlaca()+"\n"
									+ "Tipo Caminhão: "+caminhao.getTipoCaminhao()+"\n"
											+ "Módulo: "+caminhao.getModuloCaminhao()+"\n"
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
		btnAlterar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnAlterar.setBackground(Color.YELLOW);
		btnAlterar.setBounds(200, 359, 111, 36);
		contentPane.add(btnAlterar);
		
		JButton btnConfirmar = new JButton("Cadastrar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ca.setPlaca(textPlaca.getText());
				
				if (cbModulo.getSelectedIndex()== 0 || cbTipo.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "Selecione uma Opção!");
				}else if (cbModulo.getSelectedIndex()==1) {
					ca.setModuloCaminhao(1);
				}else if (cbModulo.getSelectedIndex()==2) {
					ca.setModuloCaminhao(2);
				}else if (cbModulo.getSelectedIndex()==3) {
					ca.setModuloCaminhao(3);
				}
				
				if (cbTipo.getSelectedIndex()==1) {
					ca.setTipoCaminhao(1);
				}else if (cbTipo.getSelectedIndex()==2) {
					ca.setTipoCaminhao(2);
				}else if (cbTipo.getSelectedIndex()==3) {
					ca.setTipoCaminhao(3);
				}else if (cbTipo.getSelectedIndex()==4) {
					ca.setTipoCaminhao(4);
				}else if (cbTipo.getSelectedIndex()==5) {
					ca.setTipoCaminhao(5);
				}
				if (cbModulo.getSelectedIndex() > 0 && cbTipo.getSelectedIndex() > 0) {
					
					limpar();
					
					try {
						dao.cadastrarCaminhao(ca);
						JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnConfirmar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnConfirmar.setBackground(Color.GREEN);
		btnConfirmar.setBounds(370, 359, 111, 36);
		contentPane.add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVoltar.setBounds(10, 11, 79, 27);
		contentPane.add(btnVoltar);

	}
	public void limpar() {
		textBuscar.setText(null);
		textPlaca.setText(null);
		cbModulo.setSelectedIndex(0);
		cbTipo.setSelectedIndex(0);
		
		try {
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
		
}
