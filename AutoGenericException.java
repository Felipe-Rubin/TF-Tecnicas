
/** 
 * Esta classe eh um formato de excecao generica para
 *qualquer classe que utiliza o objeto Auto 
 *
 * @author Felipe Pfeifer Rubin
 * @author Ian Aragon Escobar
 */
public class AutoGenericException extends Exception{
	/**
	* Constrututor da classe
	*
	*@param nenhum
	*/
	public AutoGenericException(){

	}
	/**
	*
	*@param message mensagem da excacao
	*/
	public AutoGenericException(String message){
		super(message);
	}
	/**
	*
	*@param cause causa da excecao
	*/
	public AutoGenericException(Throwable cause){
		super(cause);
	}
	/**
	*
	*@param message mensagem da excacao
	*@param cause causa da excecao
	*/
	public AutoGenericException(String message, Throwable cause){
		super(message,cause);
	}
	

	
}