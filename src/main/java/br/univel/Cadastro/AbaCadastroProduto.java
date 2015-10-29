package br.univel.Cadastro;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.univel.Produto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class AbaCadastroProduto extends JPanel {
	private JTextField txtId;
	private JTextField txtCodigo;
	private JTextField txtCategoria;
	private JTextField txtDescricao;
	private JTextField txtUnidade;
	private JTextField txtCusto;
	private JTable table;
	
	private TableModelProduto model2 = new TableModelProduto();
	private JTextField txtLucro;

	/**
	 * Create the panel.
	 */
	public AbaCadastroProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{82, 63, 47, 65, 43, 145, 0};
		gridBagLayout.rowHeights = new int[]{20, 20, 20, 20, 20, 20, 0, 23, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Id");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Codigo de Barras");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		GridBagConstraints gbc_txtCodigo = new GridBagConstraints();
		gbc_txtCodigo.anchor = GridBagConstraints.NORTH;
		gbc_txtCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_txtCodigo.gridwidth = 5;
		gbc_txtCodigo.gridx = 1;
		gbc_txtCodigo.gridy = 1;
		add(txtCodigo, gbc_txtCodigo);
		
		JLabel lblNewLabel_2 = new JLabel("Categoria");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtCategoria = new JTextField();
		txtCategoria.setColumns(10);
		GridBagConstraints gbc_txtCategoria = new GridBagConstraints();
		gbc_txtCategoria.anchor = GridBagConstraints.NORTH;
		gbc_txtCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCategoria.insets = new Insets(0, 0, 5, 0);
		gbc_txtCategoria.gridwidth = 5;
		gbc_txtCategoria.gridx = 1;
		gbc_txtCategoria.gridy = 2;
		add(txtCategoria, gbc_txtCategoria);
		
		JLabel lblNewLabel_3 = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		GridBagConstraints gbc_txtDescricao = new GridBagConstraints();
		gbc_txtDescricao.anchor = GridBagConstraints.NORTH;
		gbc_txtDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescricao.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescricao.gridwidth = 5;
		gbc_txtDescricao.gridx = 1;
		gbc_txtDescricao.gridy = 3;
		add(txtDescricao, gbc_txtDescricao);
		
		JLabel lblNewLabel_4 = new JLabel("Unidade");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtUnidade = new JTextField();
		txtUnidade.setColumns(10);
		GridBagConstraints gbc_txtUnidade = new GridBagConstraints();
		gbc_txtUnidade.anchor = GridBagConstraints.NORTH;
		gbc_txtUnidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUnidade.insets = new Insets(0, 0, 5, 0);
		gbc_txtUnidade.gridwidth = 5;
		gbc_txtUnidade.gridx = 1;
		gbc_txtUnidade.gridy = 4;
		add(txtUnidade, gbc_txtUnidade);
		
		JLabel lblMarge = new JLabel("Custo");
		GridBagConstraints gbc_lblMarge = new GridBagConstraints();
		gbc_lblMarge.anchor = GridBagConstraints.EAST;
		gbc_lblMarge.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarge.gridx = 0;
		gbc_lblMarge.gridy = 5;
		add(lblMarge, gbc_lblMarge);
		
		txtCusto = new JTextField();
		txtCusto.setColumns(10);
		GridBagConstraints gbc_txtCusto = new GridBagConstraints();
		gbc_txtCusto.anchor = GridBagConstraints.NORTH;
		gbc_txtCusto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCusto.insets = new Insets(0, 0, 5, 0);
		gbc_txtCusto.gridwidth = 5;
		gbc_txtCusto.gridx = 1;
		gbc_txtCusto.gridy = 5;
		add(txtCusto, gbc_txtCusto);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Produto p = new Produto();
				
				p.setId(Integer.parseInt(txtId.getText()));
				p.setCodigo(Integer.parseInt(txtCodigo.getText()));
				p.setDescricao(txtDescricao.getText());
				p.setUnidade(txtUnidade.getText());
				String a = txtCusto.getText();
				BigDecimal b = new BigDecimal(a);
				p.setCusto(b);
				
				String c = txtLucro.getText();
				BigDecimal d = new BigDecimal(c);
				p.setMargemLucro(d);
				
				model2.adicionarNoModel(p);
				
			}
		});
		
		JLabel lblMargemDeLucro = new JLabel("Margem de Lucro");
		GridBagConstraints gbc_lblMargemDeLucro = new GridBagConstraints();
		gbc_lblMargemDeLucro.insets = new Insets(0, 0, 5, 5);
		gbc_lblMargemDeLucro.gridx = 0;
		gbc_lblMargemDeLucro.gridy = 6;
		add(lblMargemDeLucro, gbc_lblMargemDeLucro);
		
		txtLucro = new JTextField();
		GridBagConstraints gbc_txtLucro = new GridBagConstraints();
		gbc_txtLucro.gridwidth = 5;
		gbc_txtLucro.insets = new Insets(0, 0, 5, 0);
		gbc_txtLucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLucro.gridx = 1;
		gbc_txtLucro.gridy = 6;
		add(txtLucro, gbc_txtLucro);
		txtLucro.setColumns(10);
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.gridwidth = 2;
		gbc_btnSalvar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalvar.gridx = 0;
		gbc_btnSalvar.gridy = 7;
		add(btnSalvar, gbc_btnSalvar);
		
		JButton btnNewButton = new JButton("Alterar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 7;
		add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Excluir");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 7;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 8;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable(model2);
		scrollPane.setViewportView(table);

	}
}
