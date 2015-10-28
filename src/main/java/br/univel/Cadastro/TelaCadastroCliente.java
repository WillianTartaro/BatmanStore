package br.univel.Cadastro;

import java.awt.BorderLayout;

import javax.swing.JPanel;


public class TelaCadastroCliente extends MolduraCadastro {

	/**
	 * Create the panel.
	 */
	public TelaCadastroCliente() {
		super();

	}

	@Override
	protected void configuraMiolo() {
		super.add(new AbaCadastroCliente(), BorderLayout.CENTER);
	}

}
