
package com.Class;

import java.awt.Color;
import com.Class.HammingCodeTools;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.Class.tools.*;

public class InterfazPrincipal extends javax.swing.JFrame {

	private JFrame frame;
	private JTable table;
	private JTextField name;
	private JTextField hammingNumber;
	private JLabel matriculaL;
	private JLabel precioCursoL;
	private JLabel subtotalL;
	private JLabel descuentoL;
	private JLabel ivaL;
	private JLabel recargoL;
	JComboBox cantidadMaterias;
	private String value;
	private int valueInt;
	private String value2;
	private int subtotal;

	private double descuento = 0.30;
	private String descuentotabla;
	private double ivatabla;
	private double recargo;
	private String total;

	private int[] array;
	Object[] row;
	DefaultTableModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPrincipal window = new InterfazPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfazPrincipal() {
		initialize();
	}

	public void calculoVirtual(ActionEvent e) {
		Object item = this.cantidadMaterias.getSelectedItem();
	}

	int getDigitCount(int num) {
		int c = 0;
		while (num > 0) {
			num /= 10;
			c++;
		}
		return c;
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 978, 664);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 962, 625);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Numero Hamming:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(33, 116, 190, 20);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Numero Hexadecimal:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(33, 91, 190, 20);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Paridad:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBounds(33, 141, 190, 14);
		panel.add(lblNewLabel_2);

		Hamming hamming1 = new Hamming();

		JButton calcularHamming = new JButton("Calcular");
		calcularHamming.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = hammingNumber.getText();
				
				Object item = cantidadMaterias.getSelectedItem();
				value = ((ComboItem) item).getValue();
				valueInt = Integer.parseInt(value);
				HammingCodeTools.info2HammingCode(numero, valueInt);
				int bitsNeeded = 0, m = hammingNumber.getText().length();
				long numero_aux = Long.parseLong(numero);
				
				LinkedList<Integer> stack = new LinkedList<Integer>();
				array = new int[m];
				while (numero_aux > 0) {
					stack.push((int) (numero_aux % 10));
					numero_aux = numero_aux / 10;
				}
				int x = 0;
				while ((!stack.isEmpty())) {
					array[x] = stack.pop();
					x++;
				}
				System.out.println(Arrays.toString(array));
				while (true) {
					if (m + bitsNeeded + 1 <= Math.pow(2, bitsNeeded)) {
						break;
					}
					bitsNeeded++;
				}
				for (int i = 0; i <= bitsNeeded + m; i++) {
					if (i == 0) {
						row[0] = "Si";
					}
					for (int z = 0; z <= bitsNeeded; z++) {
						double w = Math.pow(2, z) - 1;
						int w2 = (int) w;
						if (i == w2) {
							row[i] = " ";
							break;
						}
					}
				}
				int v = 0;
				for (int w = 0; w < bitsNeeded + m; w++) {
						if(row[w]==null) {
							row[w]=array[v];
							v++;
						}
				}
				model.addRow(row);
				System.out.println(Info2HammingCode.finalCode);
				
				System.out.println(Arrays.toString(hamming1.value));
			}
		});

		calcularHamming.setBounds(101, 312, 89, 23);
		panel.add(calcularHamming);

		JButton agregar = new JButton("Agregar");
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		agregar.setBounds(101, 358, 89, 23);
		panel.add(agregar);

		JButton eliminar = new JButton("Eliminar");
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
			}
		});
		eliminar.setBounds(443, 312, 89, 23);
		panel.add(eliminar);

		/**
		 * Boton que modifica los datos a la tabla segun sea virtual,presencial o
		 * laboratorio
		 */
		JButton Modificar = new JButton("Modificar");
		Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				Object item = cantidadMaterias.getSelectedItem();
				value = ((ComboItem) item).getValue();
				valueInt = Integer.parseInt(value);

			

					model.setValueAt(hammingNumber.getText(), i, 0);
		

			}
		});
		Modificar.setBounds(443, 358, 89, 23);
		panel.add(Modificar);

		JButton limpiar = new JButton("Limpiar");
		limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				hammingNumber.setText("");
				matriculaL.setText("");
				subtotalL.setText("");
				ivaL.setText("");
				recargoL.setText("");
				descuentoL.setText("");
				precioCursoL.setText("");
			}
		});
		limpiar.setBounds(788, 312, 89, 23);
		panel.add(limpiar);

		JButton regresar = new JButton("Regresar");
		regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		regresar.setBounds(788, 358, 89, 23);
		panel.add(regresar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 412, 899, 202);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		Object[] column = { "P1", "P2", "D1", "P3", "D2", "D3", "D4", "P4", "D5", "D6", "D7","D8","D9","D10","D11","P5","D12"};
		row = new Object[20];
		model.setColumnIdentifiers(column);
		table.setModel(model);

		name = new JTextField();
		name.setBounds(267, 91, 214, 20);
		panel.add(name);
		name.setColumns(10);

		hammingNumber = new JTextField();
		hammingNumber.setColumns(10);
		hammingNumber.setBounds(267, 116, 214, 20);
		panel.add(hammingNumber);

		cantidadMaterias = new JComboBox();
		cantidadMaterias.setBounds(267, 140, 74, 22);
		panel.add(cantidadMaterias);
		cantidadMaterias.addItem(new ComboItem("Impar", "1"));
		cantidadMaterias.addItem(new ComboItem("Par", "2"));
		

		matriculaL = new JLabel();
		matriculaL.setBounds(764, 91, 67, 20);
		panel.add(matriculaL);

		precioCursoL = new JLabel("");
		precioCursoL.setBounds(764, 115, 74, 23);
		panel.add(precioCursoL);

		subtotalL = new JLabel("");
		subtotalL.setBounds(764, 144, 74, 23);
		panel.add(subtotalL);

		descuentoL = new JLabel("");
		descuentoL.setBounds(764, 169, 74, 23);
		panel.add(descuentoL);

		ivaL = new JLabel("");
		ivaL.setBounds(764, 193, 74, 23);
		panel.add(ivaL);

		recargoL = new JLabel("");
		recargoL.setBounds(764, 218, 74, 23);
		panel.add(recargoL);
	}

}
