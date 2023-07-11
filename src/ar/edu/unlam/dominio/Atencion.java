package ar.edu.unlam.dominio;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Atencion {

	private Integer id;
	private Duenio duenio;
	private Mascota mascota;
	private Double precio;
	private Set<Medicamento> medicamentos;
	public Atencion(Integer id, Duenio duenio, Mascota mascota, Double precio) {
		super();
		this.id = id;
		this.duenio = duenio;
		this.mascota = mascota;
		this.precio = precio;
		this.medicamentos = new HashSet<Medicamento>();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Duenio getDuenio() {
		return duenio;
	}
	public void setDuenio(Duenio duenio) {
		this.duenio = duenio;
	}
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Set<Medicamento> getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(Set<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
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
		Atencion other = (Atencion) obj;
		return Objects.equals(id, other.id);
	}
	public void agregarMedicamentos(Medicamento medicamento) throws Exception {
		for (Medicamento m : medicamentos) {
			if (medicamento.getId().equals(medicamento.getId())) {
				throw new MedicamentoDuplicadoException("medicamento con id repetido");
			}
		} this.medicamentos.add(medicamento);
		
	}
	
	
}
