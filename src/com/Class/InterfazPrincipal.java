
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
import javax.swing.JOptionPane;
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
	private JLabel descuentoL;
	private JLabel ivaL;
	private JLabel recargoL;
	JComboBox cantidadMaterias;
	private String value;
	private int valueInt;
	private char[] array;
	int aumentar = 0;
	private static int potencia = 0;
	Object[] row;
	Object[] rowTablaFea;
	DefaultTableModel model;
	DefaultTableModel model1;
	private JTable table_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPrincipal window = new InterfazPrincipal();
					window.frame.setResizable(false);
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

	private void cambiarBit(int i) {
		if (i > 16) {
			JOptionPane.showMessageDialog(null, "Posicion incorrecta");
		} else {
			if (Info2HammingCode.finalCode.charAt(i) == '0') {
				Info2HammingCode.finalCode.setCharAt(i, '1');
			} else if (Info2HammingCode.finalCode.charAt(i) == '1') {
				Info2HammingCode.finalCode.setCharAt(i, '0');
			}
		}
		createTableAlter();

	}

	private void sumarValores() {
		int sumatoria=0;
		for (int i = 0; i < 16; i++) {
			if(model1.getValueAt(1, i)!= null) {
				sumatoria+= Character.getNumericValue((char) model1.getValueAt(1, i));
			}
			
		}
		System.out.println(sumatoria);

	}
	

	private void createTableAlter() {

		model1.setValueAt(Info2HammingCode.finalCode.charAt(0), 0, 0);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(2), 0, 2);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(4), 0, 4);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(6), 0, 6);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(8), 0, 8);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(10), 0, 10);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(12), 0, 12);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(14), 0, 14);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(16), 0, 16);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(1), 0, 1);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(3), 0, 3);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(5), 0, 5);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(7), 0, 7);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(9), 0, 9);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(11), 0, 11);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(13), 0, 13);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(15), 0, 15);

		model1.setValueAt(Info2HammingCode.finalCode.charAt(0), 1, 0);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(2), 1, 2);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(4), 1, 4);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(6), 1, 6);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(8), 1, 8);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(10), 1, 10);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(12), 1, 12);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(14), 1, 14);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(16), 1, 16);

		model1.setValueAt(Info2HammingCode.finalCode.charAt(1), 2, 1);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(2), 2, 2);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(5), 2, 5);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(6), 2, 6);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(9), 2, 9);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(10), 2, 10);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(13), 2, 13);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(14), 2, 14);

		model1.setValueAt(Info2HammingCode.finalCode.charAt(3), 3, 3);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(4), 3, 4);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(5), 3, 5);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(6), 3, 6);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(11), 3, 11);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(12), 3, 12);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(13), 3, 13);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(14), 3, 14);

		model1.setValueAt(Info2HammingCode.finalCode.charAt(7), 4, 7);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(8), 4, 8);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(9), 4, 9);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(10), 4, 10);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(11), 4, 11);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(12), 4, 12);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(13), 4, 13);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(14), 4, 14);

		model1.setValueAt(Info2HammingCode.finalCode.charAt(15), 5, 15);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(16), 5, 16);

		model1.setValueAt(Info2HammingCode.finalCode.charAt(0), 6, 0);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(2), 6, 2);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(4), 6, 4);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(6), 6, 6);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(8), 6, 8);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(10), 6, 10);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(12), 6, 12);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(14), 6, 14);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(16), 6, 16);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(1), 6, 1);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(3), 6, 3);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(5), 6, 5);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(7), 6, 7);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(9), 6, 9);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(11), 6, 11);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(13), 6, 13);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(15), 6, 15);

	}

	private void createTable() {
		model.setValueAt(Info2HammingCode.finalCode.charAt(0), 1, 0);
		model.setValueAt(Info2HammingCode.finalCode.charAt(2), 1, 2);
		model.setValueAt(Info2HammingCode.finalCode.charAt(4), 1, 4);
		model.setValueAt(Info2HammingCode.finalCode.charAt(6), 1, 6);
		model.setValueAt(Info2HammingCode.finalCode.charAt(8), 1, 8);
		model.setValueAt(Info2HammingCode.finalCode.charAt(10), 1, 10);
		model.setValueAt(Info2HammingCode.finalCode.charAt(12), 1, 12);
		model.setValueAt(Info2HammingCode.finalCode.charAt(14), 1, 14);
		model.setValueAt(Info2HammingCode.finalCode.charAt(16), 1, 16);

		model.setValueAt(Info2HammingCode.finalCode.charAt(1), 2, 1);
		model.setValueAt(Info2HammingCode.finalCode.charAt(2), 2, 2);
		model.setValueAt(Info2HammingCode.finalCode.charAt(5), 2, 5);
		model.setValueAt(Info2HammingCode.finalCode.charAt(6), 2, 6);
		model.setValueAt(Info2HammingCode.finalCode.charAt(9), 2, 9);
		model.setValueAt(Info2HammingCode.finalCode.charAt(10), 2, 10);
		model.setValueAt(Info2HammingCode.finalCode.charAt(13), 2, 13);
		model.setValueAt(Info2HammingCode.finalCode.charAt(14), 2, 14);

		model.setValueAt(Info2HammingCode.finalCode.charAt(3), 3, 3);
		model.setValueAt(Info2HammingCode.finalCode.charAt(4), 3, 4);
		model.setValueAt(Info2HammingCode.finalCode.charAt(5), 3, 5);
		model.setValueAt(Info2HammingCode.finalCode.charAt(6), 3, 6);
		model.setValueAt(Info2HammingCode.finalCode.charAt(11), 3, 11);
		model.setValueAt(Info2HammingCode.finalCode.charAt(12), 3, 12);
		model.setValueAt(Info2HammingCode.finalCode.charAt(13), 3, 13);
		model.setValueAt(Info2HammingCode.finalCode.charAt(14), 3, 14);

		model.setValueAt(Info2HammingCode.finalCode.charAt(7), 4, 7);
		model.setValueAt(Info2HammingCode.finalCode.charAt(8), 4, 8);
		model.setValueAt(Info2HammingCode.finalCode.charAt(9), 4, 9);
		model.setValueAt(Info2HammingCode.finalCode.charAt(10), 4, 10);
		model.setValueAt(Info2HammingCode.finalCode.charAt(11), 4, 11);
		model.setValueAt(Info2HammingCode.finalCode.charAt(12), 4, 12);
		model.setValueAt(Info2HammingCode.finalCode.charAt(13), 4, 13);
		model.setValueAt(Info2HammingCode.finalCode.charAt(14), 4, 14);

		model.setValueAt(Info2HammingCode.finalCode.charAt(15), 5, 15);
		model.setValueAt(Info2HammingCode.finalCode.charAt(16), 5, 16);

		model.setValueAt(Info2HammingCode.finalCode.charAt(0), 6, 0);
		model.setValueAt(Info2HammingCode.finalCode.charAt(2), 6, 2);
		model.setValueAt(Info2HammingCode.finalCode.charAt(4), 6, 4);
		model.setValueAt(Info2HammingCode.finalCode.charAt(6), 6, 6);
		model.setValueAt(Info2HammingCode.finalCode.charAt(8), 6, 8);
		model.setValueAt(Info2HammingCode.finalCode.charAt(10), 6, 10);
		model.setValueAt(Info2HammingCode.finalCode.charAt(12), 6, 12);
		model.setValueAt(Info2HammingCode.finalCode.charAt(14), 6, 14);
		model.setValueAt(Info2HammingCode.finalCode.charAt(16), 6, 16);
		model.setValueAt(Info2HammingCode.finalCode.charAt(1), 6, 1);
		model.setValueAt(Info2HammingCode.finalCode.charAt(3), 6, 3);
		model.setValueAt(Info2HammingCode.finalCode.charAt(5), 6, 5);
		model.setValueAt(Info2HammingCode.finalCode.charAt(7), 6, 7);
		model.setValueAt(Info2HammingCode.finalCode.charAt(9), 6, 9);
		model.setValueAt(Info2HammingCode.finalCode.charAt(11), 6, 11);
		model.setValueAt(Info2HammingCode.finalCode.charAt(13), 6, 13);
		model.setValueAt(Info2HammingCode.finalCode.charAt(15), 6, 15);

//-----------------------------------------------------------------------------

		model1.setValueAt(Info2HammingCode.finalCode.charAt(0), 0, 0);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(2), 0, 2);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(4), 0, 4);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(6), 0, 6);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(8), 0, 8);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(10), 0, 10);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(12), 0, 12);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(14), 0, 14);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(16), 0, 16);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(1), 0, 1);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(3), 0, 3);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(5), 0, 5);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(7), 0, 7);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(9), 0, 9);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(11), 0, 11);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(13), 0, 13);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(15), 0, 15);

		model1.setValueAt(Info2HammingCode.finalCode.charAt(0), 1, 0);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(2), 1, 2);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(4), 1, 4);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(6), 1, 6);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(8), 1, 8);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(10), 1, 10);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(12), 1, 12);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(14), 1, 14);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(16), 1, 16);

		model1.setValueAt(Info2HammingCode.finalCode.charAt(1), 2, 1);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(2), 2, 2);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(5), 2, 5);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(6), 2, 6);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(9), 2, 9);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(10), 2, 10);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(13), 2, 13);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(14), 2, 14);

		model1.setValueAt(Info2HammingCode.finalCode.charAt(3), 3, 3);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(4), 3, 4);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(5), 3, 5);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(6), 3, 6);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(11), 3, 11);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(12), 3, 12);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(13), 3, 13);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(14), 3, 14);

		model1.setValueAt(Info2HammingCode.finalCode.charAt(7), 4, 7);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(8), 4, 8);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(9), 4, 9);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(10), 4, 10);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(11), 4, 11);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(12), 4, 12);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(13), 4, 13);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(14), 4, 14);

		model1.setValueAt(Info2HammingCode.finalCode.charAt(15), 5, 15);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(16), 5, 16);

		model1.setValueAt(Info2HammingCode.finalCode.charAt(0), 6, 0);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(2), 6, 2);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(4), 6, 4);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(6), 6, 6);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(8), 6, 8);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(10), 6, 10);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(12), 6, 12);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(14), 6, 14);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(16), 6, 16);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(1), 6, 1);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(3), 6, 3);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(5), 6, 5);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(7), 6, 7);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(9), 6, 9);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(11), 6, 11);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(13), 6, 13);
		model1.setValueAt(Info2HammingCode.finalCode.charAt(15), 6, 15);

	}

	public static char getCharFromString(String str, int index) {
		return str.charAt(index);
	}

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 978, 803);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 962, 780);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Numero Hamming:");
		lblNewLabel.setBounds(33, 116, 190, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Numero Hexadecimal:");
		lblNewLabel_1.setBounds(33, 91, 190, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Paridad:");
		lblNewLabel_2.setBounds(33, 141, 190, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblNewLabel_2);

		Hamming hamming1 = new Hamming();

		JButton calcularHamming = new JButton("Calcular");
		calcularHamming.setBounds(101, 312, 89, 23);
		calcularHamming.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String numero = hammingNumber.getText();
				Object item = cantidadMaterias.getSelectedItem();

				value = ((ComboItem) item).getValue();
				valueInt = Integer.parseInt(value);
				HammingCodeTools.info2HammingCode(numero, valueInt);

				int bitsNeeded = 0, m = numero.length();

				array = new char[m];
				int q = 0;
				while (numero.length() > q) {
					array[q] = numero.charAt(q);

					q++;
				}

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
					if (row[w] == null) {
						row[w] = array[v];

						v++;
					}
				}

				model.addRow(row);
				Object[] row2 = new Object[20];
				row = row2;

				System.out.println(Info2HammingCode.finalCode);

				for (int w = 0; w <= 6; w++) {
					Object[] rowGenerica = new Object[17];
					Object[] rowL = new Object[17];
					model1.addRow(rowL);
					model.addRow(rowGenerica);
				}
				createTable();

			}
		});
		panel.add(calcularHamming);

		JButton agregar = new JButton("Agregar");
		agregar.setBounds(101, 358, 89, 23);
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		panel.add(agregar);

		JButton eliminar = new JButton("Eliminar");
		eliminar.setBounds(446, 358, 89, 23);
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
			}
		});
		panel.add(eliminar);
		JButton Modificar = new JButton("Modificar");
		Modificar.setBounds(446, 312, 89, 23);
		Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarBit(Integer.parseInt(hammingNumber.getText()));
				sumarValores();

			}
		});
		panel.add(Modificar);

		JButton limpiar = new JButton("Limpiar");
		limpiar.setBounds(863, 11, 89, 23);
		limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				model1.setRowCount(0);

			}
		});
		panel.add(limpiar);

		// OSCAR
		JLabel lblNewLabel_3 = new JLabel("Decimal");
		lblNewLabel_3.setBounds(560, 91, 146, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Binario");
		lblNewLabel_4.setBounds(560, 116, 146, 14);
		panel.add(lblNewLabel_4);

		JLabel lblDecimal = new JLabel("0");
		lblDecimal.setBounds(751, 91, 181, 14);
		panel.add(lblDecimal);

		JLabel lblBinario = new JLabel("0");
		lblBinario.setBounds(751, 116, 166, 14);
		panel.add(lblBinario);

		JLabel lblNewLabel_7 = new JLabel("Octal");
		lblNewLabel_7.setBounds(560, 144, 146, 14);
		panel.add(lblNewLabel_7);

		JLabel lblOctal = new JLabel("0");
		lblOctal.setBounds(751, 144, 166, 14);
		panel.add(lblOctal);

		JButton nrziButton = new JButton("NRZI");
		nrziButton.setBounds(788, 312, 89, 23);
		nrziButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblBinario.getText().equals("0")) {
					JOptionPane.showMessageDialog(null, "Ingrese un numero a convertir primero");
				} else {
					NRZI nrzi = new NRZI(lblBinario.getText());
					nrzi.setVisible(true);
				}

			}
		});
		panel.add(nrziButton);

		JButton convertir = new JButton("Convertir");
		convertir.setBounds(788, 358, 89, 23);
		convertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conversiones conversion = new Conversiones(name.getText());
				lblDecimal.setText(Integer.toString(conversion.getDecimal()));
				lblOctal.setText(conversion.getOctal());
				lblBinario.setText(conversion.getBinario());

			}
		});
		panel.add(convertir);

		// FIN OSCAR
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 412, 899, 145);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		Object[] column = { "P1", "P2", "D1", "P3", "D2", "D3", "D4", "P4", "D5", "D6", "D7", "D8", "D9", "D10", "D11",
				"P5", "D12" };
		row = new Object[20];
		rowTablaFea = new Object[20];
		model.setColumnIdentifiers(column);
		table.setModel(model);

		name = new JTextField();
		name.setBounds(267, 91, 214, 20);
		panel.add(name);
		name.setColumns(10);

		hammingNumber = new JTextField();
		hammingNumber.setBounds(267, 116, 214, 20);
		hammingNumber.setColumns(10);
		panel.add(hammingNumber);

		cantidadMaterias = new JComboBox();
		cantidadMaterias.setBounds(267, 140, 74, 22);
		panel.add(cantidadMaterias);
		cantidadMaterias.addItem(new ComboItem("Impar", "1"));
		cantidadMaterias.addItem(new ComboItem("Par", "2"));

		descuentoL = new JLabel("");
		descuentoL.setBounds(764, 169, 74, 23);
		panel.add(descuentoL);

		ivaL = new JLabel("");
		ivaL.setBounds(764, 193, 74, 23);
		panel.add(ivaL);

		recargoL = new JLabel("");
		recargoL.setBounds(764, 218, 74, 23);
		panel.add(recargoL);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(33, 568, 899, 145);
		panel.add(scrollPane_1);

		Object[] column2 = { "P1", "P2", "D1", "P3", "D2", "D3", "D4", "P4", "D5", "D6", "D7", "D8", "D9", "D10", "D11",
				"P5", "D12", "Paridad", "Error" };
		table_1 = new JTable();
		model1 = new DefaultTableModel();
		model1.setColumnIdentifiers(column2);
		table_1.setModel(model1);
		scrollPane_1.setViewportView(table_1);

	}
}
