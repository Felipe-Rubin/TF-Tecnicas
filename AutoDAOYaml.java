//package Dao;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import org.yaml.snakeyaml.*;
//import Negocio.Auto;
/**
 * Esta classe le e escreve no formato .yaml
 *
 * @author Felipe Pfeifer Rubin
 * @author Ian Aragon Escobar
 */
public class AutoDAOYaml implements AutoDAO{
	private String fileName;
	private File file;
	private Yaml yaml;
	private DumperOptions options;
	private static AutoDAOYaml autodaoyaml;
	
	private AutoDAOYaml(){
		fileName = "db.yaml";

			file = new File(fileName);
			options = new DumperOptions();
			options.setDefaultFlowStyle(DumperOptions.FlowStyle.FLOW);
	     	options.setPrettyFlow(true);
	     	yaml = new Yaml(options);			
	}
	public static AutoDAOYaml getInstance(){
		if(autodaoyaml == null) autodaoyaml = new AutoDAOYaml();
		return autodaoyaml;
	}



	/**
	* Este Metodo le o arquivo .yaml contendo o
	*banco de dados do programa
	*
	*
	*@param nenhum
	*@return Map onde chaves sao placas e valores sao os Auto 
	*@exception AutoDaoException quando nao pode ler
	*/
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Auto> getAll() throws AutoDAOException{
		Map<String,Auto> map;
		try{
			FileReader fr = new FileReader(file);
			map = (HashMap<String,Auto>)yaml.load(fr);
		}catch(Exception e){

			System.out.println(e.getMessage());
			throw new AutoDAOException("Couldn't Save File");
		}
		//Se o BD estiver vazio
		if(map == null) return new HashMap<>();
		return map;
	}
	/**
	* Este Metodo escreve o arquivo .yaml contendo o
	*banco de dados do programa
	*
	*@param map onde chaves sao placas e valores sao os Auto 
	*@return nenhum
	*@exception AutoDaoException quando nao pode escrever
	*/	
	@SuppressWarnings("unchecked")
	@Override
	public void add(Map<String,Auto> map) throws AutoDAOException{
		Map<String,Auto> autoMap = getAll();
		if(autoMap == null){
			autoMap = new HashMap<>();
		}
		autoMap.putAll(map);
		try{
			FileWriter fw = new FileWriter(file);
			yaml.dump(autoMap,fw);
		}catch(Exception e){

			throw new AutoDAOException("Couldn't Save File");
		}

	}

	@Override
	public void atualizarAuto(Auto auto) throws AutoDAOException{
		Map<String,Auto> autoMap = getAll();
		if(autoMap == null) throw new AutoDAOException("Tried to update null auto");
		autoMap.put(auto.getPlaca(),auto);
		try{
			FileWriter fw = new FileWriter(file);
			yaml.dump(autoMap,fw);

		}catch(Exception e){
			throw new AutoDAOException("Couldn't Save File");
		}
	}

	@Override
	public void add(Auto auto) throws AutoDAOException{
		Map<String,Auto> autoMap = getAll();
		if(autoMap == null){
			autoMap = new HashMap<>();
		}
		if(autoMap.containsKey(auto.getPlaca())){
			throw new AutoDAOException("Plate already registered");
		}
		autoMap.put(auto.getPlaca(),auto);
		try{
			FileWriter fw = new FileWriter(file);
			yaml.dump(autoMap,fw);
		}catch(Exception e){
			throw new AutoDAOException("Couldn't Save File");
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Auto> getPorOdometro(double odometro) throws AutoDAOException {
		Map<String,Auto> autoMap = getAll();
		if(autoMap == null) return null;
		Map<String,Auto> odometroMap = new HashMap<>();
		for(Auto auto : autoMap.values()){
			//Seguranca
			if(Double.compare(odometro,auto.getOdometro()) == 0){ 
				odometroMap.put(auto.getPlaca(),auto);
			}
		}
		return odometroMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Auto> getPorCapacidade(double capacidade) throws AutoDAOException{
		Map<String,Auto> autoMap = getAll();
		if(autoMap == null) return null;
		Map<String,Auto> capacidadeMap = new HashMap<>();
		for(Auto auto : autoMap.values()){
			//Seguranca
			if(Double.compare(capacidade,auto.getCapacidade()) == 0){ 
				capacidadeMap.put(auto.getPlaca(),auto);
			}
		}
		return capacidadeMap;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Auto> getPorAno(int ano) throws AutoDAOException{
		Map<String,Auto> autoMap = getAll();
		if(autoMap == null) return null;
		Map<String,Auto> anoMap = new HashMap<>();
		for(Auto auto : autoMap.values()){
			//Seguranca
			if(Integer.compare(ano,auto.getAno()) == 0){ 
				anoMap.put(auto.getPlaca(),auto);
			}
		}
		return anoMap;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Auto> getPorModelo(String modelo) throws AutoDAOException{
		Map<String,Auto> autoMap = getAll();
		if(autoMap == null) return null;
		Map<String,Auto> modeloMap = new HashMap();
		for(Auto auto : autoMap.values()){
			//Seguranca
			if(auto.getModelo().equals(modelo)){ 
				modeloMap.put(auto.getPlaca(),auto);
			}
		}
		return modeloMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Auto getPorPlaca(String placa) throws AutoDAOException{
		Map<String,Auto> autoMap = getAll();
		if(autoMap == null) return null;
		return autoMap.get(placa);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Auto> getPorFabricante(String fabricante) throws AutoDAOException{
		Map<String,Auto> autoMap = getAll();
		if(autoMap == null) return null;
		Map<String,Auto> fabricanteMap = new HashMap();
		for(Auto auto : autoMap.values()){
			//Seguranca
			if(auto.getFabricante().equals(fabricante)){ 
				fabricanteMap.put(auto.getPlaca(),auto);
			}
		}
		return fabricanteMap;
	}

}