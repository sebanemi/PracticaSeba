package parcial2;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Gpt02_LeeMsj {
    private String nombreEmisor;
    private String nombreReceptor;
    private String contenido;
    private int timestamp;

    public Gpt02_LeeMsj(FileInputStream fis) throws IOException {
        int e = fis.read();
        if(e==-1){
            throw new IOException();
        }
        byte[] emisorBytes = new byte[e];
        fis.read(emisorBytes);

        int r = fis.read();
        if(r==-1){
            throw new IOException();
        }
        byte[] receptorBytes = new byte[r];
        fis.read(receptorBytes);

        int c = fis.read();
        if(c==-1){
            throw new IOException();
        }
        byte[] contenidoBytes = new byte[c];
        fis.read(contenidoBytes);

        byte[] timeBytes = new byte[4];
        fis.read(timeBytes);

        this.nombreEmisor = new String(emisorBytes, StandardCharsets.UTF_8);
        this.nombreReceptor = new String(receptorBytes, StandardCharsets.UTF_8);
        this.contenido = new String(contenidoBytes, StandardCharsets.UTF_8);
        this.timestamp = ByteBuffer.wrap(timeBytes).getInt();
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }
    public String getNombreReceptor() {
        return nombreReceptor;
    }
    public String getContenido() {
        return contenido;
    }
    public int getTimestamp() {
        return timestamp;
    }

}
