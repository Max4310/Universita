package Facolta;

import universita.Esame;

import java.util.ArrayList;

public class Matematica extends Facolta_C implements Facolta_I{

    public Matematica(){
        this.studenti = new ArrayList<>();
        this.docenti = new ArrayList<>();
        lastDocente = 0;
        lastStudente = 0;
        this.esameAttivo = null;
        this.esamiCompleti = new ArrayList<>();


        this.esamiCompleti.add(new Esame("analisi 1", this));
        this.esamiCompleti.add(new Esame("analisi 2", this));
        this.esamiCompleti.add(new Esame("Geometria A", this));
        this.esamiCompleti.add(new Esame("Algebra A", this));
    }

    @Override
    public String getIdFacolta() {
        return "matematica";
    }

    @Override
    public String toString() {
        return "{ "+this.getIdFacolta()+" Numero Docenti: " + this.docenti.size() + ", Numero Studenti: " + this.studenti.size() + " }";
    }
}
