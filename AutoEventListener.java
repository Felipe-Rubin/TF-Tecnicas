import java.util.EventListener;
public interface AutoEventListener extends EventListener{
	void addAuto(RegistrationEvent e);
	void refuelAuto(RefuelEvent e);
}