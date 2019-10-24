import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.plaf.basic.*;

public class ClosableTabbedPane extends JTabbedPane{
	public ClosableTabbedPane(){
		super();
	}

	@Override 
	public void addTab(String st, Component cp){
		//super.addTab(st,cp);
		super.addTab(st,cp);
		int index = indexOfTab(st);
		JPanel tab = new Tab(st);
	
		setTabComponentAt(index,tab);
	}



	private class Tab extends JPanel{

		public Tab(String label){
			setLayout(new GridBagLayout());
			setOpaque(false);
			JLabel lbl = new JLabel(label);
			JButton bt = new SimplerButton("x");
			bt.addActionListener(new CloseAction(label));
			GridBagConstraints constrain = new GridBagConstraints();
			constrain.gridx = 0;
			constrain.gridy = 0;
			constrain.weightx = 0;

			add(lbl,constrain);
			constrain.gridx++;
			constrain.weightx = 0;
			add(bt,constrain);
		}
	}

	private class CloseAction implements ActionListener{
		private String location;

		public CloseAction(String location){
			this.location = location;
		}
		public void actionPerformed(ActionEvent e){
			int i = indexOfTab(location);
			if(i >= 0){
				removeTabAt(i);
			}
		}
	}

	private class SimplerButton extends JButton{
		public SimplerButton(){
			//super();
			config();
		}
		public SimplerButton(String s){
			setText(s);
			config();
		}

		private void config(){
			setPreferredSize(new Dimension(15,15));
			//setUI(new BasicButtonUI());
			setContentAreaFilled(false);
			setFocusable(false);
			setBorder(BorderFactory.createEtchedBorder());
			setBorderPainted(false);
            setRolloverEnabled(true);
            //setFocusPainted(false);
		}
	}


}