package Esame;

import Persone.Docente;
import Persone.Studente;

import java.util.ArrayList;

public class EsameAttivo extends Esame{
    private ArrayList<Studente> studentiIscritti;
    private Docente esaminatore;

    public EsameAttivo(){

    }
    public EsameAttivo(String nomeEsame, Docente esaminatore) {
        super(nomeEsame);
        this.studentiIscritti = new ArrayList<>();
        this.esaminatore = esaminatore;

        //this.studentiIscritti.add(new Studente("amx","ffsd"));
        //this.studentiIscritti.add(new Studente("fdsfd","uewo"));
    }

    public ArrayList<Studente> getStudentiIscritti() {
        return studentiIscritti;
    }

    public Docente getEsaminatore() {
        return esaminatore;
    }

    public void addStudente(Studente studente){
        studentiIscritti.add(studente);
    }

    public void removeStudente(Studente studente){
        studentiIscritti.remove(studente);
    }

    public boolean isIscritto (Studente studente){
        return studentiIscritti.contains(studente);
    }

    public String toString(){
        return "{ Nome Esame: " + this.getNomeEsame() + "\nDocente: " + this.esaminatore.toString() + ", Numero Iscritti: " +
                this.studentiIscritti.size() + " }";
    }
}
