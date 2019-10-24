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
public class RefuelTableModel extends AbstractTableModel{
	String columns[];
	List<RefuelModel> refuelModel;
	//Data de inicio
	//Data de fim
	//placa do veiculo
	/*
		OBS:
		No relatorio de abastecimentos efetuados, 
		tem q ter filtro de :
		data de inicio, 
		data de fim, 
		placa

		cada abastecimento eh 1 data so, logo n faz sentido
		ter data de fim.
		a n ser q fosse series...,
		mas por enquanto vai so os abastecimentos mesmo
	*/

	private class RefuelModel{
		private Refuel refuel;
		private String placa;
		public RefuelModel(String placa, Refuel refuel){
			this.refuel = refuel;
			this.placa = placa;
		}

		public String getData(){
			return refuel.getDia()+"/"+refuel.getMes()+"/"+refuel.getAno();
		}

		// public void setPlaca(String placa){
		// 	this.placa = placa;
		// }
		// public void setRefuel(Refuel refuel){
		// 	this.refuel = refuel;
		// }

		// public String getPlaca(){
		// 	return placa;
		// }

		// public Refuel getRefuel(){
		// 	return refuel;
		// }


	}


	public RefuelTableModel(Map<String,Auto> autoMap){
		refuelModel = new ArrayList<>();

		for(Map.Entry<String,Auto> entryAuto : autoMap.entrySet()){
			for(Serie serie : entryAuto.getValue().getSeries()){
				for(Refuel refuel : serie.getAbast()){
					refuelModel.add(new RefuelModel(entryAuto.getKey(),refuel));
				}
			}
		}

		columns = new String[]{
			"Placa",
			"Data",
			"Combustivel",
			"Odometro",
			"Litros",
			"Custo p/ Litro",
			"Custo Total"
		};
	}

	
	@Override
	public Object getValueAt(int x, int y){
		
		return mapY(refuelModel.get(x),columns[y]);

		//return null;
	}

	private Object mapY(RefuelModel model ,String y){

		switch(y){
			case "Placa": return model.placa;
			case "Data": return model.getData();
			case "Combustivel": return model.refuel.getComb();
			case "Odometro": return model.refuel.getOdo();
			case "Litros": return model.refuel.getQuant();
			case "Custo p/ Litro": return model.refuel.getPorLitro();
			case "Custo Total": return model.refuel.getCustoT();
			default: return null;
		}
	}

	@Override
	public int getColumnCount(){
		return columns.length;
	}

	@Override
	public int getRowCount(){
		return refuelModel.size();
	}

	@Override
	public boolean isCellEditable(int row, int column){
		return false;
	}

	
	@Override
	public String getColumnName(int column){
		return columns[column];
	}
}