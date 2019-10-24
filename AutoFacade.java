//package negocio;
//import dao.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class AutoFacade{
	private AutoDAO dao;
	private AutoDAO memory; //TO DO
	private Set<AutoEventListener> listeners;
	public AutoFacade(){
		dao = AutoDAOYaml.getInstance();
		listeners = new HashSet<>();

	}

	public void addAuto(String placa, String modelo, int ano,String fabricante, double capacidade, double odometro) throws AutoGenericException{
		try{
			Auto auto = new Auto(placa, modelo, ano,fabricante,capacidade,odometro);
			dao.add(auto);
			triggerAutoRegistration(auto);
		}catch(AutoDAOException e){
			throw new AutoGenericException("Couldn't Register, cause:"+"\n"+e.getMessage());
		}
	}

	public void addRefuel(String placa, int dia, int mes, int ano, double o, double q, double cT, double pL, Combustivel c,boolean b) throws AutoGenericException{
		try{
			Auto auto = dao.getPorPlaca(placa);
			System.out.println("Ok");
			Refuel re = new Refuel(dia,mes,ano,o,q,cT,pL,c);
			System.out.println("Ok2");
			auto.addAbast(re,b);
			dao.atualizarAuto(auto);
			System.out.println("Ok3");
			triggerAutoRefuel(auto);
		}catch(Exception e){
			throw new AutoGenericException("Couldn't add Refuel, cause:"+"\n"+e.getMessage());

		}
	}

	private void triggerAutoRefuel(Auto auto){
		//TO DO
	}


	private void triggerAutoRegistration(Auto auto){
		RegistrationEvent e = new RegistrationEvent(this,auto);
		for(AutoEventListener ael : listeners){
			ael.addAuto(e);
		}
	}
	public void addListener(AutoEventListener e){
		if(!listeners.contains(e))
			listeners.add(e);

	}

	public Map<String,Auto> getAll() throws AutoGenericException{
		Map<String,Auto> autoMap;

		try{
			autoMap = dao.getAll();
		}catch(AutoDAOException e){
			String message = "Couldn't get all Auto, cause:\n"+e.getMessage();
			throw new AutoGenericException(message);
		}
		return autoMap;
	}


	public Auto getAuto(String placa) throws AutoGenericException{
		Auto auto;
		try{
			 auto = dao.getPorPlaca(placa);

		}catch(AutoDAOException e){
			String message = "Couldn't get Auto, cause:\n"+e.getMessage();
			throw new AutoGenericException(message);
		}
		return auto;
	}

}