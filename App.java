//package mvc;
import java.util.*;
import javax.swing.*;
public class App{
	
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				try{
				new MainFrame();
				}catch(AutoGenericException e){
					System.out.println("Bad initialization, cause:\n"+e.getMessage());
					System.exit(0);
				}
			}
		});	
	}	
}