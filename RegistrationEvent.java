import java.util.EventObject;
public class RegistrationEvent extends EventObject{
	private Auto auto;
	public RegistrationEvent(Object obj, Auto auto){
		super(obj);
		this.auto = auto;
	}
	public Auto getAuto(){
		return auto;		
	}
}