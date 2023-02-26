package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Asztal {
    
    private ArrayList<Sor> sorok;
    private boolean abrosz;

    public Asztal() {
       this(false);
    }

    public Asztal(boolean abrosz) {
        this.abrosz = abrosz;
        sorok = new ArrayList<>();
    }

    
    public void felvesz(Sor sor){
        sorok.add(sor);
    }
    
    public String kimutatas(){
        String a = abrosz ? "abrosszal" : "abrosz nélkül";
        String kimutatas = String.format("Fogyasztás (%s):\n", a);
        kimutatas += tetelek();
        kimutatas += "---------------------\nÖsszesen: ";
        kimutatas += osszFogy();
        kimutatas += "\n";
        
        return kimutatas;
    }
    
    private String tetelek(){
        String t = "";
        for (Map.Entry<String, Integer> entry : mibolMennyi().entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            t += String.format("%s: %d\n", key, value);
        }
        
        return t;
    }

    private Map<String, Integer> mibolMennyi() {
        Map<String, Integer> mm = new HashMap<>();
        for (Sor sor : sorok) {
            String kulcs = sor.getMarka();
            if(mm.containsKey(kulcs)){
                int db = mm.get(kulcs);
                mm.put(kulcs, ++db);
            }else{
                mm.put(kulcs, 1);
            }
        }
        return mm;
    }
    
    private int osszFogy(){
        int ossz = 0;
        for (Sor sor : sorok) {
            ossz += sor.getAr();
        }
        return ossz;
    }
}
