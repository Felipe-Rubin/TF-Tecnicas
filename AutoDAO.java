//package negocio;
import java.util.Map;
//import dao.AutoDAOException;
//import Negocio.Auto;
/** 
 * Interface DAO para serializacao do objeto Auto
 *
 * @author Felipe Pfeifer Rubin
 * @author Ian Aragon Escobar
 */
public interface AutoDAO{
	Map<String,Auto> getAll() throws AutoDAOException;
	void add(Map<String,Auto> autoMap) throws AutoDAOException;
	void add(Auto auto) throws AutoDAOException;
	void atualizarAuto(Auto auto) throws AutoDAOException;
	Auto getPorPlaca(String placa) throws AutoDAOException;

	Map<String,Auto> getPorModelo(String modelo) throws AutoDAOException;

	Map<String,Auto> getPorAno(int ano) throws AutoDAOException;

	Map<String,Auto> getPorCapacidade(double capacidade) throws AutoDAOException;

	Map<String,Auto> getPorOdometro(double odometro) throws AutoDAOException;

	Map<String,Auto> getPorFabricante(String fabricante) throws AutoDAOException;
	
}