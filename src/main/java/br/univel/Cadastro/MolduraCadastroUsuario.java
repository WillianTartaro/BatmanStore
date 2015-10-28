package br.univel.Cadastro;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public abstract class MolduraCadastroUsuario extends JPanel {

	private JButton btnFechar;
	
	protected abstract void configuraMiolo();
	public void setCloseAction(ActionListener action) {
		btnFechar.addActionListener(action);
	}
	
	/**
	 * Create the panel.
	 */
	public MolduraCadastroUsuario() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{183, 83, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{14, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCadastroUsuario = new JLabel("Cadastro Usuario");
		lblCadastroUsuario.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCadastroUsuario = new GridBagConstraints();
		gbc_lblCadastroUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_lblCadastroUsuario.gridx = 0;
		gbc_lblCadastroUsuario.gridy = 0;
		panel.add(lblCadastroUsuario, gbc_lblCadastroUsuario);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setBackground(Color.WHITE);
		btnFechar.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.insets = new Insets(0, 0, 0, 5);
		gbc_btnFechar.gridx = 5;
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
