//package.mvc;
import java.awt.event.*;
import javax.swing.*;
//import java.awt.*;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.event.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.io.*;
import java.nio.*;
import java.util.*;
public class TableGUI extends JFrame{
	JPanel panel;
	public TableGUI(){

		initUI();
	
	}

	public void initUI(){
		String columns[] = {
			"ano",
			"capacidade",
			"placa"
		};

		Object rows[][] = new Object[4][3];
		rows[0][0] = "2016";
		rows[0][1] = "280";
		rows[0][2] = "AAA-1111";
		rows[1][0] = "2014";
		rows[1][1] = "260";
		rows[1][2] = "BBB-1111";
		rows[2][0] = "2013";
		rows[2][1] = "265";
		rows[2][2] = "CCC-1111";
		rows[3][0] = "2004";
		rows[3][1] = "277";
		rows[3][2] = "DDD-1111";
		panel = new TablePanel(rows,columns);
		
		//
		setContentPane(panel);
		pack();
		setTitle("Exemplo de Tabela");
		setResizable(false);
		setSize(500,300);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new TableGUI();

			}
		});
	}







}