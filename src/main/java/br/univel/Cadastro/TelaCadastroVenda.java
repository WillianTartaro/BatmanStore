package br.univel.Cadastro;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaCadastroVenda extends MolduraCadastroVenda {

	/**
	 * Create the panel.
	 */
	public TelaCadastroVenda() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new AbaCadastroVenda(), BorderLayout.CENTER);
	}


}
