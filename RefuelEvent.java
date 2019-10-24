import java.util.EventObject;
public class RefuelEvent extends EventObject{
	private Auto auto;
	public RefuelEvent(Object obj, Auto auto){
		super(obj);
		this.auto = auto;
	}
	public Auto getAuto(){
		return auto;		
	}
}