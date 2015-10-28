package br.univel.Cadastro;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class MolduraCadastro extends JPanel {

	private JButton btnFechar;
	
	protected abstract void configuraMiolo();
	public void setCloseAction(ActionListener action) {
		btnFechar.addActionListener(action);
	}
	/**
	 * Create the panel.
	 */
	public MolduraCadastro() {
		setLayout(new BorderLayout(0, 0));
		
		Panel panel = new Panel();
		panel.setBackground(Color.BLACK);
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{210, 30, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{14, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setBackground(Color.WHITE);
		btnFechar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblCadastroCliente = new JLabel("Cadastro Cliente");
		lblCadastroCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCadastroCliente.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCadastroCliente = new GridBagConstraints();
		gbc_lblCadastroCliente.anchor = GridBagConstraints.WEST;
		gbc_lblCadastroCliente.insets = new Insets(0, 0, 0, 5);
		gbc_lblCadastroCliente.gridx = 0;
		gbc_lblCadastroCliente.gridy = 0;
		panel.add(lblCadastroCliente, gbc_lblCadastroCliente);
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.anchor = GridBagConstraints.EAST;
		gbc_btnFechar.fill = GridBagConstraints.VERTICAL;
		gbc_btnFechar.gridwidth = 8;
		gbc_btnFechar.gridx = 1;
		gbc_btnFechar.gridy = 0;
		panel.add(btnFechar, gbc_btnFechar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblBatstore = new JLabel("BatStore");
		lblBatstore.setForeground(Color.WHITE);
		panel_1.add(lblBatstore);
		
		configuraMiolo();

	}

}
