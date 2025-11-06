package parcial2;

import java.util.*;

public class Gpt01_AsignaPal {
    private Map<String, List<Gpt01_LeePal>> datos;

    public Gpt01_AsignaPal() {
        datos = new TreeMap<String, List<Gpt01_LeePal>>(Collections.reverseOrder());
    }

    public void asignaPal(Gpt01_LeePal registro) {
        char disp = registro.getDisp();
        if(disp == 'D'){
            String categoria = registro.getCategoria();

            if(!datos.containsKey(categoria)){
                datos.put(categoria, new ArrayList<>());
            }
            datos.get(categoria).add(registro);
            datos.get(categoria).sort(Comparator.comparingInt(Gpt01_LeePal::getPrecio).reversed());
        }
    }

    public Map<String, List<Gpt01_LeePal>> getDatos() {
        return datos;
    }

    public void mostrarDatos(){
        for(Map.Entry<String, List<Gpt01_LeePal>> entry : datos.entrySet()){
            String categoria = entry.getKey();
            System.out.println("Categoria: " + categoria);
            for(Gpt01_LeePal registro : entry.getValue()){
                System.out.println(" -Producto: " + registro.getNombre() + " | Precio: " + registro.getPrecio());
            }
            System.out.println();
        }
    }
}
