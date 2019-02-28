package curso.dto;

import java.io.Serializable;

public class CountryDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String country;
	
	public CountryDTO() { }
	public CountryDTO(int id, String country) {
		this.id = id;
		this.country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "CountryDTO [id=" + id + ", country=" + country + "]";
	}
	

}
