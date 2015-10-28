package br.univel.Cadastro;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaCadastroProduto extends MolduraCadastroProduto {

	/**
	 * Create the panel.
	 */
	public TelaCadastroProduto() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new AbaCadastroProduto(), BorderLayout.CENTER);
	}

}
