//package mvc;
import java.util.Observable;

public class Controller{
	//private AutoMapModel autoMap;
	private AutoTableModel autoTable;
	private RefuelTableModel refuelTable;
	private AutoFacade facade;

	public Controller() throws AutoGenericException{
		facade = new AutoFacade();
		autoTable = new AutoTableModel(facade.getAll());
		//so por enquanto...
		refuelTable = new RefuelTableModel(facade.getAll());
		facade.addListener(autoTable);
	}


	public AutoTableModel getAutoTable(){
		return autoTable;
	}

	public RefuelTableModel getRefuelTable(){
		return refuelTable;
	}

	public void addListener(AutoEventListener e){
		facade.addListener(e);
	}



	public void addAuto(String placa, String modelo, int ano,String fabricante, double capacidade, double odometro) throws AutoGenericException{

		facade.addAuto(placa, modelo, ano,fabricante,capacidade,odometro);
	}


	public void addRefuel(String placa,int dia, int mes, int ano, double o, double q, double cT, double pL, Combustivel c,boolean b) throws AutoGenericException{
		facade.addRefuel(placa,dia,mes,ano,o,q,cT,pL,c,b);
	}

	public Auto getAuto(String placa) throws AutoGenericException{
		return facade.getAuto(placa);
	}



}