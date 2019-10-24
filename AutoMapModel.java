//package mvc;
import java.util.Set;
import java.util.Iterator;
import java.util.Collection;
import java.util.Map;
import java.util.LinkedHashMap;
import javax.swing.AbstractListModel;
public class AutoMapModel implements AutoEventListener{
	Map<String,Auto> data = new LinkedHashMap<>();
	public AutoMapModel(){
		super();
	}
	public AutoMapModel(Map<String,Auto> data){
		this.data = data;
	}

	public Auto getValue(String key){
		return data.get(key);
	}

	public int size(){
		return data.size();
	}

	public void add(Auto auto){
		data.put(auto.getPlaca(),auto);
		/* 
			Tenho q implementar Todo o MapModel!
		*/
		//fireIntervalAdded(this,data.size(),data.size());
	}

	public Collection<Auto> values(){
		return data.values();
	}

	@Override
	public void addAuto(RegistrationEvent e){
		add(e.getAuto());
		
	}

}