package Facolta;

import Esame.Esame;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;

@JsonTypeName("informatica")
@JsonDeserialize(as = Informatica.class)

public class Informatica extends Facolta_C implements Facolta_I{

    public Informatica(){
        this.studenti = new ArrayList<>();
        this.docenti = new ArrayList<>();
        lastDocente = 0;
        lastStudente = 0;
        this.esameAttivo = null;

        ArrayList<Esame> esami = new ArrayList<>();


        esami.add(new Esame("analisi 1"));
        esami.add(new Esame("Reti 1"));
        esami.add(new Esame("Inglese 1"));
        esami.add(new Esame("Programmazione 1"));
        this.setEsami(esami);


        //this.esamiCompleti = new ArrayList<>();


        //this.docenti.add(new Docente("fds","dfs"));
    }

    @Override
    @JsonIgnore
    public String getIdFacolta() {
        return "informatica";
    }

    @Override
    public String toString() {
        return "{ "+this.getIdFacolta()+" Numero Docenti: " + this.docenti.size() + ", Numero Studenti: " + this.studenti.size() + " }";
    }
}
