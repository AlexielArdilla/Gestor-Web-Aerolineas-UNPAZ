package alex.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="facturacion")
public class Facturacion {

	@Id
	private int id;
	private String nombre_yapel;
	private String destino;
	private int costo;
	private String medio_pago;
	private String numero_tarjeta;
	private int num_seguridad;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre_yapel() {
		return nombre_yapel;
	}
	public void setNombre_yapel(String nombre_yapel) {
		this.nombre_yapel = nombre_yapel;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getMedio_pago() {
		return medio_pago;
	}
	public void setMedio_pago(String medio_pago) {
		this.medio_pago = medio_pago;
	}
	public String getNumero_tarjeta() {
		return numero_tarjeta;
	}
	public void setNumero_tarjeta(String numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}
	public int getNum_seguridad() {
		return num_seguridad;
	}
	public void setNum_seguridad(int num_seguridad) {
		this.num_seguridad = num_seguridad;
	}
	
	
	
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	@Override
	public String toString() {
		return "Facturacion [id=" + id + ", nombre_yapel=" + nombre_yapel + ", destino=" + destino + ", medio_pago="
				+ medio_pago + ", numero_tarjeta=" + numero_tarjeta + ", num_seguridad=" + num_seguridad + "]";
	}
	
	
	
}
