package alex.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "break")
public class Break {

	@Id
	private int id;
	private String user;
	private String comienzo_o_final;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getComienzo_o_final() {
		return comienzo_o_final;
	}
	public void setComienzo_o_final(String comienzo_o_final) {
		this.comienzo_o_final = comienzo_o_final;
	}
	@Override
	public String toString() {
		return "Break [id=" + id + ", user=" + user + ", comienzo_o_final=" + comienzo_o_final + "]";
	}
	
	
	
	
	
	
}
