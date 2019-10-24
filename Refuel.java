//package negocio;
public class Refuel implements java.io.Serializable {
	private int dia;
	private int mes;
	private int ano;	
	private Combustivel c;
	private double odometro;
	private double quant;
	private double custoTotal;
	private double porLitro;
	public Refuel(){
		
	}
	public Refuel(int dia, int mes, int ano, double o, double q, double cT, double pL, Combustivel c){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		odometro = o;
		quant = q;
		custoTotal = cT;
		porLitro = pL;
		this.c = c;
	}
	
	public int getDia(){
		return dia;
	}
	public void setDia(int dia){
		this.dia = dia;
	}
	
	public int getAno(){
		return ano;
	}
	public void setAno(int ano){
		this.ano = ano;
	}
	
	public int getMes(){
		return mes;
	}
	public void setMes(int mes){
		this.mes = mes;
	}
	
	public Combustivel getComb(){
		return c;
	}
	public void setComb(Combustivel c){
		this.c = c;
	}
	
	public double getOdo(){
		return odometro;
	}
	public void setOdo(double odometro){
		this.odometro = odometro;
	}
	
	public double getQuant(){
		return quant;
	}
	public void setQuant(double quant){
		this.quant = quant;
	}
	
	public double getCustoT(){
		return custoTotal;
	}
	public void setCustoT(double custoTotal){
		this.custoTotal = custoTotal;
	}
	
	public double getPorLitro(){
		return porLitro;
	}
	public void setPorLitro(double porLitro){
		this.porLitro = porLitro;
	}
}
