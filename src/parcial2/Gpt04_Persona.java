package parcial2;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Gpt04_Persona {
    private String nombre;
    private int amigos;
    private List<String> amigosList;

    public Gpt04_Persona(FileInputStream fis) throws IOException {
        int n = fis.read();
        if(n == -1){
            throw new IOException("Error al leer nombre de persona");
        }
        byte[] nombreBytes = new byte[n];
        fis.read(nombreBytes);

        int a = fis.read();
        if(a == -1){
            throw new IOException("Error al leer cantidad de amigos");
        }

        amigosList = new ArrayList();
        for(int i = 0; i < a; i++){
            int m = fis.read();
            if(m == -1){
                throw new IOException("Error al leer nombre de amigos");
            }
            byte[] amigosBytes = new byte[m];
            fis.read(amigosBytes);
            String amigosString = new String(amigosBytes, StandardCharsets.UTF_8);
            amigosList.add(amigosString);
        }
        this.nombre = new String(nombreBytes, StandardCharsets.UTF_8);
        this.amigos = a;
    }

    public String getNombre() {
        return nombre;
    }
    public int getAmigos() {
        return amigos;
    }
    public List<String> getAmigosList() {
        return amigosList;
    }
}
