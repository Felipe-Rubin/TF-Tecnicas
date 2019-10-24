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
public class RegisterPanel extends JPanel implements AutoEventListener{
	private JButton register;
	private JButton clear;
	private JLabel fieldLabels[];
	private JTextField fieldTexts[];
	private JFileChooser choose;
	private JButton imgButton;
	private String imgPath;
	private Controller controller;
	public RegisterPanel(String requirements[]){
		initUI(requirements);

	}
	public RegisterPanel(String requirements[], Controller controller){
		this.controller = controller;
		controller.addListener(this);
		//controller.addObserver(this);
		initUI(requirements);
	}


	@Override
	public void addAuto(RegistrationEvent e){
		clearFields();
	}

	@Override
	public void refuelAuto(RefuelEvent e){

	}



	private ImageIcon resizeImage(String name){
	return new ImageIcon(
		new ImageIcon(name).getImage().getScaledInstance(
			350, 350, Image.SCALE_DEFAULT
			));
	}

	private void clearFields(){
		for(int i = 0; i < fieldTexts.length; i++){
			fieldTexts[i].setText("");
		}
	}

	private class ChooseImageAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			choose = new JFileChooser(System.getProperty("user.home"));
			choose.setAcceptAllFileFilterUsed(false);

			FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
   			 "Image files", ImageIO.getReaderFileSuffixes());
			choose.addChoosableFileFilter(imageFilter);
			int i = choose.showOpenDialog(null);
			if(i == JFileChooser.CANCEL_OPTION){

			}else if(i == JFileChooser.APPROVE_OPTION){
				imgPath = choose.getSelectedFile().getPath();
				System.out.println(imgPath);
				imgButton.setIcon(resizeImage(imgPath));
				
			}

		}
	}

	public void initUI(String requirements[]){
		imgButton = new JButton();
		imgButton.setPreferredSize(new Dimension(372,185));
		imgButton.setIcon(resizeImage("images/genericCar.png"));
		imgButton.addActionListener(new ChooseImageAction());
		setLayout(new BorderLayout());
		fieldLabels = new JLabel[requirements.length];
		fieldTexts = new JTextField[requirements.length];
		JPanel box = new JPanel();
		box.setLayout(new BoxLayout(box,BoxLayout.PAGE_AXIS));
		for(int i = 0; i < requirements.length; i++){
			JPanel aux = new JPanel();
			aux.setLayout(new FlowLayout(FlowLayout.LEFT));
			fieldLabels[i] = new JLabel(requirements[i]);
			aux.add(fieldLabels[i]);

			fieldTexts[i] = new JTextField(20);
			aux.add(fieldTexts[i]);
			box.add(aux);
		}
		JPanel btns = new JPanel();
		btns.setLayout(new GridLayout(0,2));
		register = new JButton("Register");
		//OBS! Refazer colocando janela de falha
		register.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try{
					controller.addAuto(fieldTexts[0].getText(),fieldTexts[1].getText(),Integer.parseInt(fieldTexts[2].getText()),fieldTexts[3].getText(),Double.parseDouble(fieldTexts[4].getText()),Double.parseDouble(fieldTexts[5].getText()));
				}catch(Exception w){
					System.out.println(w);
				}
			}
	  	
	  	});
		clear = new JButton("Clear");
		clear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				clearFields();
			}
		});
		register.setPreferredSize(new Dimension(50,50));
			
		btns.add(register);

		clear.setPreferredSize(new Dimension(50,50));
		btns.add(clear);

		add(box,BorderLayout.WEST);
		add(btns,BorderLayout.SOUTH);
		add(imgButton,BorderLayout.EAST);

	}

}















