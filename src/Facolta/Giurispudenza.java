package Facolta;

import universita.Esame;

import java.util.ArrayList;

public class Giurispudenza extends Facolta_C implements Facolta_I{

    public Giurispudenza(){
        this.studenti = new ArrayList<>();
        this.docenti = new ArrayList<>();
        lastDocente = 0;
        lastStudente = 0;
        this.esameAttivo = null;
        this.esamiCompleti = new ArrayList<>();

        this.esamiCompleti.add(new Esame("Scienze penitenziarie", this));
        this.esamiCompleti.add(new Esame("Criminologia", this));
        this.esamiCompleti.add(new Esame("Digital marketing", this));
        this.esamiCompleti.add(new Esame("Scienze politiche e sociali", this));

    }

    @Override
    public String getIdFacolta() {
        return "giurispudenza";
    }

    @Override
    public String toString() {
        return "{ "+this.getIdFacolta()+" Numero Docenti: " + this.docenti.size() + ", Numero Studenti: " + this.studenti.size() + " }";
    }
}
