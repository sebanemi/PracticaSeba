package demo;

import java.util.HashMap;
import java.util.Map;

public class Persona {
    private Map<String, String> m = new HashMap<>();

    public Persona(Map<String, String> mapa) {
        this.m = mapa;
    }
    public Map<String,String> getMapa(){
        return this.m;
    }
}
