//package Dao;
/** 
 * Esta classe eh um formato de excecao para
 *classes relativas a serializacao AutoDAO
 *
 * @author Felipe Pfeifer Rubin
 * @author Ian Aragon Escobar
 */
public class AutoDAOException extends Exception{
	/**
	* Constrututor da classe
	*
	*@param nenhum
	*/
	public AutoDAOException(){

	}
	/**
	*
	*@param message mensagem da excacao
	*/
	public AutoDAOException(String message){
		super(message);
	}
	/**
	*
	*@param cause causa da excecao
	*/
	public AutoDAOException(Throwable cause){
		super(cause);
	}
	/**
	*
	*@param message mensagem da excacao
	*@param cause causa da excecao
	*/
	public AutoDAOException(String message, Throwable cause){
		super(message,cause);
	}
	

	
}