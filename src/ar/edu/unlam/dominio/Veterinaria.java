package ar.edu.unlam.dominio;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Veterinaria {

	private String nombre;
	private Set<Duenio> duenios;
	private List<Medicamento> stockMedicamento;
	private Set<Atencion> atencionesRealizadas;
	
	public Veterinaria(String nombre) {
		super();
		this.nombre = nombre;
		this.duenios = new HashSet<Duenio>();
		this.stockMedicamento = new ArrayList<Medicamento>();
		this.atencionesRealizadas = new HashSet<Atencion>();
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Duenio> getDuenios() {
		return duenios;
	}

	public void setDuenios(Set<Duenio> duenios) {
		this.duenios = duenios;
	}
	
	public List<Medicamento> getStockMedicamento() {
		return stockMedicamento;
	}

	public void setStockMedicamento(List<Medicamento> stockMedicamento) {
		this.stockMedicamento = stockMedicamento;
	}

	public Set<Atencion> getAtencionesRealizadas() {
		return atencionesRealizadas;
	}

	public void setAtencionesRealizadas(Set<Atencion> atencionesRealizadas) {
		this.atencionesRealizadas = atencionesRealizadas;
	}

	public void agregarDueniosAVeterinaria(Duenio duenio) throws Exception {
		for (Duenio d : duenios) {
			if (d.getId().equals(duenio.getId())) {
				throw new DuenioDuplicadoException("ya existe un duenio con mismo id en registro");
			}
		}this.duenios.add(duenio);
		
	}

	public void agregarAtencion(Atencion atencion) throws Exception {
		for (Atencion a : atencionesRealizadas) {
			if (a.getId().equals(atencion.getId())) {
				throw new AtencionDuplicadaException("atencion con id ya existente");
			}
		}this.atencionesRealizadas.add(atencion);
		
	}
	public void agregarMedicamentosALaAtencion(Atencion atencion, Medicamento medicamento) throws Exception {
		if(verificarStockMedicamento(medicamento.getDescripcion())) {
		atencion.agregarMedicamentos(medicamento);
		}
	}
	
	
	private boolean verificarStockMedicamento(String descripcion) {
		for (Medicamento m : stockMedicamento) {
			if (m.getDescripcion().equals(descripcion)) {
				return true;
			}
		}
		return false;
	}



	/*private Medicamento buscarMedicamentoPorDescripcionEnVeterinaria(String descripcion) throws Exception {
		for(Medicamento m : stockMedicamento) {
			if (m.getDescripcion().equals(descripcion)) {
				return m;
			}
		}
		throw new MedicamentoSinStock("medicamento sin stock en veterinaria");
	}



	private Atencion buscarAtencionPorId(Integer idAtencion) throws Exception {
		for (Atencion atencion : atencionesRealizadas) {
			if (atencion.getId().equals(idAtencion)) {
				return atencion;
			}
		}throw new AtencionInexistente("atencion con id ingresado inexistente");
	}
*/


	public void agregarMedicamentoAlStockVeterinaria(Medicamento medicamento){
		this.stockMedicamento.add(medicamento);
		
	}
	public Double calcularCostoTotalDeAtencion(Atencion atencion) {
		return atencion.calcularCostoTotal();	
	}
	public void ordenarMascotasPorApodoDeUnDuenio(Duenio duenio) {
		duenio.ordenarMascotasPorApodo();
		
	}
	
}
