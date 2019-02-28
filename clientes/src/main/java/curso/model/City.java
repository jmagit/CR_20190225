package curso.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="city_id")
	private int idCity;

	private String city;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;

	public City() {
	}

	public int getIdCity() {
		return this.idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}