package ar.edu.unlam.dominio;

import java.util.Comparator;

public class OrdenPorApodo implements Comparator<Mascota>{

	@Override
	public int compare(Mascota o1, Mascota o2) {
		
		return o1.getApodo().compareTo(o2.getApodo());
	}

}
