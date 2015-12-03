package br.univel.Cadastro;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaRelatorioCliente extends MolduraCadastro {

	/**
	 * Create the panel.
	 */
	public TelaRelatorioCliente() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new AbaRelatorioCliente(), BorderLayout.CENTER);
	}

}
