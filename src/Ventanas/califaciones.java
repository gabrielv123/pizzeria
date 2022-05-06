package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SortOrder;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class califaciones extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private JTextField txtCalifaciones;
	private JScrollPane scrollPane;
	private JButton btnActualizar;
	private JButton btnBorrar;
	private JButton btnInsertar;
	private JButton btnSalir;
	private JTable tabla;
	private Vector<String> columnas = new Vector<String>();
	private DefaultTableModel dtmTabla;
	private Vector<Vector<String>> datosTabla = new Vector<Vector<String>>();
	private TableRowSorter<DefaultTableModel> metodoOrdenacion = new TableRowSorter<>(dtmTabla);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					califaciones window = new califaciones();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public califaciones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtCalifaciones = new JTextField();
		txtCalifaciones.setHorizontalAlignment(SwingConstants.CENTER);
		txtCalifaciones.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtCalifaciones.setText("Calificaciones");
		txtCalifaciones.setBounds(0, 0, 436, 19);
		frame.getContentPane().add(txtCalifaciones);
		txtCalifaciones.setColumns(10);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(0, 232, 85, 21);
		frame.getContentPane().add(btnSalir);
		btnSalir.addActionListener(this);

		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(111, 232, 85, 21);
		frame.getContentPane().add(btnInsertar);
		btnInsertar.addActionListener(this);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(224, 232, 85, 21);
		frame.getContentPane().add(btnBorrar);
		btnBorrar.addActionListener(this);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(341, 232, 85, 21);
		frame.getContentPane().add(btnActualizar);
		btnActualizar.addActionListener(this);

		try {

			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");

			System.out.println("Conexión Correcta.");

			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM calificaciones;");

			ResultSetMetaData metaDatos = rs.getMetaData();
			int numeroColumnas = metaDatos.getColumnCount();

			for (int i = 0; i < numeroColumnas; i++) {

				columnas.add(metaDatos.getColumnLabel(i + 1));

			}

			while (rs.next()) {

				Vector<String> fila = new Vector<String>();

				fila.add(rs.getString("dni"));
				fila.add(rs.getString("codasignatura"));
				fila.add(rs.getString("nota"));
				fila.add("\n\n\n\n\n\n\n");
				datosTabla.add(fila);

			}

		} catch (SQLException e) {

			// JOptionPane.showMessageDialog(scrollPane, e.getMessage());

		}

		dtmTabla = new DefaultTableModel(datosTabla, columnas);
		tabla = new JTable(dtmTabla);

		scrollPane = new JScrollPane(tabla);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 19, 436, 223);
		frame.getContentPane().add(scrollPane);

		scrollPane.setViewportView(tabla);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 17, 436, 205);
		frame.getContentPane().add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub



		Connection conexion;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");

			System.out.println("Conexión Correcta.");

			Statement borrar = conexion.createStatement();
			Statement insertar = conexion.createStatement();
			Statement actualizar = conexion.createStatement();

			int selectedRow = tabla.getSelectedRow();

			if (e.getSource() == btnSalir) {

				System.exit(0);

			}

			if (e.getSource() == btnInsertar) {

				Vector<String> fila = new Vector<String>();

				insertar.executeUpdate("INSERT INTO calificaciones VALUES ('0000003', 'BD', 1);");

				fila.add("0000003");
				fila.add("BD");
				fila.add("1");
				fila.add("\n\n\n\n\n\n\n");
				this.dtmTabla.addRow(fila);

			}

			if (e.getSource() == btnBorrar) {

				String selectedRowvalor = (String) tabla.getValueAt(selectedRow, 0);
				borrar.executeUpdate("DELETE FROM calificaciones WHERE dni='" + selectedRowvalor + "'");
				this.dtmTabla.removeRow(selectedRow);
			}

			if (e.getSource() == btnActualizar) {

				String selectedRowvalor = (String) tabla.getValueAt(selectedRow, 0);
				actualizar.executeUpdate("UPDATE calificaciones SET nota=2 WHERE dni='" + selectedRowvalor + "'");
				this.dtmTabla.setValueAt(2, selectedRow, 2);

			}

		} catch (SQLException e1) {

			System.out.println(e1.getMessage());

		}
	}

}
