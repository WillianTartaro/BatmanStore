package br.univel.Cadastro;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.univel.BancoDeDados;
import br.univel.Cliente;
import br.univel.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AbaCadastroUsuario extends JPanel {
	private JTextField txtId;
	private JTextField txtSenha;
	private JTable table;
	private JComboBox comboBox;

	private TableModelUsuario model = new TableModelUsuario();
	
	/**
	 * Create the panel.
	 */
	public AbaCadastroUsuario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{49, 124, 65, 195, 0};
		gridBagLayout.rowHeights = new int[]{20, 20, 20, 23, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		GridBagConstraints gbc_lblIdCliente = new GridBagConstraints();
		gbc_lblIdCliente.anchor = GridBagConstraints.EAST;
		gbc_lblIdCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdCliente.gridx = 0;
		gbc_lblIdCliente.gridy = 0;
		add(lblIdCliente, gbc_lblIdCliente);
		
		//JComboBox comboBox = null;
		
		try {
			BancoDeDados banco = new BancoDeDados();
			List<Cliente> Quero = banco.PuxarInfo();
			Vector<Integer> v = new Vector<Integer>();
			for (int i = 0; i < Quero.size(); i++) {
				v.add(Quero.get(i).getId());
			}
			comboBox = new JComboBox<>(v);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.NORTH;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		add(comboBox, gbc_comboBox);
		
		JLabel lblIdUsuario = new JLabel("Id Usuario");
		GridBagConstraints gbc_lblIdUsuario = new GridBagConstraints();
		gbc_lblIdUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblIdUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdUsuario.gridx = 0;
		gbc_lblIdUsuario.gridy = 1;
		add(lblIdUsuario, gbc_lblIdUsuario);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.anchor = GridBagConstraints.NORTH;
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.insets = new Insets(0, 0, 5, 0);
		gbc_txtId.gridwidth = 3;
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 1;
		add(txtId, gbc_txtId);
		
		JLabel lblSenha = new JLabel("Senha");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 2;
		add(lblSenha, gbc_lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		GridBagConstraints gbc_txtSenha = new GridBagConstraints();
		gbc_txtSenha.anchor = GridBagConstraints.NORTH;
		gbc_txtSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSenha.insets = new Insets(0, 0, 5, 0);
		gbc_txtSenha.gridwidth = 3;
		gbc_txtSenha.gridx = 1;
		gbc_txtSenha.gridy = 2;
		add(txtSenha, gbc_txtSenha);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario u = new Usuario();
				
				Object idCliente1 = comboBox.getSelectedItem();
			  	
				u.setIdc((Integer) idCliente1);
				u.setId(Integer.parseInt(txtId.getText()));
				u.setSenha(txtSenha.getText());
				
				try {
					BancoDeDados banco = new BancoDeDados();
					banco.GravarUsuario(u);
					atualizaTable();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalvar.gridx = 1;
		gbc_btnSalvar.gridy = 3;
		add(btnSalvar, gbc_btnSalvar);
		
		JButton btnAlterar = new JButton("Alterar");
		GridBagConstraints gbc_btnAlterar = new GridBagConstraints();
		gbc_btnAlterar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAlterar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAlterar.gridx = 2;
		gbc_btnAlterar.gridy = 3;
		add(btnAlterar, gbc_btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				excluirUsuario();
			}

			private void excluirUsuario() {
				String idusuario = txtId.getText();
				Usuario u = new Usuario();
				u.setId(Integer.parseInt(idusuario));
				
				try {
					BancoDeDados banco = new BancoDeDados();
					banco.ExcluirUsuario(u);
					atualizaTable();
				} catch (SQLException e) {
					// TODO: handle exception
				}
			}
		});
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 5, 0);
		gbc_btnExcluir.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnExcluir.gridx = 3;
		gbc_btnExcluir.gridy = 3;
		add(btnExcluir, gbc_btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CarregaTabela(model.getLista3().get(table.getSelectedRow()));
			}

			private void CarregaTabela(Usuario usuario) {
				
				comboBox.setSelectedItem(usuario.getIdc());
				txtId.setText(Integer.toString(usuario.getId()));
				txtSenha.setText(usuario.getSenha());
				
			}
		});
		scrollPane.setViewportView(table);
		
		atualizaTable();



		
		
	}

	private void atualizaTable() {

		try {
			BancoDeDados banco = new BancoDeDados();
			model.setLista3((ArrayList<Usuario>) banco.usuarioTabela());
		} catch (SQLException e) {
			
		}
	}
}
