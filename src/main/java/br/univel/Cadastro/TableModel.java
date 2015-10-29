package br.univel.Cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.Cliente;

public class TableModel extends AbstractTableModel {
	
	private List<Cliente> lista = new ArrayList<Cliente>();
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Cliente c = lista.get(row);
		switch (col) {
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		case 2:
			return c.getTelefone();
		case 3:
			return c.getEndereco();
		case 4:
			return c.getCidade();
		case 5:
			return c.getEstado();
		case 6:
			return c.getEmail();
		case 7:
			return c.getGenero();
		}
		return "erro";
		
		
	}
	
	

}
