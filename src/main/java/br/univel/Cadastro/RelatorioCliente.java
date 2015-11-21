package br.univel.Cadastro;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.univel.BancoDeDados;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

public class RelatorioCliente {
	
	private static final String OUT_PDF = "out.pdf";
	private String arq = "C:\\Users\\Willian\\MyReports\\Wood.jasper";

		
	public RelatorioCliente() throws SQLException {
		

		TableModel tableModel = getTableModel();

		JasperPrint jp = null;
		try {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("empresa", "Petrobras");
			map.put("telefone", "123pim567pim");

			jp = JasperFillManager.fillReport(arq, map,
					new JRTableModelDataSource(tableModel));

			// JasperViewer jasperViewer = new JasperViewer(jp);
			//
			// jasperViewer.setBounds(50, 50, 320, 240);
			// jasperViewer.setLocationRelativeTo(null);
			// jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
			//
			// jasperViewer.setVisible(true);

			JasperExportManager.exportReportToPdfFile(jp, OUT_PDF);

			JOptionPane
					.showMessageDialog(
							null,
							"<html>Arquivo exportado para PDF!<br><br>A aplicação vai pedir"
							+ " ao Sistema operacional <br>para abrir com o visualizador"
							+ " padrão.");

			Desktop.getDesktop().open(new File(OUT_PDF));

		} catch (JRException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private TableModel getTableModel() throws SQLException {
		BancoDeDados banco = new BancoDeDados();
		banco.clienteTabela();
		String[] columnNames = { "Id", "Nome", "Telefone", "Email" };

		String[][] data = { { banco.PuxarInfo().toString(), banco.PuxarInfoCliente().toString(), banco.PuxarInfoCliente2().toString(), banco.PuxarInfoCliente3().toString() } };


		return new DefaultTableModel(data, columnNames);
	}
	}
