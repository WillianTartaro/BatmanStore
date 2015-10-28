package br.univel.Cadastro;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;

public abstract class MolduraCadastroProduto extends JPanel {

	
private JButton btnFechar;
	
	protected abstract void configuraMiolo();
	public void setCloseAction(ActionListener action) {
		btnFechar.addActionListener(action);
	}
	
	/**
	 * Create the panel.
	 */
	public MolduraCadastroProduto() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{182, 85, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{14, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCadastroProduto = new JLabel("Cadastro Produto");
		lblCadastroProduto.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblCadastroProduto = new GridBagConstraints();
		gbc_lblCadastroProduto.insets = new Insets(0, 0, 0, 5);
		gbc_lblCadastroProduto.gridx = 0;
		gbc_lblCadastroProduto.gridy = 0;
		panel.add(lblCadastroProduto, gbc_lblCadastroProduto);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setForeground(Color.WHITE);
		btnFechar.setBackground(Color.BLACK);
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.insets = new Insets(0, 0, 0, 5);
		gbc_btnFechar.anchor = GridBagConstraints.EAST;
		gbc_btnFechar.gridx = 6;
		gbc_btnFechar.gridy = 0;
		panel.add(btnFechar, gbc_btnFechar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.BLACK);
		add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblBatstore = new JLabel("BatStore");
		panel_1.add(lblBatstore);

		configuraMiolo();
	}

}
