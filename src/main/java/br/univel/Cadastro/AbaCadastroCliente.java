package br.univel.Cadastro;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AbaCadastroCliente extends JPanel {
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtEmail;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public AbaCadastroCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{45, 63, 65, 63, 108, 85, 0};
		gridBagLayout.rowHeights = new int[]{20, 20, 20, 20, 20, 20, 20, 20, 23, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.anchor = GridBagConstraints.NORTH;
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.insets = new Insets(0, 0, 5, 0);
		gbc_txtId.gridwidth = 5;
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 0;
		add(txtId, gbc_txtId);
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.anchor = GridBagConstraints.NORTH;
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.insets = new Insets(0, 0, 5, 0);
		gbc_txtNome.gridwidth = 5;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 1;
		add(txtNome, gbc_txtNome);
		
		JLabel lblTelefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 2;
		add(lblTelefone, gbc_lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		GridBagConstraints gbc_txtTelefone = new GridBagConstraints();
		gbc_txtTelefone.anchor = GridBagConstraints.NORTH;
		gbc_txtTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefone.insets = new Insets(0, 0, 5, 0);
		gbc_txtTelefone.gridwidth = 5;
		gbc_txtTelefone.gridx = 1;
		gbc_txtTelefone.gridy = 2;
		add(txtTelefone, gbc_txtTelefone);
		
		JLabel lblCidade = new JLabel("Endere\u00E7o");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.WEST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 3;
		add(lblCidade, gbc_lblCidade);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		GridBagConstraints gbc_txtEndereco = new GridBagConstraints();
		gbc_txtEndereco.anchor = GridBagConstraints.NORTH;
		gbc_txtEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndereco.insets = new Insets(0, 0, 5, 0);
		gbc_txtEndereco.gridwidth = 5;
		gbc_txtEndereco.gridx = 1;
		gbc_txtEndereco.gridy = 3;
		add(txtEndereco, gbc_txtEndereco);
		
		JLabel lblCidade_1 = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade_1 = new GridBagConstraints();
		gbc_lblCidade_1.anchor = GridBagConstraints.EAST;
		gbc_lblCidade_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade_1.gridx = 0;
		gbc_lblCidade_1.gridy = 4;
		add(lblCidade_1, gbc_lblCidade_1);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		GridBagConstraints gbc_txtCidade = new GridBagConstraints();
		gbc_txtCidade.anchor = GridBagConstraints.NORTH;
		gbc_txtCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCidade.insets = new Insets(0, 0, 5, 0);
		gbc_txtCidade.gridwidth = 5;
		gbc_txtCidade.gridx = 1;
		gbc_txtCidade.gridy = 4;
		add(txtCidade, gbc_txtCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 5;
		add(lblEstado, gbc_lblEstado);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.NORTH;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridwidth = 5;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		add(comboBox, gbc_comboBox);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.anchor = GridBagConstraints.NORTH;
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridwidth = 5;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 6;
		add(txtEmail, gbc_txtEmail);
		
		JLabel lblGenero = new JLabel("Genero");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.EAST;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 0;
		gbc_lblGenero.gridy = 7;
		add(lblGenero, gbc_lblGenero);
		
		comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.anchor = GridBagConstraints.NORTH;
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.gridwidth = 5;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 7;
		add(comboBox_1, gbc_comboBox_1);
		
		JButton btnSalvar = new JButton("Salvar");
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalvar.gridx = 1;
		gbc_btnSalvar.gridy = 8;
		add(btnSalvar, gbc_btnSalvar);
		
		JButton btnAlterar = new JButton("Alterar");
		GridBagConstraints gbc_btnAlterar = new GridBagConstraints();
		gbc_btnAlterar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAlterar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAlterar.gridx = 2;
		gbc_btnAlterar.gridy = 8;
		add(btnAlterar, gbc_btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnExcluir.insets = new Insets(0, 0, 5, 5);
		gbc_btnExcluir.gridx = 3;
		gbc_btnExcluir.gridy = 8;
		add(btnExcluir, gbc_btnExcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancelar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancelar.gridx = 5;
		gbc_btnCancelar.gridy = 8;
		add(btnCancelar, gbc_btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 9;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
}
