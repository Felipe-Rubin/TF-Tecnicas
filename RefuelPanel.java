import javax.swing.JPanel;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComponent;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.RowFilter;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.plaf.basic.*;
import java.awt.Image.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
public class RefuelPanel extends JPanel implements AutoEventListener{
	//tipo
	//data
	//odometro
	//qtidade litros
	//custo total
	//preco por litro
	private JButton register;
	private JButton clear;
	private JTextField data[]; //dia /mes /ano
	private JComboBox tipoCombustivel;
	private JTextField odometro;
	private JTextField qtLitros;
	private JTextField custoTotal;
	private JTextField precoLitro;
	private JCheckBox novaSerie;
	private Controller controller;
	private String placa;

	public RefuelPanel(Controller controller,String placa){
		super();
		this.controller = controller;
		this.placa = placa;
		controller.addListener(this);
		initUI();
	}

	@Override
	public void refuelAuto(RefuelEvent e){
		clearFields();
	}

	public void clearFields(){
		data[0].setText("");
		data[1].setText("");
		data[2].setText("");
		tipoCombustivel.setSelectedIndex(0);
		odometro.setText("");
		qtLitros.setText("");
		custoTotal.setText("");
		precoLitro.setText("");
		novaSerie.setSelected(false);
	}

	@Override
	public void addAuto(RegistrationEvent e){

	}
	@SuppressWarnings("unchecked")
	private void initUI(){
		setLayout(new BorderLayout());
		JPanel box = new JPanel();
		box.setLayout(new BoxLayout(box,BoxLayout.PAGE_AXIS));
		data = new JTextField[]{
			new JTextField(5),
			new JTextField(5),
			new JTextField(5)
		};
		tipoCombustivel = new JComboBox();
		tipoCombustivel.setModel(new DefaultComboBoxModel(Combustivel.values()));
		odometro = new JTextField(20);
		qtLitros = new JTextField(20);
		custoTotal = new JTextField(20);
		precoLitro = new JTextField(20);
		novaSerie = new JCheckBox();
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		dataPanel.add(new JLabel("Data"));
		dataPanel.add(data[0]);
		dataPanel.add(data[1]);
		dataPanel.add(data[2]);
		box.add(dataPanel);
		//
		JPanel tipoCombustivelPanel = new JPanel();
		tipoCombustivelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		tipoCombustivelPanel.add(new JLabel("Combustivel"));
		tipoCombustivelPanel.add(tipoCombustivel);
		box.add(tipoCombustivelPanel);

		JPanel op = new JPanel();
		op.setLayout(new FlowLayout(FlowLayout.LEFT));
		op.add(new JLabel("Odometro"));
		op.add(odometro);
		box.add(op);
		//
		JPanel qo = new JPanel();
		qo.setLayout(new FlowLayout(FlowLayout.LEFT));
		qo.add(new JLabel("Litros Abastecidos"));
		qo.add(qtLitros);
		box.add(qo);
		//
		JPanel co = new JPanel();
		co.setLayout(new FlowLayout(FlowLayout.LEFT));
		co.add(new JLabel("Custo Total"));
		co.add(custoTotal);
		box.add(co);
		//
		JPanel po = new JPanel();
		po.setLayout(new FlowLayout(FlowLayout.LEFT));
		po.add(new JLabel("Custo por Litro"));
		po.add(precoLitro);
		box.add(po);
		//
		JPanel no = new JPanel();
		no.setLayout(new FlowLayout(FlowLayout.LEFT));
		no.add(new JLabel("Nova Serie"));
		no.add(novaSerie);
		box.add(no);
		add(box,BorderLayout.WEST);
		JPanel btns = new JPanel();
		btns.setLayout(new GridLayout(0,2));
		register = new JButton("Register");
		register.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try{
				controller.addRefuel(
					placa,
					Integer.parseInt(data[0].getText()),
					Integer.parseInt(data[1].getText()),
					Integer.parseInt(data[2].getText()),
					Double.parseDouble(odometro.getText()),
					Double.parseDouble(qtLitros.getText()),
					Double.parseDouble(custoTotal.getText()),
					Double.parseDouble(precoLitro.getText()),
					(Combustivel)tipoCombustivel.getSelectedItem(),
					novaSerie.isSelected()
					);
				}catch(AutoGenericException w){
					System.out.println(w);
				}
			}
		});

		register.setPreferredSize(new Dimension(50,50));
		btns.add(register);
		clear = new JButton("Clear");
		clear.setPreferredSize(new Dimension(50,50));
		btns.add(clear);
		add(btns,BorderLayout.SOUTH);

	}



















}