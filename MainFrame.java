//package view;
//import model.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainFrame extends JFrame{
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem addAuto;
	private JMenu editMenu;
	//Novos
	private JMenu viewMenu;
	private JTable refuelTable;
	private JPanel refuelTablePanel;
	private JMenuItem refuelReport;
	private JMenuItem general;
	//
	private JMenuItem editAuto;
	private JMenuItem addRefuel;
	private Controller controller;
	private JPanel tablePanel;
	private JTable table;
	private JPanel registerPanel;
	private JPanel refuelPanel;
	private JTabbedPane tab;
	public MainFrame() throws AutoGenericException{

		controller = new Controller();

		initUI();

	}


	public void initUI(){
		String register[] = {
		"Placa",
		"Modelo",
		"Ano",
		"Fabricante",
		"Capacidade",
		"Odometro"
	};
		registerPanel = new RegisterPanel(register,controller);
		tab = new ClosableTabbedPane();
		tab.setTabPlacement(JTabbedPane.NORTH);

		fileMenu = new JMenu("File");
		addAuto = new JMenuItem("Novo Auto");
		addAuto.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tab.add(registerPanel,"Cadastramento de Automovel");
			}
		});

		//Coloca CTRL(Windows e Linux)/Command(Mac OS) + N p/ criar um auto
		addAuto.setAccelerator(KeyStroke.getKeyStroke('N',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		fileMenu.add(addAuto);
		editMenu = new JMenu("Edit");
		editAuto = new JMenuItem("Editar Auto");
		editAuto.setAccelerator(KeyStroke.getKeyStroke('E',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		editAuto.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int row = table.getSelectedRow();
				if(table.getSelectedRow() != -1){
					JPanel reportPanel = new ReportPanel(controller,(String)table.getValueAt(row,0));
					tab.add(reportPanel,"Report");
				}
			}
		});
		editMenu.add(editAuto);
		menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		setJMenuBar(menuBar);

		table = new FTable(controller.getAutoTable());
		tablePanel = new TablePanel(table);
		table.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				if(SwingUtilities.isRightMouseButton(e)){
					System.out.println("RIGHT");
				}
			}
		});

		addRefuel = new JMenuItem("Novo Abastecimento");
		addRefuel.setAccelerator(KeyStroke.getKeyStroke('R',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		addRefuel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int row = table.getSelectedRow();
				if(table.getSelectedRow() != -1){
					refuelPanel = new RefuelPanel(controller,(String)table.getValueAt(row,0));
					tab.add(refuelPanel,"Refuel");
				}
			}
		});
		fileMenu.add(addRefuel);

		//Novos tabela de abastecimentos
			
			refuelReport = new JMenuItem("Abastecimentos");
			refuelReport.setAccelerator(KeyStroke.getKeyStroke('A',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

			refuelTable = new FTable(controller.getRefuelTable());
			refuelTablePanel = new TablePanel(refuelTable);
		
			refuelReport.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					tab.add(refuelTablePanel,"Relatorio de Abastecimentos");
				}
			});		
			viewMenu = new JMenu("View");
			viewMenu.add(refuelReport);
			general = new JMenuItem("Geral");
			general.setAccelerator(KeyStroke.getKeyStroke('G',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
			general.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					tab.add(tablePanel,"Geral");
				}
			});

			viewMenu.add(general);

			menuBar.add(viewMenu);
			

		//

		tab.add(tablePanel,"Geral");
		setContentPane(tab);
		pack();
		setTitle("Cadastros de Automoveis");
		setResizable(false);
		setSize(800,500);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

}