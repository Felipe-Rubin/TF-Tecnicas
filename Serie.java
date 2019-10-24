//package negocio;
import java.util.List;
import java.util.LinkedList;
public class Serie implements java.io.Serializable{
	private List<Refuel> abast;
	private int curr;
	public Serie(){
		curr = 0;
		abast = new LinkedList<>();
	}
	
	public boolean addAbast(Refuel re){
		if(curr == 0){
			abast.add(re);
			curr++;
			return true;
		}
		
		if(re.getDia() >= abast.get(getCurr()-1).getDia() &&
				re.getAno() >= abast.get(getCurr()-1).getAno() &&
				re.getMes() >= abast.get(getCurr()-1).getMes()){
			abast.add(re);
			curr++;
			return true;
		}
		return false;
	}

	public int getCurr(){
		return curr;
	}
	public void setCurr(int curr){
		this.curr = curr;
	}

	public List<Refuel> getAbast(){
		return abast;
	}
	public void setAbast(List<Refuel> abast){
		this.abast = abast;
	}
	
}
