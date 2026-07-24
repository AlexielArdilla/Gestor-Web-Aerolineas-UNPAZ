package alex.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ciudad")
public class Ciudad {
	
	@Id
	private int id;
	private String nombre_ciudad;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre_ciudad() {
		return nombre_ciudad;
	}
	public void setNombre_ciudad(String nombre_ciudad) {
		this.nombre_ciudad = nombre_ciudad;
	}
	
	@Override
	public String toString() {
		return "Ciudad [id=" + id + ", nombre_ciudad=" + nombre_ciudad + "]";
	}
	
	

}
