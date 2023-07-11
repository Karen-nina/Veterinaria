package ar.edu.unlam.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.dominio.Atencion;
import ar.edu.unlam.dominio.AtencionDuplicadaException;
import ar.edu.unlam.dominio.Duenio;
import ar.edu.unlam.dominio.DuenioDuplicadoException;
import ar.edu.unlam.dominio.Mascota;
import ar.edu.unlam.dominio.MascotaDuplicadaException;
import ar.edu.unlam.dominio.Medicamento;
import ar.edu.unlam.dominio.TipoDeMascota;
import ar.edu.unlam.dominio.Veterinaria;

public class TestVeterinaria {

	@Test
	public void queSePuedaInstanciarUnaVeterinariaConNombre() {
			Veterinaria veterinaria = new Veterinaria("pupis");
			
			assertNotNull(veterinaria);
	}

	@Test
	public void queSePuedaCrearUnDuenioConDniYConNombre() {
		Duenio duenio = new Duenio(01,94502618,"karen");
		assertNotNull(duenio);
	}
	
	@Test
	public void queSePuedaCrearUnaMascotaConNombreIdApodoYTipoDeMascota() {
		Mascota mascota = new Mascota(03,"gato","tomas", TipoDeMascota.Domestica);
		assertNotNull(mascota);
	}
	
	@Test 
	public void queSePuedaAgregarDosMascotasAUnDuenio() throws Exception{
		Duenio duenio = new Duenio(01,94502618,"karen");
		Mascota mascota = new Mascota(03,"gato","tomas", TipoDeMascota.Domestica);
		Mascota mascota2 = new Mascota(02,"gato","mau", TipoDeMascota.Domestica);
		duenio.agregarMascota(mascota);
		duenio.agregarMascota(mascota2);
		
		Integer valorEsperado = 2; 
		Integer valorObtenido = duenio.getMascotas().size(); 
		
		assertFalse(duenio.getMascotas().isEmpty());
		assertEquals(valorEsperado, valorObtenido);
		
	}

	@Test (expected = MascotaDuplicadaException.class)
	public void queAlAgregarDosMascotasConMismoIdParaUnMismoDuenioLanceUnaExcepcionMascotaDuplicadaException() throws Exception {
		Duenio duenio = new Duenio(01,94502618,"karen");
		
		Mascota mascota = new Mascota(03,"gato","tomas", TipoDeMascota.Domestica);
		Mascota mascota2 = new Mascota(03,"gato","mau", TipoDeMascota.Domestica);
		
		duenio.agregarMascota(mascota);
		duenio.agregarMascota(mascota2);
	}
	
	@Test
	public void queSePuedaCrearUnMedicamentoConIdDescripcionYPrecio() {
		Medicamento medicamento = new Medicamento(01, "antibiotico", 235.5);
		assertNotNull(medicamento);
	}
	
	@Test (expected = DuenioDuplicadoException.class)
	public void queSePuedanAgregarDueniosDeMascotasAUnaVeterinaria() throws Exception {
		Veterinaria veterinaria = new Veterinaria("pupis");
		
		Duenio duenio = new Duenio(01,94502618,"karen");
		Duenio duenio2 = new Duenio(01,94502613,"mirta");
		Duenio duenio3 = new Duenio(02,94502619,"carlos");
		
		veterinaria.agregarDueniosAVeterinaria(duenio); 
		veterinaria.agregarDueniosAVeterinaria(duenio2);
		veterinaria.agregarDueniosAVeterinaria(duenio3);
		
	}
	
	@Test (expected = AtencionDuplicadaException.class)
	public void queSePuedaCrearUnaAtencionConIdDeDuenioIdDeMascotaYPrecio() throws Exception {
		Veterinaria veterinaria = new Veterinaria("pupis");
		Mascota mascota = new Mascota(03,"gato","tomas", TipoDeMascota.Domestica);
		Duenio duenio = new Duenio(01,94502618,"karen");
		Atencion atencion = new Atencion(01,duenio, mascota, 505.8);
		Atencion atencion2 = new Atencion(01,duenio, mascota, 505.8);
		
		duenio.agregarMascota(mascota);
		veterinaria.agregarDueniosAVeterinaria(duenio); 
		
		veterinaria.agregarAtencion(atencion);
		veterinaria.agregarAtencion(atencion2);
	}
	
	@Test
	public void queSePuedaAsignarVariosMedicamentosAUnaAtencion() throws Exception {
		// Para asignar un medicamento necesita el id de la atencion y el id del medicamento
		Veterinaria veterinaria = new Veterinaria("pupis");
		Mascota mascota = new Mascota(03,"gato","tomas", TipoDeMascota.Domestica);
		Duenio duenio = new Duenio(01,94502618,"karen");
		duenio.agregarMascota(mascota);
		veterinaria.agregarDueniosAVeterinaria(duenio); 
		
		Medicamento medicamento = new Medicamento(01, "antibiotico", 235.5);
		Medicamento medicamento2 = new Medicamento(02, "analgesia", 130.0);
		Medicamento medicamento3 = new Medicamento(03, "suero", 150.0);
		
		veterinaria.agregarMedicamentoAlStockVeterinaria(medicamento);
		veterinaria.agregarMedicamentoAlStockVeterinaria(medicamento2);
		veterinaria.agregarMedicamentoAlStockVeterinaria(medicamento3);
		
		Atencion atencion = new Atencion(01,duenio, mascota, 505.8);
		veterinaria.agregarMedicamentosALaAtencion(atencion.getId(), medicamento.getId());
		veterinaria.agregarMedicamentosALaAtencion(atencion.getId(), medicamento2.getId());
		veterinaria.agregarMedicamentosALaAtencion(atencion.getId(), medicamento3.getId());
		
		Integer valorEsperado = 3; 
		Integer valorObtenido = atencion.getMedicamentos().size();
		
		assertEquals(valorEsperado,valorObtenido);
		assertFalse(atencion.getMedicamentos().isEmpty());
	
	}
	
	@Test
	public void queSePuedaCalcularElPrecioTotalDeUnaAtencion() {
		// El precio total de la atencion será la suma del precio de la atencion mas la suma del precio de todos los medicamentos
		
		
	}
	
	@Test
	public void queSePuedaObtenerDeUnDuenioUnaListaDeMascotasDomesticasOrdenadasPorApodo() {
		
	}
	
	@Test
	public void queSePuedaObtenerUnMapaConIdDeAtencionYIdDeMascota() {
		
	}

}
