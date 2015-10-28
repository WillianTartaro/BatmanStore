package br.univel.Cadastro;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaCadastroUsuario extends MolduraCadastroUsuario {

	/**
	 * Create the panel.
	 */
	public TelaCadastroUsuario() {
		super();
	}

	@Override
	protected void configuraMiolo() {

		super.add(new AbaCadastroUsuario(), BorderLayout.CENTER);
		
	}

}
