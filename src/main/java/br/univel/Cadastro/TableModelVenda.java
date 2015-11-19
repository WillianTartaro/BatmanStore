package br.univel.Cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.Venda;

public class TableModelVenda extends AbstractTableModel {
	
private List<Venda> lista4 = new ArrayList<Venda>();

	
	public List<Venda> getLista4() {
	return lista4;
}

public void setLista4(List<Venda> lista4) {
	this.lista4 = lista4;
	this.fireTableDataChanged();
}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista4.size();
	}
	
	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Id Venda";
		case 1:
			return "Nome Cliente";
		case 2:
			return "Nome Produto";
		case 3:
			return "Quantidade";
		}
		return "erro";
	}

	@Override
	public Object getValueAt(int row, int col) {
		Venda v = lista4.get(row);
		switch (col) {
		case 0:
			return v.getIdvenda();
		case 1:
			return v.getNomeCliente();
		case 2:
			return v.getNomeProduto();
		case 3:
			return v.getQuantidade();
		}
		return "erro";
		
		
	}

}
