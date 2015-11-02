package br.univel.Cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.Produto;


public class TableModelProduto extends AbstractTableModel {

private List<Produto> lista2 = new ArrayList<Produto>();

	
	public List<Produto> getLista2() {
	return lista2;
}

public void setLista2(List<Produto> lista2) {
	this.lista2 = lista2;
	this.fireTableDataChanged();
}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista2.size();
	}
	
	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Codigo";
		case 2:
			return "Categoria";
		case 3:
			return "Descrição";
		case 4:
			return "Unidade";
		case 5:
			return "Custo";
		case 6:
			return "Margem de Lucro";
		}
		return "erro";
	}

	@Override
	public Object getValueAt(int row, int col) {
		Produto p = lista2.get(row);
		switch (col) {
		case 0:
			return p.getId();
		case 1:
			return p.getCodigo();
		case 2:
			return p.getCategoria();
		case 3:
			return p.getDescricao();
		case 4:
			return p.getUnidade();
		case 5:
			return p.getCusto();
		case 6:
			return p.getMargemLucro();
		}
		return "erro";
		
		
	}
	public void adicionarNoModel(Produto p) {
	this.lista2.add(p);
	int row = this.lista2.size() -1;
	
	super.fireTableDataChanged();
	
	}
	
}
