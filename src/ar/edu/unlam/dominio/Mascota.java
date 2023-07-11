package ar.edu.unlam.dominio;

import java.util.Objects;

public class Mascota implements Comparable<Mascota>{

	private Integer id;
	private String nombre;
	private String apodo;
	private TipoDeMascota tipo;
	public Mascota(Integer id,String nombre, String apodo, TipoDeMascota tipo) {
		super();
		this.id = id;
		this.apodo = apodo;
		this.tipo = tipo;
		this.nombre =  nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
	public TipoDeMascota getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeMascota tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mascota other = (Mascota) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public int compareTo(Mascota o) {
		
		return this.id.compareTo(o.getId());
	}
	
	
}
