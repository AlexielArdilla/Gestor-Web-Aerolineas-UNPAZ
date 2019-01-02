package alex.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipaje")
public class Equipaje {
	
	@Id
	private int id;
	private int id_vuelo;
	private String pasajero;
	private String descripcion;
	private double peso;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_vuelo() {
		return id_vuelo;
	}
	public void setId_vuelo(int id_vuelo) {
		this.id_vuelo = id_vuelo;
	}
	public String getPasajero() {
		return pasajero;
	}
	public void setPasajero(String pasajero) {
		this.pasajero = pasajero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return "Equipaje [id=" + id + ", id_vuelo=" + id_vuelo + ", pasajero=" + pasajero + ", descripcion="
				+ descripcion + ", peso=" + peso + "]";
	}
	
	
	

}
