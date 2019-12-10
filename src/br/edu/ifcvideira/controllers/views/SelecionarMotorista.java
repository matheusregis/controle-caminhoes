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
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import java.awt.Toolkit;

public class SelecionarMotorista extends JFrame {

	private JPanel contentPane;
	private JTextField textBuscarMotorista;
	private JTextField textNomeMotorista;
	private JTextField textCpf;
	private JTextField textTelefone;
	private JTextField textBuscarCaminhao;
	private JTextField textPlaca;
	private JTextField textNotaFiscal;
	private JTextField textMaterial;
	private JTextField textValorUnitario;
	private JTextField textQuantidade;
	
	SelecionarMotoristaDAO daoSe = new SelecionarMotoristaDAO();
	CaminhoesDAO daoCa = new CaminhoesDAO();
	FornecedorDAO daoFo = new FornecedorDAO();
	MotoristaDAO daoMo = new MotoristaDAO();
	Motorista mo = new Motorista();
	Caminhao ca = new Caminhao();
	Fornecedor fo = new Fornecedor();
	NotaFiscal nf = new NotaFiscal();
	private JTextField textBuscarFornecedores;
	private JTextField textNomeFornecedor;
	private JTextField textCidade;
	private JTextField textEstado;
	private JTextField textModulo;
	private JTextField textTipo;
	private JTextField textDataEmissao;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelecionarMotorista frame = new SelecionarMotorista();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public SelecionarMotorista() throws SQLException, Exception {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelecionarMotorista.class.getResource("/br/edu/ifcvideira/imgs/search16x16.png")));
		setTitle("Selecionar Motorista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1370, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeMotorista = new JLabel("Selecionar Motorista");
		lblCadastroDeMotorista.setFont(new Font("SansSerif", Font.BOLD, 28));
		lblCadastroDeMotorista.setBounds(538, 21, 278, 37);
		contentPane.add(lblCadastroDeMotorista);
		
		JLabel lblMotorista = new JLabel("Buscar:");
		lblMotorista.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblMotorista.setBounds(71, 133, 67, 24);
		contentPane.add(lblMotorista);
		
		textBuscarMotorista = new JTextField();
		textBuscarMotorista.setFont(new Font("SansSerif", Font.BOLD, 16));
		textBuscarMotorista.setBounds(148, 136, 250, 26);
		contentPane.add(textBuscarMotorista);
		textBuscarMotorista.setColumns(10);
		
		JButton btnBuscarMotorista = new JButton();
		btnBuscarMotorista.setIcon(new ImageIcon(CadastrarCaminhao.class.getResource("/br/edu/ifcvideira/imgs/searchh.png")));
		btnBuscarMotorista.setBounds(408, 130, 43, 36);
		contentPane.add(btnBuscarMotorista);
		btnBuscarMotorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					mo = daoMo.buscarDadosMotorista(textBuscarMotorista.getText());
					textNomeMotorista.setText(mo.getNomeMotorista());					
					textCpf.setText(mo.getCpf());
					textTelefone.setText(mo.getTelefone());
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		
		textNomeMotorista = new JTextField();
		textNomeMotorista.setEditable(false);
		textNomeMotorista.setFont(new Font("SansSerif", Font.BOLD, 16));
		textNomeMotorista.setColumns(10);
		textNomeMotorista.setBounds(131, 206, 250, 26);
		contentPane.add(textNomeMotorista);
		
		JLabel lblNomeMotorista = new JLabel("Nome:");
		lblNomeMotorista.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNomeMotorista.setBounds(51, 206, 67, 24);
		contentPane.add(lblNomeMotorista);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblCpf.setBounds(66, 266, 50, 24);
		contentPane.add(lblCpf);
		
		JLabel IconSelecionar = new JLabel("");
		IconSelecionar.setIcon(new ImageIcon(SelecionarMotorista.class.getResource("/br/edu/ifcvideira/imgs/search.png")));
		IconSelecionar.setBounds(450, 11, 67, 64);
		contentPane.add(IconSelecionar);
		
		textCpf = new JTextField();
		textCpf.setEditable(false);
		textCpf.setFont(new Font("SansSerif", Font.BOLD, 16));
		textCpf.setColumns(10);
		textCpf.setBounds(131, 266, 250, 26);
		contentPane.add(textCpf);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTelefone.setBounds(28, 326, 89, 24);
		contentPane.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setEditable(false);
		textTelefone.setFont(new Font("SansSerif", Font.BOLD, 16));
		textTelefone.setColumns(10);
		textTelefone.setBounds(131, 326, 250, 26);
		contentPane.add(textTelefone);

		JLabel lblCaminhao = new JLabel("Buscar:");
		lblCaminhao.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblCaminhao.setBounds(519, 133, 67, 24);
		contentPane.add(lblCaminhao);
		
		textBuscarCaminhao = new JTextField();
		textBuscarCaminhao.setFont(new Font("SansSerif", Font.BOLD, 16));
		textBuscarCaminhao.setColumns(10);
		textBuscarCaminhao.setBounds(596, 136, 250, 26);
		contentPane.add(textBuscarCaminhao);
		
		
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPlaca.setBounds(500, 206, 67, 24);
		contentPane.add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setEditable(false);
		textPlaca.setFont(new Font("SansSerif", Font.BOLD, 16));
		textPlaca.setColumns(10);
		textPlaca.setBounds(582, 206, 250, 26);
		contentPane.add(textPlaca);
		
		JLabel lblModulo = new JLabel("M\u00F3dulo:");
		lblModulo.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblModulo.setBounds(500, 266, 70, 24);
		contentPane.add(lblModulo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTipo.setBounds(500, 326, 67, 24);
		contentPane.add(lblTipo);
		
		JLabel lblBuscarMotorista = new JLabel("Buscar Motorista");
		lblBuscarMotorista.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblBuscarMotorista.setBounds(168, 86, 170, 26);
		contentPane.add(lblBuscarMotorista);
		
		JLabel iconMotorista = new JLabel("");
		iconMotorista.setIcon(new ImageIcon(SelecionarMotorista.class.getResource("/br/edu/ifcvideira/imgs/driving-test32x32.png")));
		iconMotorista.setBounds(131, 80, 32, 32);
		contentPane.add(iconMotorista);
		
		JLabel iconCaminhao = new JLabel("");
		iconCaminhao.setIcon(new ImageIcon(SelecionarMotorista.class.getResource("/br/edu/ifcvideira/imgs/truckPluss50x50.png")));
		iconCaminhao.setBounds(582, 69, 50, 50);
		contentPane.add(iconCaminhao);
		
		JLabel lblBuscarCaminhao = new JLabel("Buscar Caminhao");
		lblBuscarCaminhao.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblBuscarCaminhao.setBounds(632, 82, 170, 26);
		contentPane.add(lblBuscarCaminhao);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(421, 614, 111, 36);
		contentPane.add(btnVoltar);
		
		JLabel lblDadosNF = new JLabel("Dados Nota Fiscal");
		lblDadosNF.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblDadosNF.setBounds(590, 376, 173, 26);
		contentPane.add(lblDadosNF);
		
		JLabel iconNF = new JLabel("");
		iconNF.setIcon(new ImageIcon(SelecionarMotorista.class.getResource("/br/edu/ifcvideira/imgs/businessmann.png")));
		iconNF.setBounds(544, 370, 32, 32);
		contentPane.add(iconNF);
		
		JLabel lblNotaFiscal = new JLabel("N\u00BA NF:");
		lblNotaFiscal.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNotaFiscal.setBounds(283, 421, 61, 24);
		contentPane.add(lblNotaFiscal);
		
		textNotaFiscal = new JTextField();
		textNotaFiscal.setFont(new Font("SansSerif", Font.BOLD, 16));
		textNotaFiscal.setColumns(10);
		textNotaFiscal.setBounds(348, 420, 250, 26);
		contentPane.add(textNotaFiscal);
		
		JLabel lblDataEmissao = new JLabel("Data Emiss\u00E3o:");
		lblDataEmissao.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblDataEmissao.setBounds(213, 480, 124, 24);
		contentPane.add(lblDataEmissao);
		
		textMaterial = new JTextField();
		textMaterial.setFont(new Font("SansSerif", Font.BOLD, 16));
		textMaterial.setColumns(10);
		textMaterial.setBounds(916, 420, 250, 26);
		contentPane.add(textMaterial);
		
		JLabel lblMaterial = new JLabel("Material:");
		lblMaterial.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblMaterial.setBounds(826, 420, 74, 24);
		contentPane.add(lblMaterial);
		
		textValorUnitario = new JTextField();
		textValorUnitario.setFont(new Font("SansSerif", Font.BOLD, 16));
		textValorUnitario.setColumns(10);
		textValorUnitario.setBounds(916, 480, 89, 26);
		contentPane.add(textValorUnitario);
		
		JLabel lblValorUnitario = new JLabel("Valor Unit\u00E1rio:");
		lblValorUnitario.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblValorUnitario.setBounds(776, 480, 124, 24);
		contentPane.add(lblValorUnitario);
		
		textQuantidade = new JTextField();
		textQuantidade.setFont(new Font("SansSerif", Font.BOLD, 16));
		textQuantidade.setColumns(10);
		textQuantidade.setBounds(916, 540, 89, 26);
		contentPane.add(textQuantidade);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblQuantidade.setBounds(795, 541, 105, 24);
		contentPane.add(lblQuantidade);
		
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnLimpar.setBackground(Color.YELLOW);
		btnLimpar.setBounds(621, 614, 111, 36);
		contentPane.add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nf.setNumeroNotaFiscal(textNotaFiscal.getText());
				nf.setDataEmissaoNotaFiscal(textDataEmissao.getText());
				nf.setProduto(textMaterial.getText());
				nf.setQuantidade(Integer.parseInt(textQuantidade.getText()));
				nf.setValorUnitario(Float.parseFloat(textValorUnitario.getText()));
				
				try {
					daoSe.cadastrarNF(nf);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				limpar();
			}
		});
		btnSelecionar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnSelecionar.setBackground(Color.GREEN);
		btnSelecionar.setBounds(821, 614, 121, 36);
		contentPane.add(btnSelecionar);
		
		JLabel lblBuscarFornecedores = new JLabel("Buscar Fornecedores");
		lblBuscarFornecedores.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblBuscarFornecedores.setBounds(1035, 82, 213, 26);
		contentPane.add(lblBuscarFornecedores);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SelecionarMotorista.class.getResource("/br/edu/ifcvideira/imgs/businessmann.png")));
		label_1.setBounds(989, 76, 32, 32);
		contentPane.add(label_1);
		
		JLabel lblFornecedores = new JLabel("Buscar:");
		lblFornecedores.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblFornecedores.setBounds(946, 136, 67, 24);
		contentPane.add(lblFornecedores);
		
		textBuscarFornecedores = new JTextField();
		textBuscarFornecedores.setFont(new Font("SansSerif", Font.BOLD, 16));
		textBuscarFornecedores.setColumns(10);
		textBuscarFornecedores.setBounds(1023, 136, 250, 26);
		contentPane.add(textBuscarFornecedores);
		
		
		
		JLabel lblNomeFornecedor = new JLabel("Fornecedor:");
		lblNomeFornecedor.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNomeFornecedor.setBounds(909, 206, 105, 24);
		contentPane.add(lblNomeFornecedor);
		
		textNomeFornecedor = new JTextField();
		textNomeFornecedor.setEditable(false);
		textNomeFornecedor.setFont(new Font("SansSerif", Font.BOLD, 16));
		textNomeFornecedor.setColumns(10);
		textNomeFornecedor.setBounds(1041, 206, 250, 26);
		contentPane.add(textNomeFornecedor);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblCidade.setBounds(945, 266, 70, 24);
		contentPane.add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setEditable(false);
		textCidade.setFont(new Font("SansSerif", Font.BOLD, 16));
		textCidade.setColumns(10);
		textCidade.setBounds(1041, 266, 250, 26);
		contentPane.add(textCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblEstado.setBounds(945, 326, 67, 24);
		contentPane.add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setEditable(false);
		textEstado.setFont(new Font("SansSerif", Font.BOLD, 16));
		textEstado.setColumns(10);
		textEstado.setBounds(1041, 326, 35, 26);
		contentPane.add(textEstado);
		
		JButton btnBuscarCaminhao = new JButton();
		btnBuscarCaminhao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					ca = daoCa.buscarPlacaCaminhao(textBuscarCaminhao.getText());
					textPlaca.setText(ca.getPlaca());
					opcaoModulo();
					opcaoTipo();
					
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnBuscarCaminhao.setIcon(new ImageIcon(SelecionarMotorista.class.getResource("/br/edu/ifcvideira/imgs/searchh.png")));
		btnBuscarCaminhao.setBounds(856, 130, 43, 36);
		contentPane.add(btnBuscarCaminhao);
		
		JButton btnBuscarFornecedores = new JButton();
		btnBuscarFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					fo = daoFo.buscarDadosFornecedor(textBuscarFornecedores.getText());
					textNomeFornecedor.setText(fo.getNomeFornecedor());					
					textCidade.setText(fo.getCidade());
					textEstado.setText(fo.getEstado());
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnBuscarFornecedores.setIcon(new ImageIcon(SelecionarMotorista.class.getResource("/br/edu/ifcvideira/imgs/searchh.png")));
		btnBuscarFornecedores.setBounds(1283, 130, 43, 36);
		contentPane.add(btnBuscarFornecedores);
		
		textModulo = new JTextField();
		textModulo.setFont(new Font("SansSerif", Font.BOLD, 16));
		textModulo.setEditable(false);
		textModulo.setColumns(10);
		textModulo.setBounds(582, 264, 250, 26);
		contentPane.add(textModulo);
		
		textTipo = new JTextField();
		textTipo.setFont(new Font("SansSerif", Font.BOLD, 16));
		textTipo.setEditable(false);
		textTipo.setColumns(10);
		textTipo.setBounds(582, 324, 250, 26);
		contentPane.add(textTipo);
		
		textDataEmissao = new JTextField();
		textDataEmissao.setFont(new Font("SansSerif", Font.BOLD, 16));
		textDataEmissao.setColumns(10);
		textDataEmissao.setBounds(348, 480, 250, 26);
		contentPane.add(textDataEmissao);
		
	}
	public void limpar() {
		textBuscarMotorista.setText(null);
		textNomeMotorista.setText(null);
		textCpf.setText(null);
		textTelefone.setText(null);
		textBuscarCaminhao.setText(null);
		textPlaca.setText(null);
		textModulo.setText(null);
		textTipo.setText(null);
		textBuscarFornecedores.setText(null);
		textNomeFornecedor.setText(null);
		textCidade.setText(null);
		textEstado.setText(null);
		textNotaFiscal.setText(null);
		textDataEmissao.setText(null);
		textMaterial.setText(null);
		textValorUnitario.setText(null);
		textQuantidade.setText(null);
		
		try {
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public void opcaoModulo() {
		
		if (ca.getModuloCaminhao() == 1) {
			textModulo.setText("GRANELEIRO");
		}else if (ca.getModuloCaminhao() == 2) {
			textModulo.setText("GRADE BAIXA");
		}else if (ca.getModuloCaminhao() == 3) {
			textModulo.setText("SIDER");
		}
		
	}
	public void opcaoTipo() {
		if (ca.getTipoCaminhao() == 1) {
			textTipo.setText("CARRETA");
		}else if (ca.getTipoCaminhao() == 2) {
			textTipo.setText("BITRUCK");
		}else if (ca.getTipoCaminhao() == 3) {
			textTipo.setText("TRUCK");
		}else if (ca.getTipoCaminhao() == 4) {
			textTipo.setText("BITREM");
		}else if (ca.getTipoCaminhao() == 5) {
			textTipo.setText("RODOTREM");
		}
	}
}
