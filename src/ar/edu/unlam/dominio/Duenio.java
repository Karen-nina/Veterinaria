package ar.edu.unlam.dominio;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Duenio {

	private Integer id;
	private Integer dni;
	private String nombre;
	private Set<Mascota> mascotas;
	
	public Duenio(Integer id, Integer dni, String nombre) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.mascotas = new TreeSet<Mascota>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(Set<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public void agregarMascota(Mascota mascota) throws Exception {
		for (Mascota m : mascotas) {
			if (m.getId().equals(mascota.getId())) {
				throw new MascotaDuplicadaException("mascota con id ya existente");
			}
		}this.mascotas.add(mascota);
		
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
		Duenio other = (Duenio) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
