//package negocio;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.spec.*;
import java.util.List;
import java.util.LinkedList;

public class Auto implements java.io.Serializable{
	private String placa;
	private String modelo;
	private String fabricante;
	private int ano;
	private double capacidade;
	private double odometro;
	private List<Serie> series;
	private int curr = 0;
	private String imagem;
	public Auto(){}
	public Auto(String placa, String modelo, int ano,String fabricante, double capacidade, double odometro){
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.fabricante = fabricante;
		this.capacidade = capacidade;
		this.odometro = odometro;
		series = new LinkedList<>();
		//Serie inicial = new Serie();
		//series.add(inicial);
	}

	public String getPlaca(){
		return placa;
	}
	public void setPlaca(String placa){
		this.placa = placa;
	}	
	public String getModelo(){
		return modelo;
	}
	public void setModelo(String modelo){
		this.modelo = modelo;
	}		
	public int getAno(){
		return ano;
	}
	public void setAno(int ano){
		this.ano = ano;
	}
	public String getFabricante(){
		return fabricante;
	}
	public void setFabricante(String fabricante){
		this.fabricante = fabricante;
	}
	public double getCapacidade(){
		return capacidade;
	}
	public void setCapacidade(double capacidade){
		this.capacidade = capacidade;
	}
		
	//Precisa de metodos para calcular o odometro.No momento so usa o inicial
	public double getOdometro(){
		return odometro;
	}
	public void setOdometro(double odometro){
		this.odometro = odometro;
	}	
	public List<Serie> getSeries(){
		return series;
	}
	
	public void setSeries(List<Serie> series){
		this.series = series;
	}	
	

	/*
		OBS: alterei pq a primeira vez
		q tu addAbast deve ser o inicio de uma nova serie
	*/
	public boolean addAbast(Refuel re, boolean b){
		if(b == true){
			if(series.size() != 0){
				curr++;
			}
			Serie proxima = new Serie();
			series.add(proxima);
			//curr++;
		}
		if(series.size() == 0){
			series.add(new Serie());
		}
		return series.get(curr).addAbast(re);
	}
	public int getCurr(){
		return curr;
	}
	public void setCurr(int curr){
		this.curr = curr;
	}

	public String getImage(){
		return imagem;
	}
	public void setImagem(String imagem){
		this.imagem = imagem;
	}

}
