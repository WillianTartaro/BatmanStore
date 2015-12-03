package br.univel.Cadastro;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.univel.BancoDeDados;
import br.univel.Cliente;
import br.univel.Estado;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Desktop;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AbaRelatorioCliente extends JPanel {
	
	private JComboBox comboBox;
	JComboBox comboBox_1;

	/**
	 * Create the panel.
	 */
	public AbaRelatorioCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 0;
		add(lblEstado, gbc_lblEstado);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		add(comboBox, gbc_comboBox);
		
		JLabel lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 1;
		add(lblCidade, gbc_lblCidade);
		
		try {
			BancoDeDados banco = new BancoDeDados();
			List<Cliente> cliente = banco.PuxarCidadeCliente();
			Vector<String> v = new Vector<String>();
			for (int i = 0; i < cliente.size(); i++) {
				v.add(cliente.get(i).getCidade());
				comboBox_1 = new JComboBox<>(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 1;
		add(comboBox_1, gbc_comboBox_1);

		Estado[] estados = Estado.values();
		ComboBoxModel estado = new DefaultComboBoxModel(estados);
		comboBox.setModel(estado);
		
		JButton btnGerar = new JButton("Gerar");
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				try {
					GerarPDF();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			private void GerarPDF() throws SQLException {
				final String OUT_PDF = "out.pdf";
				String arq = "C:\\Users\\Willian\\MyReports\\BatStore.jasper";
				

					TableModel tableModel = getTableModel();

					JasperPrint jp = null;
					try {

						Map<String, Object> map = new HashMap<String, Object>();
					

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
					 //banco.clienteTabela();
					String[] columnNames = { "Id", "Nome", "Telefone", "Email" };
				 
						String[][] data = { {banco.PuxarInfo().toString(), banco.PuxarInfoCliente().toString(), banco.PuxarInfoCliente2().toString(), banco.PuxarInfoCliente3().toString() } };

					return new DefaultTableModel(data, columnNames);
					
				}

			}
		);
		GridBagConstraints gbc_btnGerar = new GridBagConstraints();
		gbc_btnGerar.gridx = 1;
		gbc_btnGerar.gridy = 3;
		add(btnGerar, gbc_btnGerar);
		
	}
	

	

}
