package parcial2;

/*
El archivo contiene información sobre productos registrados en distintas categorías.
Su estructura binaria es la siguiente:
    1 byte → t: cantidad de productos en el archivo.
    Para cada producto:
        1 byte → longitud del nombre (n).
        n bytes → caracteres del nombre del producto.
        1 byte → longitud de la categoría (c).
        c bytes → caracteres de la categoría (por ejemplo: “Lácteos”, “Electrónica”).
        4 bytes (int) → precio del producto en pesos.
        1 byte (char) → indicador de disponibilidad:
        'D' = disponible
        'N' = no disponible
Se pide agrupar los productos por categoría, mostrando cada categoría en orden alfabético inverso, y dentro de cada una, los productos ordenados por precio de mayor a menor.
Además, solo deben mostrarse aquellos productos disponibles (D).
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Gpt01 {
    public static void main(String[] args) throws IOException {
        String archivo = "DATOS01.dat";
        Gpt01_AsignaPal asignador = new Gpt01_AsignaPal();

        try(FileInputStream fis = new FileInputStream(archivo)){
            int t = fis.read();
            if(t==-1){
                System.out.println("Archivo vacio");
                return;
            }

            System.out.println("Cantidad de registros: " + t);

            for(int i=0; i<t; i++){
                Gpt01_LeePal registro = new Gpt01_LeePal(fis);
                asignador.asignaPal(registro);
            }

            System.out.println("-------INFO------");
            asignador.mostrarDatos();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
