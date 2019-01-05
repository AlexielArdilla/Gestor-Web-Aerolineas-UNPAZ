package alex.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vuelo_pasajero")
public class Vuelo_pasajero {

	@Id
	private int id_pasajero;
	private int id_vuelo;
	private double peso_total_equipaje;
	
	public int getId_pasajero() {
		return id_pasajero;
	}
	public void setId_pasajero(int id_pasajero) {
		this.id_pasajero = id_pasajero;
	}
	public int getId_vuelo() {
		return id_vuelo;
	}
	public void setId_vuelo(int id_vuelo) {
		this.id_vuelo = id_vuelo;
	}
	public double getPeso_total_equipaje() {
		return peso_total_equipaje;
	}
	public void setPeso_total_equipaje(double peso_total_equipaje) {
		this.peso_total_equipaje = peso_total_equipaje;
	}
	
	@Override
	public String toString() {
		return "Vuelo_pasajero [id_pasajero=" + id_pasajero + ", id_vuelo=" + id_vuelo + ", peso_total_equipaje="
				+ peso_total_equipaje + "]";
	}
	
	
	
	
}
