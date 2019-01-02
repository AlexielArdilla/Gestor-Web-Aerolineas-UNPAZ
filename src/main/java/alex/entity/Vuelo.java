package alex.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vuelo")
public class Vuelo {
	
	@Id
	private int id;
	private String nombre_compania;
	private Date fecha;
	private String ciudad_origen;
	private String ciudad_destino;
	private String avion;
	
	public Vuelo(){}
	
	public Vuelo(int id, String nombre_compania, Date fecha, String ciudad_origen, String ciudad_destino,
			String avion) {
		super();
		this.id = id;
		this.nombre_compania = nombre_compania;
		this.fecha = fecha;
		this.ciudad_origen = ciudad_origen;
		this.ciudad_destino = ciudad_destino;
		this.avion = avion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_compania() {
		return nombre_compania;
	}

	public void setNombre_compania(String nombre_compania) {
		this.nombre_compania = nombre_compania;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCiudad_origen() {
		return ciudad_origen;
	}

	public void setCiudad_origen(String ciudad_origen) {
		this.ciudad_origen = ciudad_origen;
	}

	public String getCiudad_destino() {
		return ciudad_destino;
	}

	public void setCiudad_destino(String ciudad_destino) {
		this.ciudad_destino = ciudad_destino;
	}

	public String getAvion() {
		return avion;
	}

	public void setAvion(String avion) {
		this.avion = avion;
	}

	@Override
	public String toString() {
		return "Vuelo [id=" + id + ", nombre_compania=" + nombre_compania + ", fecha=" + fecha + ", ciudad_origen="
				+ ciudad_origen + ", ciudad_destino=" + ciudad_destino + ", avion=" + avion + "]";
	}
	
	

}
