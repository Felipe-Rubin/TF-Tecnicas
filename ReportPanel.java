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

public class ReportPanel extends JPanel{
	private JPanel chart;
	private JLabel img;
	private Controller controller;
	private JLabel information[];
	private String autoInfo[];
	private Map<String,Object> auto;
	private String placa;
	public ReportPanel(Controller controller,String placa){
		super();
		this.controller = controller;
		this.placa = placa;
		initUI();
	}

	private ImageIcon resizeImage(String name){
	return new ImageIcon(
		new ImageIcon(name).getImage().getScaledInstance(
			350, 350, Image.SCALE_DEFAULT
			));
	}


	private void initUI(){
		setLayout(new BorderLayout());
		img = new JLabel();
		img.setPreferredSize(new Dimension(372,185));
		img.setIcon(resizeImage("images/genericCar.png"));
		add(img,BorderLayout.WEST);

		try{
			List<Serie> series = controller.getAuto(placa).getSeries();

			add(new ReportPanelChart(placa,"X","Y",series),BorderLayout.EAST);
			int serieCont = 0;

			//E agora...?	
			//tem q implementar os metodos lah
		}catch(AutoGenericException e){
			System.out.println(e);
		}
	


	}
















}