package parcial2;

/*
El archivo contiene una serie de mensajes enviados entre usuarios.
Su estructura binaria es la siguiente:
    1 byte → t: cantidad de mensajes.
    Para cada mensaje:
        1 byte → longitud del emisor (e).
        e bytes → caracteres del nombre del emisor.
        1 byte → longitud del receptor (r).
        r bytes → caracteres del nombre del receptor.
        1 byte → longitud del contenido (c).
        c bytes → caracteres del mensaje.
        4 bytes (int) → timestamp (segundos desde 0).
Se debe reconstruir las conversaciones entre cada par de usuarios (emisor-receptor), ordenando los mensajes cronológicamente según el timestamp.
Luego, mostrar las conversaciones en orden por cantidad total de mensajes (de mayor a menor).
 */

import java.io.FileInputStream;
import java.io.IOException;

public class Gpt02 {
    public static void main(String[] args){
        String archivo = "DATOS02.dat";
        Gpt02_AsignaMsj asignador = new Gpt02_AsignaMsj();

        try(FileInputStream fis = new FileInputStream(archivo)){
            int t = fis.read();
            if(t==-1){
                System.out.println("ARCHIVO VACIO");
                return;
            }

            System.out.println("Cantidad de registros: " + t);

            for(int i = 0; i<t; i++){
                Gpt02_LeeMsj registro = new Gpt02_LeeMsj(fis);
                asignador.asignaMsj(registro);
            }

            asignador.mostrarDatos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
