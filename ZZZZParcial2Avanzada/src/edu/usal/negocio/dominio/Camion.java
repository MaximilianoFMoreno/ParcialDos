package edu.usal.negocio.dominio;

public class Camion {
	
	private String marca;
	private String domino;
	private int toneladas_max;
	private int litros_tanque;
	private int consumo;
	private int estado;
	private String categoria;
	
	public Camion(String marca, String domino, int toneladas_max, int litros_tanque,
			int litros_cons_x_km, int estado, String categoria) {
		super();
		this.marca = marca;
		this.domino = domino;
		this.toneladas_max = toneladas_max;
		this.litros_tanque = litros_tanque;
		this.consumo = litros_cons_x_km;
		this.estado = estado;
		this.categoria = categoria;
	}

	
	public Camion() {}
	
	public String getMarca() {
		return marca;
	}


	
	public void setMarca(String marca) {
		this.marca = marca;
	}


	
	public String getDomino() {
		return domino;
	}


	
	public void setDomino(String domino) {
		this.domino = domino;
	}


	
	public int getToneladas_max() {
		return toneladas_max;
	}


	
	public void setToneladas_max(int toneladas_max) {
		this.toneladas_max = toneladas_max;
	}


	
	public int getLitros_tanque() {
		return litros_tanque;
	}


	
	public void setLitros_tanque(int litros_tanque) {
		this.litros_tanque = litros_tanque;
	}


	
	public int getConsumo() {
		return consumo;
	}


	
	public void setConsumo(int litros_cons_x_km) {
		this.consumo = litros_cons_x_km;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	public String getCategoria() {
		return categoria.toString();
	}


	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "Camion [marca=" + marca + ", domino=" + domino + ", toneladas_max=" + toneladas_max + ", litros_tanque="
				+ litros_tanque + ", consumo=" + consumo + ", estado=" + estado + ", categoria=" + categoria + "]";
	}

 
	
	
}
