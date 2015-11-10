package br.univel.Cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.Usuario;

public class TableModelUsuario extends AbstractTableModel {

private List<Usuario> lista3 = new ArrayList<Usuario>();

	
	public List<Usuario> getLista3() {
	return lista3;
}

public void setLista3(List<Usuario> lista3) {
	this.lista3 = lista3;
	this.fireTableDataChanged();
}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista3.size();
	}
	
	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Id Usuario";
		case 1:
			return "Id Cliente";
		case 2:
			return "Senha";
		}
		return "erro";
	}

	@Override
	public Object getValueAt(int row, int col) {
		Usuario u = lista3.get(row);
		switch (col) {
		case 0:
			return u.getId();
		case 1:
			return u.getIdc();
		case 2:
			return u.getSenha();
		}
		return "erro";
		
		
	}
	public void adicionarNoModel(Usuario u) {
	this.lista3.add(u);
	int row = this.lista3.size() -1;
	
	super.fireTableDataChanged();
	
	}
	
}

	


