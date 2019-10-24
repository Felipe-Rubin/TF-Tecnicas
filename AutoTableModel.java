//package mvc;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
import java.util.Collection;
import java.util.Map;
import java.util.LinkedHashMap;
import javax.swing.AbstractListModel;
import javax.swing.table.AbstractTableModel;
public class AutoTableModel extends AbstractTableModel implements AutoEventListener{
	//Map<String,Auto> data = new LinkedHashMap<>();

	private String columns[];
	private List<Auto> data;

	public AutoTableModel(){
		data = new ArrayList<>();
		columns = new String[]{
			"Placa",
			"Modelo",
			"Fabricante",
			"Ano",
			"Capacidade",
			"Odometro"
		};
	}
	public AutoTableModel(List<Auto> data){
		this.data = data;
		columns = new String[]{
			"Placa",
			"Modelo",
			"Fabricante",
			"Ano",
			"Capacidade",
			"Odometro"
		};		
	}

	public AutoTableModel(Map<String,Auto> mdata){
		data = new ArrayList<>();
		data.addAll(mdata.values());

		//this.data = data;
		columns = new String[]{
			"Placa",
			"Modelo",
			"Fabricante",
			"Ano",
			"Capacidade",
			"Odometro"
		};		
	}
	public AutoTableModel(List<Auto> data,String columns[]){
		this.data = data;
		this.columns = columns;
	}

	public AutoTableModel(String columns[]){
		data = new ArrayList<>();
		this.columns = columns;
	}

	@Override
	public String getColumnName(int column){
		return columns[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex){
		if(data.size() == 0){
			return Object.class;
		}
		return getValueAt(0,columnIndex).getClass();
	}


	public Object getValueAt(int x, int y){
		if(data.get(x) == null) return null;
		return mapY(data.get(x),columns[y]);
	}

	private Object mapY(Auto auto, String y){
		if(auto == null) return null;

		switch(y){
			case "Placa": return auto.getPlaca();
			case "Modelo": return auto.getModelo();
			case "Fabricante": return auto.getFabricante();
			case "Ano": return auto.getAno();
			case "Capacidade": return auto.getCapacidade();
			case "Odometro": return auto.getOdometro();
			default: return null;
		}
	}


	public int getColumnCount(){
		return columns.length;
	}
	public int getRowCount(){
		return data.size();
	}


	public int size(){
		return data.size();
	}

	public void add(Auto auto){
		data.add(auto);
	}

	public Collection<Auto> values(){
		return data;
	}

	@Override
	public void addAuto(RegistrationEvent e){
		add(e.getAuto());
		fireTableRowsInserted(data.size()-1,data.size()-1);
	}

	@Override
	public void refuelAuto(RefuelEvent e){
		//TO DO
	}

	@Override
	public boolean isCellEditable(int row, int column){
		return false;
	}




}