package parcial2;

/*
1 byte  → t: cantidad de personas
Para cada persona:
    1 byte → longitud del nombre (n)
    n bytes → caracteres del nombre
    1 byte → cantidad de amigos (a)
    Para cada amigo:
        1 byte → longitud del nombre del amigo (m)
        m bytes → caracteres del nombre del amigo
 */

import java.io.FileInputStream;

public class Gpt04 {
    public static void main(String[] args) {
        String archivo = "DATOS04.dat";
        Gpt04_Agenda agenda = new Gpt04_Agenda();

        try(FileInputStream fis = new FileInputStream(archivo)){
            int t = fis.read();
            if(t == -1){
                System.out.println("Archivo vacío");
                return;
            }

            for(int i = 0; i < t; i++){
                Gpt04_Persona p = new Gpt04_Persona(fis);
                agenda.agendar(p);
            }

            agenda.mostrarLista();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al abrir archivo " + archivo);
        }
    }
}
