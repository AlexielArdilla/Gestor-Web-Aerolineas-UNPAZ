package alex.entity;
// Generated 21-sep-2018 4:41:35 by Hibernate Tools 5.2.3.Final


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Avion generated by hbm2java
 */
@Entity
@Table(name = "avion")
public class Avion implements Comparable<Avion> {

	@Id
	private Integer id;
	private int cant_pasajero;
	private String descripcion;

	public Avion() {
	}

	public Avion(int id, int cant_pasajero, String descripcion) {
		this.id = id;
		this.cant_pasajero = cant_pasajero;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getCant_pasajero() {
		return cant_pasajero;
	}

	public void setCant_pasajero(int cant_pasajero) {
		this.cant_pasajero = cant_pasajero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int compareTo(Avion arg0) {
		
		return this.id.compareTo(arg0.id);
	}

	@Override
	public String toString() {
		return "Avion [id=" + id + ", cantPasajero=" + cant_pasajero + ", descripcion=" + descripcion + "]";
	}

	

}
