package demo;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.*;

public class Principal {
    public static void main(String[] args) throws FileNotFoundException {
        //Lista con todos los campos posibles
        List<String> campos = new ArrayList<>();
        //Lista de personas
        List<Persona> personas = new ArrayList<>();
        int contador = 1;
        System.out.print("INGRESE CAMPO 1: ");
        Scanner sc = new Scanner(System.in);
        String campo = sc.nextLine();
        while (!campo.equals("-")) {
            campos.add(campo.toUpperCase());
            contador++;
            System.out.print("INGRESE CAMPO " + contador + ": ");
            campo = sc.nextLine();
        }
        System.out.println("############\nINGRESO DE DATOS");
        char opcion = 'y';
        contador = 0;
        while(opcion == 'y'){
            contador++;
            Map<String, String> datos = new LinkedHashMap<>();
            System.out.println("DATOS PERSONA " +  contador + ": ");
            for(int i = 0; i < campos.size(); i++) {
                System.out.print("INGRESE " + campos.get(i) + ": ");
                String valor = sc.nextLine();
                if(!valor.equals("-")) {
                    datos.put(campos.get(i), valor);
                }
            }
            personas.add(new Persona(datos));
            System.out.println("############\n¿Agregar otra persona?");
            opcion = sc.nextLine().charAt(0);
        }
        System.out.println("############\nMUESTRA DE DATOS");
        for(int i = 0; i < personas.size(); i++) {

            System.out.println("  Persona " + (i+1)+":");
            Map<String,String> mapa = personas.get(i).getMapa();
            for(Map.Entry<String, String> info : mapa.entrySet()) {
                String key = info.getKey();
                String value = info.getValue();
                System.out.println("    " + key + ": " + value);
            }
        }

        System.out.println("################");
        System.out.println("FIN DEL PROGRAMA");
        GuardarAgenda.guardarAgenda(personas,"MiAgenda.txt");
        sc.close();
    }
}
