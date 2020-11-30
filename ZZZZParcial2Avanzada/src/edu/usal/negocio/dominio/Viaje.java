package edu.usal.negocio.dominio;

public class Viaje {
	
	private int viajeID;
	private int id_chofer;
	private String id_camion;
	private String origen;
	private String destino;
	private int estado; 
	private int tiempo_viajes; 
	private int cant_tanques; 
	
	
	
	public Viaje(int viajeID, int id_chofer, String id_camion, String origen, String destino, int estado,
			int tiempo_viajes, int cant_tanques) {
		super();
		this.viajeID = viajeID;
		this.id_chofer = id_chofer;
		this.id_camion = id_camion;
		this.origen = origen;
		this.destino = destino;
		this.estado = estado;
		this.tiempo_viajes = tiempo_viajes;
		this.cant_tanques = cant_tanques;
	}


	public Viaje() { }
	

	public int getId_chofer() {
		return id_chofer;
	}
	


	public void setId_chofer(int id_chofer) {
		this.id_chofer = id_chofer;
	}
	


	public String getId_camion() {
		return id_camion;
	}
	


	public void setId_camion(String id_camion) {
		this.id_camion = id_camion;
	}
	


	public String getOrigen() {
		return origen;
	}
	
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	


	public String getDestino() {
		return destino;
	}
	


	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
	public int getViajeID() {
		return viajeID;
	}

	public void setViajeID(int viajeID) {
		this.viajeID = viajeID;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	

	public int getTiempo_viajes() {
		return tiempo_viajes;
	}


	public void setTiempo_viajes(int tiempo_viajes) {
		this.tiempo_viajes = tiempo_viajes;
	}


	public int getCant_tanques() {
		return cant_tanques;
	}


	public void setCant_tanques(int cant_tanques) {
		this.cant_tanques = cant_tanques;
	}


	@Override
	public String toString() {
		return "Viaje [viajeID=" + viajeID + ", id_chofer=" + id_chofer + ", id_camion=" + id_camion + ", origen="
				+ origen + ", destino=" + destino + ", estado=" + estado + ", tiempo_viajes=" + tiempo_viajes
				+ ", cant_tanques=" + cant_tanques + "]";
	}

	
}
