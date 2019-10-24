//package dao;
import java.util.Map;
import java.util.HashMap;
public class AutoDAOMemory implements AutoDAO{
	private Map<String,Auto> autoMap;

	public AutoDAOMemory(){
		autoMap = new HashMap<>();
	}

	public AutoDAOMemory(Map<String,Auto> map){
		autoMap = map;
		if(autoMap == null)
			autoMap = new HashMap<>();
	}

	@Override
	public void atualizarAuto(Auto auto) throws AutoDAOException{
		if(auto == null) throw new AutoDAOException("Tried to update null auto");
		autoMap.put(auto.getPlaca(),auto);
	}

	@Override
	public Map<String,Auto> getPorOdometro(double odometro){
		Map<String,Auto> odometroMap = new HashMap<>();
		for(Auto auto : autoMap.values()){
			//Seguranca
			if(Double.compare(odometro,auto.getOdometro()) == 0){ 
				odometroMap.put(auto.getPlaca(),auto);
			}
		}
		return odometroMap;
	}

	@Override
	public Map<String,Auto> getPorCapacidade(double capacidade){
		Map<String,Auto> capacidadeMap = new HashMap<>();
		for(Auto auto : autoMap.values()){
			//Seguranca
			if(Double.compare(capacidade,auto.getCapacidade()) == 0){ 
				capacidadeMap.put(auto.getPlaca(),auto);
			}
		}
		return capacidadeMap;
	}

	@Override
	public Map<String,Auto> getPorAno(int ano){
		Map<String,Auto> anoMap = new HashMap<>();
		for(Auto auto : autoMap.values()){
			//Seguranca
			if(Integer.compare(ano,auto.getAno()) == 0){ 
				anoMap.put(auto.getPlaca(),auto);
			}
		}
		return anoMap;
	}
	
	@Override
	public Map<String,Auto> getPorModelo(String modelo){
		Map<String,Auto> modeloMap = new HashMap<>();
		for(Auto auto : autoMap.values()){
			//Seguranca
			if(auto.getModelo().equals(modelo)){ 
				modeloMap.put(auto.getPlaca(),auto);
			}
		}
		return modeloMap;
	}

	@Override
	public Map<String,Auto> getPorFabricante(String fabricante){
		Map<String,Auto> fabricanteMap = new HashMap<>();
		for(Auto auto : autoMap.values()){
			//Seguranca
			if(auto.getFabricante().equals(fabricante)){ 
				fabricanteMap.put(auto.getPlaca(),auto);
			}
		}
		return fabricanteMap;
	}

	@Override
	public Auto getPorPlaca(String placa){
		return autoMap.get(placa);
	}

	@Override
	public Map<String,Auto> getAll(){
		return autoMap;
	}

	@Override
	public void add(Map<String,Auto> autoAddMap){
		 	autoMap.putAll(autoAddMap);
	}

	@Override
	public void add(Auto auto){
		autoMap.put(auto.getPlaca(),auto);
	}


}