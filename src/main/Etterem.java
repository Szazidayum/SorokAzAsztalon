package main;

import java.util.ArrayList;

public class Etterem {
    private ArrayList<Asztal> asztalok;
    
    public Etterem(){
        asztalok = new ArrayList<>();
        Asztal a = new Asztal();
        a.felvesz(new Sor("Kőbányai", 200));
        a.felvesz(new Sor("Kőbányai", 200));
        a.felvesz(new Sor("Kőbányai", 200));
        a.felvesz(new Sor("Dreher", 150));
        a.felvesz(new Sor("Dreher", 150));
        asztalok.add(a);
        
        a = new Asztal(true);
        a.felvesz(new Sor("Kőbányai", 200));
        a.felvesz(new Sor("Dreher", 150));
        a.felvesz(new Sor("Dreher", 150));
        asztalok.add(a);
        
        fizetoAsztalok();
    }
    
    public void fizetoAsztalok(){
        System.out.println("Fizető asztalok:");
        for (Asztal asztal : asztalok) {
            System.out.println(asztal.kimutatas());
        }
    }
}
