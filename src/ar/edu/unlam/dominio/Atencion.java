package ar.edu.unlam.dominio;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;


public class Atencion {

	private Integer id;
	private Duenio duenio;
	private Mascota mascota;
	private Double precio;
	private List<Medicamento> medicamentos;
	
	public Atencion(Integer id, Duenio duenio, Mascota mascota, Double precio) {
		super();
		this.id = id;
		this.duenio = duenio;
		this.mascota = mascota;
		this.precio = precio;
		this.medicamentos = new ArrayList<Medicamento>();
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
	
	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(List<Medicamento> medicamentos) {
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
	public void agregarMedicamentos(Medicamento medicamento){
		this.medicamentos.add(medicamento);
		
	}
	public Double calcularCostoTotal() {
		Double aux = this.precio;
		for (Medicamento medicamento : medicamentos)
			aux += medicamento.getPrecio();
			return aux;
	
	}
	
	
}
