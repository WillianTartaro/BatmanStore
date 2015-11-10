package br.univel.Cadastro;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;

public abstract class MolduraCadastroVenda extends JPanel {
	
	private JButton btnFechar;
	
	/**
	 * Create the panel.
	 */
	protected abstract void configuraMiolo();
	public void setCloseAction(ActionListener action) {
		btnFechar.addActionListener(action);
	}
	
	public MolduraCadastroVenda() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{186, 77, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{14, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCadastroVenda = new JLabel("Cadastro Venda");
		GridBagConstraints gbc_lblCadastroVenda = new GridBagConstraints();
		gbc_lblCadastroVenda.insets = new Insets(0, 0, 0, 5);
		gbc_lblCadastroVenda.anchor = GridBagConstraints.NORTH;
		gbc_lblCadastroVenda.gridx = 0;
		gbc_lblCadastroVenda.gridy = 0;
		panel.add(lblCadastroVenda, gbc_lblCadastroVenda);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setForeground(Color.WHITE);
		btnFechar.setBackground(Color.BLACK);
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.insets = new Insets(0, 0, 0, 5);
		gbc_btnFechar.gridx = 5;
		gbc_btnFechar.gridy = 0;
		panel.add(btnFechar, gbc_btnFechar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblBatstore = new JLabel("BatStore");
		lblBatstore.setForeground(Color.BLACK);
		panel_1.add(lblBatstore);
		
		configuraMiolo();

	}

}
