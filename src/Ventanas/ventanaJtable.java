package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SortOrder;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaJtable extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtAlumnos;
	private JTable tabla;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private Vector<String> columnas = new Vector<String>();
	private JScrollPane scrollPane;
	private DefaultTableModel dtmTabla;
	private JButton btnNewButton_3;

	private Vector<Vector<String>> datosTabla = new Vector<Vector<String>>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaJtable window = new ventanaJtable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public ventanaJtable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		Connection conexion;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");

			System.out.println("Conexión Correcta.");

			Statement borrar = conexion.createStatement();
			Statement insertar = conexion.createStatement();
			Statement actualizar = conexion.createStatement();
			
			String grupo ="1DW2";

			int selectedRow = tabla.getSelectedRow();

			if (e.getSource() == btnNewButton) {

				System.exit(0);

			}

			if (e.getSource() == btnNewButton_1) {

				Vector<String> fila = new Vector<String>();

				insertar.executeUpdate("INSERT INTO alumnos VALUES ('0000003', 'N0', 'A0', '1DW3');");

				fila.add("0000003");
				fila.add("N0");
				fila.add("A0");
				fila.add("1DW3");
				fila.add("\n\n\n\n\n\n\n");
				this.dtmTabla.addRow(fila);

			}

			if (e.getSource() == btnNewButton_2) {

				String selectedRowvalor = (String) tabla.getValueAt(selectedRow, 0);
				borrar.executeUpdate("DELETE FROM alumnos WHERE dni='" + selectedRowvalor + "'");
				this.dtmTabla.removeRow(selectedRow);
			}

			if (e.getSource() == btnNewButton_3) {
				
				String selectedRowvalor = (String) tabla.getValueAt(selectedRow, 0);
				actualizar.executeUpdate("UPDATE alumnos SET grupo='ADW2' WHERE dni='"+selectedRowvalor+"'");
				this.dtmTabla.setValueAt(grupo, selectedRow, 3);
				
			}

		} catch (SQLException e1) {
			
			System.out.println(e1.getMessage());
			
		}

	}

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnNewButton = new JButton("SALIR");
		btnNewButton.addActionListener(this);

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(0, 242, 123, 21);
		frame.getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("insertar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));

		btnNewButton_1.setBounds(327, 242, 109, 21);
		btnNewButton_1.addActionListener(this);

		frame.getContentPane().add(btnNewButton_1);

		txtAlumnos = new JTextField();
		txtAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		txtAlumnos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtAlumnos.setText("ALUMNOS");
		txtAlumnos.setBounds(0, 0, 436, 21);
		frame.getContentPane().add(txtAlumnos);
		txtAlumnos.setColumns(10);

		btnNewButton_2 = new JButton("borrar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));

		btnNewButton_2.setBounds(126, 242, 83, 21);

		btnNewButton_2.addActionListener(this);
		frame.getContentPane().add(btnNewButton_2);

		btnNewButton_3 = new JButton("actualuzar");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.setBounds(210, 242, 123, 21);
		btnNewButton_3.addActionListener(this);
		frame.getContentPane().add(btnNewButton_3);

		tabla = new JTable();

		try {

			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");

			System.out.println("Conexión Correcta.");

			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM alumnos;");

			// cabeceras de las columnas
			ResultSetMetaData metaDatos = rs.getMetaData();

			// Se obtiene el número de columnas.
			int numeroColumnas = metaDatos.getColumnCount();

			// Se obtiene cada una de las etiquetas para cada columna
			for (int i = 0; i < numeroColumnas; i++) {

				// cojo el valor de la etiqueta de la columna los índices del rs empiezan en 1
				// pero los índices de las columnas empiezan en 0
				columnas.add(metaDatos.getColumnLabel(i + 1));

			}

			if (rs.first()) {

				rs.beforeFirst();

				while (rs.next()) {

					Vector<String> fila = new Vector<String>();

					fila.add(rs.getString("dni"));
					fila.add(rs.getString("nombre"));
					fila.add(rs.getString("apellidos"));
					fila.add(rs.getString("grupo"));
					fila.add("\n\n\n\n\n\n\n");
					datosTabla.add(fila);

				}

			}

		} catch (SQLException e) {

			// JOptionPane.showMessageDialog(scrollPane, e.getMessage());

		}

		// creo la JTable
		dtmTabla = new DefaultTableModel(datosTabla, columnas);

		tabla = new JTable(dtmTabla);

		scrollPane = new JScrollPane(tabla);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 19, 436, 223);
		frame.getContentPane().add(scrollPane);

		scrollPane.setViewportView(tabla);

		// ordeno los datos de la tabla
		TableRowSorter<DefaultTableModel> metodoOrdenacion = new TableRowSorter<>(dtmTabla);
		tabla.setRowSorter(metodoOrdenacion);

		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		// para que ordene por la primera columna (dni en este caso) en Ascendente
		int columnIndexToSort = 2;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
		metodoOrdenacion.setSortKeys(sortKeys);
		metodoOrdenacion.sort();

	}
}