package br.univel.Cadastro;

import javax.swing.JPanel;

import br.univel.BancoDeDados;
import br.univel.Cliente;
import br.univel.Produto;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;

public class AbaCadastroVenda extends JPanel {

	/**
	 * Create the panel.
	 */
	public AbaCadastroVenda() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 0;
		add(lblCliente, gbc_lblCliente);
		
		JComboBox comboBox = null;
		try {
			BancoDeDados banco = new BancoDeDados();
			List<Cliente> cliente = banco.PuxarInfoCliente();
			Vector<String> v = new Vector<String>();
			for (int i = 0; i < cliente.size(); i++) {
				v.add(cliente.get(i).getNome());
			}
			comboBox = new JComboBox<>(v);
		} catch (Exception e) {
			// TODO: handle exception
		}
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		add(comboBox, gbc_comboBox);
		
		JLabel lblProduto = new JLabel("Produto");
		GridBagConstraints gbc_lblProduto = new GridBagConstraints();
		gbc_lblProduto.anchor = GridBagConstraints.EAST;
		gbc_lblProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProduto.gridx = 0;
		gbc_lblProduto.gridy = 1;
		add(lblProduto, gbc_lblProduto);
		
		JComboBox comboBox_1 = new JComboBox();
//		try {
//			BancoDeDados banco2 = new BancoDeDados();
//			List<Produto> produto = banco2.PuxarInfoProduto();
//			Vector<String> v = new Vector<String>();
//			for (int i = 0; i < produto.size(); i++) {
//				v.add(produto.get(i).getDescricao());
//			}
//			comboBox_1 = new JComboBox<>(v);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 1;
		add(comboBox_1, gbc_comboBox_1);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		add(label, gbc_label);

	}

}
