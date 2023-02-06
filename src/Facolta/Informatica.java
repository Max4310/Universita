package Facolta;

import Persone.Docente;
import universita.Esame;

import java.util.ArrayList;

public class Informatica extends Facolta_C implements Facolta_I{

    public Informatica(){
        this.studenti = new ArrayList<>();
        this.docenti = new ArrayList<>();
        lastDocente = 0;
        lastStudente = 0;
        this.esameAttivo = null;
        this.esamiCompleti = new ArrayList<>();

        this.esamiCompleti.add(new Esame("analisi 1", this));
        this.esamiCompleti.add(new Esame("Reti 1", this));
        this.esamiCompleti.add(new Esame("Inglese 1", this));
        this.esamiCompleti.add(new Esame("Programmazione 1", this));
        //this.esamiCompleti = new ArrayList<>();


        //this.docenti.add(new Docente("fds","dfs"));
    }

    @Override
    public String getIdFacolta() {
        return "informatica";
    }

    @Override
    public String toString() {
        return "{ "+this.getIdFacolta()+" Numero Docenti: " + this.docenti.size() + ", Numero Studenti: " + this.studenti.size() + " }";
    }
}
