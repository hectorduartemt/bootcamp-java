package practica.adicional.semana4;

import java.util.ArrayList;
import java.util.Iterator;

import practica.adicional.interfaces.Aterrizable;
import practica.adicional.relaciones.Avion;
import practica.adicional.relaciones.Helicoptero;
import practica.adicional.relaciones.Ovni;
import practica.adicional.relaciones.Superman;
import practica.adicional.relaciones.Voladores;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Avion avion = new Avion("Antonov", "Comercial", 50);
        Helicoptero helicoptero = new Helicoptero("Papaya", "Militar", 50);
        Superman superman = new Superman("Clark","Heroe",10);
        Ovni ovni = new Ovni("Mars", "No identificado", 40);
        
        ArrayList<Voladores> listaVoladores = new ArrayList();
        
        listaVoladores.add(avion);
        listaVoladores.add(helicoptero);
        listaVoladores.add(superman);
        listaVoladores.add(ovni);
        
        for (int i = 0; i < listaVoladores.size(); i++) {
			if(listaVoladores.get(i) instanceof Aterrizable) {
				System.out.println(listaVoladores.get(i).getTipo()+" Puede Aterrizar");
			}else {
				System.out.println(listaVoladores.get(i).getTipo()+" No Puede Aterrizar");
			}
			
		}
        
        
        
    }
}
