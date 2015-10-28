package br.univel.Cadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("BatmanStore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTela();
			}

			private void abrirTela() {
				TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
				telaCadastroCliente.setCloseAction(e -> tabbedPane.remove(telaCadastroCliente));
				tabbedPane.addTab("Cadastro Cliente ", telaCadastroCliente);
				
			}
		});
		mnCadastros.add(mntmCliente);
		
		JMenuItem mntmUsuario = new JMenuItem("Usuario");
		mnCadastros.add(mntmUsuario);
		
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mnCadastros.add(mntmProduto);
		
		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);
		
		JMenuItem mntmProduto_1 = new JMenuItem("Produto");
		mnVendas.add(mntmProduto_1);
		
		JMenuItem mntmServios = new JMenuItem("Servi\u00E7os");
		mnVendas.add(mntmServios);
		
		JMenu mnRelatorios = new JMenu("Relatorios");
		menuBar.add(mnRelatorios);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mnRelatorios.add(mntmClientes);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mnRelatorios.add(mntmProdutos);
		
		JMenuItem mntmVendas = new JMenuItem("Vendas");
		mnRelatorios.add(mntmVendas);
		
		JMenuItem mntmServios_1 = new JMenuItem("Servi\u00E7os");
		mnRelatorios.add(mntmServios_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

}
