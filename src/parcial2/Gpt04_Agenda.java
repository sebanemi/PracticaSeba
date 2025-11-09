package parcial2;

import java.util.ArrayList;
import java.util.List;

public class Gpt04_Agenda {
    private List<Gpt04_Persona> personas;

    public Gpt04_Agenda(){
        personas = new ArrayList<Gpt04_Persona>();
    }

    public void agendar(Gpt04_Persona p){
        personas.add(p);
    }

    public void mostrarLista(){
        System.out.println("Lista de Personas:");
        for(Gpt04_Persona p : personas){
            String nombre = p.getNombre();
            int amigos = p.getAmigos();
            List<String> lista = p.getAmigosList();
            System.out.print(" -" + nombre + " tiene " + amigos + " amigos: ");
            for(String s : lista){
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
