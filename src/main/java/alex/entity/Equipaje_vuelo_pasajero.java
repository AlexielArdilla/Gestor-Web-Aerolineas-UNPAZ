package alex.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipaje_vuelo_pasajero")
public class Equipaje_vuelo_pasajero {
	
	@Id
	private int id;
	private String descripcion;
	private int id_pasajero;
	private int id_vuelo;
	private double peso;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
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
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Equipaje_vuelo_pasajero [id=" + id + ", descripcion=" + descripcion + ", id_pasajero=" + id_pasajero
				+ ", id_vuelo=" + id_vuelo + ", peso=" + peso + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + id;
		result = prime * result + id_pasajero;
		result = prime * result + id_vuelo;
		long temp;
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipaje_vuelo_pasajero other = (Equipaje_vuelo_pasajero) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id != other.id)
			return false;
		if (id_pasajero != other.id_pasajero)
			return false;
		if (id_vuelo != other.id_vuelo)
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		return true;
	}
	
	
}
