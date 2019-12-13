package br.edu.ifcvideira.controllers.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class AparasPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable tableDadosGerais;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AparasPrincipal frame = new AparasPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AparasPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AparasPrincipal.class.getResource("/br/edu/ifcvideira/imgs/logistics-delivery-truck-in-movement.png")));
		setTitle("Controle Entrada Caminh\u00F5es Aparas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1481, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblControleAparas = new JLabel("Controle Entrada Caminh\u00F5es Aparas");
		lblControleAparas.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblControleAparas.setBounds(200, 11, 319, 24);
		contentPane.add(lblControleAparas);
		
		JLabel lblMotorista = new JLabel("");
		lblMotorista.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMotorista.setIcon(new ImageIcon(AparasPrincipal.class.getResource("/br/edu/ifcvideira/imgs/driving-test1.png")));
		lblMotorista.setBounds(55, 295, 64, 64);
		contentPane.add(lblMotorista);
		
		JButton btnMotorista = new JButton("Cadastro Motorista");
		btnMotorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CadastrarMotorista frame = new CadastrarMotorista();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnMotorista.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnMotorista.setBounds(15, 362, 150, 25);
		contentPane.add(btnMotorista);
		
		JLabel iconFornecedor = new JLabel("");
		iconFornecedor.setIcon(new ImageIcon(AparasPrincipal.class.getResource("/br/edu/ifcvideira/imgs/businessman32x32.png")));
		iconFornecedor.setHorizontalAlignment(SwingConstants.RIGHT);
		iconFornecedor.setBounds(55, 115, 64, 64);
		contentPane.add(iconFornecedor);
		
		JButton btnFornecedor = new JButton("Cadastro Fornecedor");
		btnFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CadastrarFornecedor frame = new CadastrarFornecedor();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnFornecedor.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnFornecedor.setBounds(10, 182, 160, 25);
		contentPane.add(btnFornecedor);
		
		JLabel iconCaminhao = new JLabel("");
		iconCaminhao.setIcon(new ImageIcon(AparasPrincipal.class.getResource("/br/edu/ifcvideira/imgs/truckPluss.png")));
		iconCaminhao.setHorizontalAlignment(SwingConstants.RIGHT);
		iconCaminhao.setBounds(34, 218, 100, 47);
		contentPane.add(iconCaminhao);
		
		JButton btnCaminhao = new JButton("Cadastro Caminh\u00F5es");
		btnCaminhao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CadastrarCaminhao frame = new CadastrarCaminhao();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCaminhao.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCaminhao.setBounds(10, 259, 155, 25);
		contentPane.add(btnCaminhao);
		
		JLabel iconSelecionar = new JLabel("");
		iconSelecionar.setIcon(new ImageIcon(AparasPrincipal.class.getResource("/br/edu/ifcvideira/imgs/search.png")));
		iconSelecionar.setHorizontalAlignment(SwingConstants.RIGHT);
		iconSelecionar.setBounds(55, 11, 64, 64);
		contentPane.add(iconSelecionar);
		
		JButton btnSelecionar = new JButton("Selecionar Motorista");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SelecionarMotorista frame = new SelecionarMotorista();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSelecionar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSelecionar.setBounds(15, 79, 155, 25);
		contentPane.add(btnSelecionar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		btnSair.setForeground(Color.WHITE);
		btnSair.setBackground(Color.RED);
		btnSair.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnSair.setBounds(40, 415, 92, 42);
		contentPane.add(btnSair);
		
		JScrollPane spPrincipal = new JScrollPane();
		spPrincipal.setBounds(175, 84, 1266, 370);
		spPrincipal.setAutoscrolls(true);
		
		contentPane.add(spPrincipal);
		
		tableDadosGerais = new JTable();
		tableDadosGerais.setFont(new Font("SansSerif", Font.BOLD, 12));
		tableDadosGerais.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Fornecedor", "Cidade", "Placa", "Tipo Caminhao", "Modulo", "Motorista", "CPF", "Contato", "Data Emissao NF", "N\u00BA NF", "Material", "Quant.", "Valor Unit\u00E1rio"
			}
		));
		setarTamanhoColunasTabelaDadosGerais();
		spPrincipal.getHorizontalScrollBar().setValue(contentPane.getHeight());
		spPrincipal.setViewportView(tableDadosGerais);
	}
	public void sair() {
		System.exit(0);
	}
	
	public void setarTamanhoColunasTabelaDadosGerais() {
		tableDadosGerais.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableDadosGerais.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableDadosGerais.getColumnModel().getColumn(2).setPreferredWidth(70);
		tableDadosGerais.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableDadosGerais.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableDadosGerais.getColumnModel().getColumn(5).setPreferredWidth(100);
		tableDadosGerais.getColumnModel().getColumn(6).setPreferredWidth(100);
		tableDadosGerais.getColumnModel().getColumn(7).setPreferredWidth(100);
		tableDadosGerais.getColumnModel().getColumn(8).setPreferredWidth(110);
		tableDadosGerais.getColumnModel().getColumn(9).setPreferredWidth(100);
		tableDadosGerais.getColumnModel().getColumn(10).setPreferredWidth(100);
		tableDadosGerais.getColumnModel().getColumn(11).setPreferredWidth(100);
		tableDadosGerais.getColumnModel().getColumn(12).setPreferredWidth(100);
	}
}
