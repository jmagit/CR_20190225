package curso.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonFormat;

import curso.model.Film;
import curso.model.FilmActor;
import curso.model.FilmCategory;
import curso.model.Inventory;
import curso.model.Language;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Entidad Peliculas", description = "Información completa de la pelicula")
public class FilmDTO extends ResourceSupport  implements Serializable {
	private int idFilm;
	private String description;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Timestamp lastUpdate;
	@Size(max=255)
	@NotBlank
	@ApiModelProperty(value = "Titulo de la pelicula que no debe estar en blanco", required = true)
	private String title;
	private int length;
	private String rating;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
	private Date releaseYear;
	private byte rentalDuration;
	private BigDecimal rentalRate;
	private BigDecimal replacementCost;
	private byte idLanguage;
	@ApiModelProperty(value = "Idioma de la version original")
	private byte idVO;
	public FilmDTO() {}
	public FilmDTO(int id, String title, String description, Timestamp lastUpdate, int length, String rating,
			Date releaseYear, byte rentalDuration, BigDecimal rentalRate, BigDecimal replacementCost, byte idLanguage,
			byte idVO) {
		this.idFilm = id;
		this.title = title;
		this.description = description;
		this.lastUpdate = lastUpdate;
		this.length = length;
		this.rating = rating;
		this.releaseYear = releaseYear;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.replacementCost = replacementCost;
		this.idLanguage = idLanguage;
		this.idVO = idVO;
	}
	public int getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(int id) {
		this.idFilm = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Date getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}
	public byte getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(byte rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public BigDecimal getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}
	public BigDecimal getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}
	public byte getIdLanguage() {
		return idLanguage;
	}
	public void setIdLanguage(byte idLanguage) {
		this.idLanguage = idLanguage;
	}
	public byte getIdVO() {
		return idVO;
	}
	public void setIdVO(byte idVO) {
		this.idVO = idVO;
	}
	@Override
	public String toString() {
		return "FilmDTO [id=" + idFilm + ", title=" + title + "]";
	}
	public static Film form(FilmDTO source) {
		Film target = new Film();
		target.setId(source.getIdFilm());
		target.setTitle(source.getTitle());
		target.setDescription(source.getDescription());
		Language language = new Language();
		language.setId(source.getIdLanguage());
		target.setLanguage(language);
		Language vo = new Language();
		vo.setId(source.getIdVO());
		target.setVO(vo);
//		target.setLastUpdate(source.getLastUpdate());
		target.setLength(source.getLength());
		target.setRating(source.getRating());
//		target.setReleaseYear(source.getReleaseYear());
		target.setRentalDuration(source.getRentalDuration());
		target.setRentalRate(source.getRentalRate());
		target.setReplacementCost(source.getReplacementCost());
		return target;
	}
	
	public static FilmDTO form(Film source) {
		return new FilmDTO(source.getId(), 
				source.getTitle(), 
				source.getDescription(), 
				source.getLastUpdate(), 
				source.getLength(), 
				source.getRating(), 
				source.getReleaseYear(), 
				source.getRentalDuration(), 
				source.getRentalRate(), 
				source.getReplacementCost(), 
				source.getLanguage().getId(), 
				source.getVO() != null ? source.getVO().getId() : 0);
	}
}
