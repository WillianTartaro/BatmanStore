package br.univel.Cadastro;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.univel.BancoDeDados;
import br.univel.Cliente;
import br.univel.Produto;
import br.univel.Venda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AbaCadastroVenda extends JPanel {
	private JTextField txtQuantidade;
	private JTable table;
	JComboBox comboBox;
	JComboBox comboBox_1;
	
	private TableModelVenda model = new TableModelVenda();
	private JTextField txtId;

	/**
	 * Create the panel.
	 */
	public AbaCadastroVenda() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1, 56, 86, 142, 63, 87, 0};
		gridBagLayout.rowHeights = new int[]{1, 17, 20, 20, 23, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTHWEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		
		try {
			BancoDeDados banco = new BancoDeDados();
			List<Cliente> cliente = banco.PuxarInfoCliente();
			Vector<String> v = new Vector<String>();
			for (int i = 0; i < cliente.size(); i++) {
				v.add(cliente.get(i).getNome());
				comboBox = new JComboBox<>(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridheight = 2;
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 0;
		add(comboBox, gbc_comboBox);
		
		JLabel lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 1;
		add(lblCliente, gbc_lblCliente);
		
		JLabel lblProduto = new JLabel("Produto");
		GridBagConstraints gbc_lblProduto = new GridBagConstraints();
		gbc_lblProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProduto.gridx = 1;
		gbc_lblProduto.gridy = 2;
		add(lblProduto, gbc_lblProduto);
		
		try {
			BancoDeDados banco = new BancoDeDados();
			List<Produto> produto = banco.PuxarInfoProduto();
			Vector<String> v = new Vector<String>();
			for (int i = 0; i < produto.size(); i++) {
				v.add(produto.get(i).getDescricao());
				comboBox_1 = new JComboBox<>(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.BOTH;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.gridwidth = 4;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 2;
		add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidade.gridx = 1;
		gbc_lblQuantidade.gridy = 3;
		add(lblQuantidade, gbc_lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		GridBagConstraints gbc_txtQuantidade = new GridBagConstraints();
		gbc_txtQuantidade.fill = GridBagConstraints.BOTH;
		gbc_txtQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtQuantidade.gridx = 2;
		gbc_txtQuantidade.gridy = 3;
		add(txtQuantidade, gbc_txtQuantidade);
		
		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Venda v = new Venda();
				
				Object nomeCliente = comboBox.getSelectedItem();
				Object nomeProduto = comboBox_1.getSelectedItem();
				v.setNomeCliente(nomeCliente.toString());
				v.setNomeProduto(nomeProduto.toString());
				v.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
				v.setIdvenda(Integer.parseInt(txtId.getText()));
				
				try {
					BancoDeDados banco = new BancoDeDados();
					banco.GravarVenda(v);
					atualizaTable();
				} catch (SQLException e) {
					// TODO: handle exception
				}
				
			}
		});
		
		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 4;
		add(lblId, gbc_lblId);
		
		txtId = new JTextField();
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.insets = new Insets(0, 0, 5, 5);
		gbc_txtId.fill = GridBagConstraints.BOTH;
		gbc_txtId.gridx = 2;
		gbc_txtId.gridy = 4;
		add(txtId, gbc_txtId);
		txtId.setColumns(10);
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalvar.gridx = 4;
		gbc_btnSalvar.gridy = 4;
		add(btnSalvar, gbc_btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				excluirVenda();
			}

			private void excluirVenda() {
				String idvenda = txtId.getText();
				Venda v = new Venda();
				v.setIdvenda(Integer.parseInt(idvenda));
				
				try {
					BancoDeDados banco = new BancoDeDados();
					banco.ExcluirVenda(v);
					atualizaTable();
				} catch (SQLException e) {
					// TODO: handle exception
				}
			}
		});
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 5, 0);
		gbc_btnExcluir.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnExcluir.gridx = 5;
		gbc_btnExcluir.gridy = 4;
		add(btnExcluir, gbc_btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					CarregaTabela(model.getLista4().get(table.getSelectedRow()));

				}
				
			}

			private void CarregaTabela(Venda venda) {
				comboBox.setSelectedItem(venda.getNomeCliente());
				comboBox_1.setSelectedItem(venda.getNomeProduto());
				txtQuantidade.setText(Integer.toString(venda.getQuantidade()));
				txtId.setText(Integer.toString(venda.getIdvenda()));
			}
		});
		scrollPane.setViewportView(table);

		atualizaTable();
		
	}
	private void atualizaTable(){
		try {
			BancoDeDados banco = new BancoDeDados();
			model.setLista4((ArrayList<Venda>) banco.vendaTabela());
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
