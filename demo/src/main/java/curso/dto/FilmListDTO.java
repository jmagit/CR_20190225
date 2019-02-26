package curso.dto;

import java.io.Serializable;

import curso.model.Film;

public class FilmListDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	
	public FilmListDTO() { }
	
	public FilmListDTO(int id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "FilmListDTO [id=" + id + ", title=" + title + "]";
	}
	
	public static Film form(FilmListDTO source) {
		Film target = new Film();
		target.setId(source.getId());
		target.setTitle(source.getTitle());
		return target;
	}
	
	public static FilmListDTO form(Film source) {
		return new FilmListDTO(source.getId(), source.getTitle());
	}

}
