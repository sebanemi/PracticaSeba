package parcial2;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Gpt01_LeePal {
    private String nombre;
    private String categoria;
    private int precio;
    private char disp;

    public Gpt01_LeePal(FileInputStream fis) throws IOException {
        int nombreLen = fis.read();
        if (nombreLen ==-1){
            throw new IOException("No se puede leer el archivo");
        }
        byte[] nombreBytes = new byte[nombreLen];
        fis.read(nombreBytes);

        int categoriaLen = fis.read();
        if (categoriaLen ==-1){
            throw new IOException("No se puede leer el archivo");
        }
        byte[] categoriaBytes = new byte[categoriaLen];
        fis.read(categoriaBytes);

        byte[] precioBytes = new byte[4];
        fis.read(precioBytes);

        byte[] dispBytes = new byte[1];
        fis.read(dispBytes);

        this.nombre = new String(nombreBytes, StandardCharsets.UTF_8);
        this.categoria = new String(categoriaBytes, StandardCharsets.UTF_8);
        this.precio = ByteBuffer.wrap(precioBytes).getInt();
        this.disp = (char)dispBytes[0];
    }

    public String getNombre() {
        return nombre;
    }
    public String getCategoria() {
        return categoria;
    }
    public int getPrecio() {
        return precio;
    }
    public char getDisp() {
        return disp;
    }
}
