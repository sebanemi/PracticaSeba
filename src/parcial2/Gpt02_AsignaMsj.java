package parcial2;

import java.util.*;

public class Gpt02_AsignaMsj {
    private Map<String, List<Gpt02_LeeMsj>> datos;

    public Gpt02_AsignaMsj() {
        datos = new HashMap<>();
    }

    public void asignaMsj(Gpt02_LeeMsj msj) {
        String a = msj.getNombreReceptor();
        String b = msj.getNombreEmisor();
        String clave = (a.compareTo(b)<0)?(a + "<->" + b):(b + "<->" + a);
        if(!datos.containsKey(clave)){
            datos.put(clave, new ArrayList<>());
        }
        datos.get(clave).add(msj);
        datos.get(clave).sort(Comparator.comparing(Gpt02_LeeMsj::getTimestamp));
    }

    public void mostrarDatos(){

        List<Map.Entry<String, List<Gpt02_LeeMsj>>> lista = new ArrayList<>(datos.entrySet());
        lista.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

        for(Map.Entry<String, List<Gpt02_LeeMsj>> entry : lista){
            String conv = entry.getKey();
            System.out.println("\nConversación: " + conv);
            for(Gpt02_LeeMsj msj : entry.getValue()){
                System.out.println("  [" +msj.getTimestamp() + "] " + msj.getNombreEmisor() + ": " + msj.getContenido());
            }
        }
    }
}
