/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.Class;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author omendez
 */
public class InterfazPrincipal extends javax.swing.JFrame {

	/**
	 * Creacion de todas las variables utilizadas en la interfaz
	 */
	private JFrame frame;
	private JTable table;
	private JTextField name;
	private JTextField carne;
	private JLabel matriculaL;
	private JLabel precioCursoL;
	private JLabel subtotalL;
	private JLabel descuentoL;
	private JLabel ivaL;
	private JLabel recargoL ;

	JComboBox cantidadMaterias;
	private int precioVirtualMatri=87000;
	private int precioVirtualMateri=110000;
	private int precioPresenMatri=150000;
	private int precioPresenMateri=125000;
	private int precioLaborMatri=150000;
	private int precioLaborMateri=250000;
	private String value;
	private int valueInt; 
	private String value2;
	private int subtotal;
	private double descuento=0.30;
	private String descuentotabla;
	private double ivatabla;
	private double recargo;
	private String total;
	Object[] row ;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public InterfazPrincipal() {
		initialize();
	}
	/**
	 * Funciones llamadas por los botones para realizar los calculos segun sea
	 * virtual,presencial o laboratorio
	 */
	public void calculoVirtual(ActionEvent e) {
		Object item = this.cantidadMaterias.getSelectedItem();


		value =((ComboItem)item).getValue();
		valueInt= Integer.parseInt(value);

	}

	/**
	 * Inicializa la interfaz grafica y crea todos sus componentes
	 */
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
		
		JLabel lblNewLabel = new JLabel("Nombre Completo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(33, 91, 190, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de Carnet:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(33, 116, 176, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad de Materias");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBounds(33, 141, 190, 14);
		panel.add(lblNewLabel_2);
		
		
		
		JButton calcular = new JButton("Calcular");
		calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if(value2.equals("Virtual")) {
					calculoVirtual(e);	
				}
			}

			
		});
		calcular.setBounds(101, 312, 89, 23);
		panel.add(calcular);
		/**
		 * Boton que agrega los datos a la tabla segun sea virtual,presencial o laboratorio
		 */
		JButton agregar = new JButton("Agregar");
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object item = cantidadMaterias.getSelectedItem();

	
				value =((ComboItem)item).getValue();
				valueInt= Integer.parseInt(value);
				if(value2.equals("Virtual")) {

					value =((ComboItem)item).getValue();
					valueInt= Integer.parseInt(value);
					subtotal=  precioVirtualMateri*valueInt +precioVirtualMatri;
					
					row[1]=name.getText();
					row[0]=carne.getText();
					row[2]=valueInt;
					row[3]=value2;
					row[4]=precioVirtualMatri;
					row[5]=precioVirtualMateri;
					row[6]=subtotal;
					row[7]=Double.toString(subtotal*descuento);
					row[8]=Double.toString(subtotal*0.13);
					row[9]=0;
					row[10]=Double.toString(subtotal*0.13+subtotal-subtotal*descuento);
					model.addRow(row);
				}
				
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
		 * Boton que modifica los datos a la tabla segun sea virtual,presencial o laboratorio
		 */
		JButton Modificar = new JButton("Modificar");
		Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i= table.getSelectedRow();
				Object item =cantidadMaterias.getSelectedItem();
				value =((ComboItem)item).getValue();
				valueInt= Integer.parseInt(value);

				
				if(value2.equals("Virtual")) {
					subtotal=precioVirtualMateri*valueInt +precioVirtualMatri;
					descuentotabla=Double.toString(subtotal*descuento);
					total=Double.toString(subtotal*0.13+subtotal-subtotal*descuento);
					ivatabla=subtotal*0.13;
					recargo=0;
					model.setValueAt(carne.getText(), i, 0);
					model.setValueAt(name.getText(), i, 1);
					model.setValueAt(value, i, 2);
					model.setValueAt(value2, i, 3);
					model.setValueAt(precioVirtualMatri, i, 4);
					model.setValueAt(precioVirtualMateri, i, 5);
					model.setValueAt(subtotal, i, 6);
					model.setValueAt(descuentotabla, i, 7);
					model.setValueAt(ivatabla, i, 8);
					model.setValueAt(recargo, i, 9);
					model.setValueAt(total, i, 10);
				}else if(value2.equals("Presencial")) {
					subtotal=precioPresenMateri*valueInt +precioPresenMatri;
					descuentotabla=Double.toString(subtotal*descuento);
					total=Double.toString(subtotal*0.13+subtotal);
					ivatabla=subtotal*0.13;
					recargo=0;
					model.setValueAt(carne.getText(), i, 0);
					model.setValueAt(name.getText(), i, 1);
					model.setValueAt(value, i, 2);
					model.setValueAt(value2, i, 3);
					model.setValueAt(precioPresenMatri, i, 4);
					model.setValueAt(precioPresenMateri, i, 5);
					model.setValueAt(subtotal, i, 6);
					model.setValueAt(0, i, 7);
					model.setValueAt(ivatabla, i, 8);
					model.setValueAt(recargo, i, 9);
					model.setValueAt(total, i, 10);
				}else if(value2.equals("Laboratorio")) {
					subtotal=precioLaborMateri*valueInt +precioLaborMatri;
					descuentotabla=Double.toString(subtotal*descuento);
					total=Double.toString(subtotal*0.13+subtotal+precioLaborMateri*valueInt*0.40);;
					ivatabla=subtotal*0.13;
					recargo=precioLaborMateri*valueInt*0.40;;
					model.setValueAt(carne.getText(), i, 0);
					model.setValueAt(name.getText(), i, 1);
					model.setValueAt(value, i, 2);
					model.setValueAt(value2, i, 3);
					model.setValueAt(precioLaborMatri, i, 4);
					model.setValueAt(precioLaborMateri, i, 5);
					model.setValueAt(subtotal, i, 6);
					model.setValueAt(0, i, 7);
					model.setValueAt(ivatabla, i, 8);
					model.setValueAt(recargo, i, 9);
					model.setValueAt(total, i, 10);
				}
				
				
			}
		});
		Modificar.setBounds(443, 358, 89, 23);
		panel.add(Modificar);
		
		JButton limpiar = new JButton("Limpiar");
		limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				carne.setText("");
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
		Object[] column = {"Carnet","Nombre Completo","Cant.Materias","Modalidad"
				,"Matricula","Precio","Subtotal","Descuento","IVA","Recargo","Total"};
		row = new Object[11];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		name = new JTextField();
		name.setBounds(224, 91, 214, 20);
		panel.add(name);
		name.setColumns(10);
		
		carne = new JTextField();
		carne.setColumns(10);
		carne.setBounds(224, 116, 214, 20);
		panel.add(carne);
		
		cantidadMaterias = new JComboBox();
		cantidadMaterias.setBounds(224, 140, 46, 22);
		panel.add(cantidadMaterias);
		cantidadMaterias.addItem(new ComboItem("1","1"));
		cantidadMaterias.addItem(new ComboItem("2","2"));
		cantidadMaterias.addItem(new ComboItem("3","3"));
		cantidadMaterias.addItem(new ComboItem("4","4"));
		cantidadMaterias.addItem(new ComboItem("5","5"));
		
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

	protected void testeolabel(ActionEvent e) {
		matriculaL.setText("SIRVE");
		
	}
}
