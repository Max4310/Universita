package Facolta;

import Esame.Esame;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;

@JsonTypeName("matematica")
@JsonDeserialize(as = Matematica.class)

public class Matematica extends Facolta_C implements Facolta_I{

    public Matematica(){
        this.studenti = new ArrayList<>();
        this.docenti = new ArrayList<>();
        lastDocente = 0;
        lastStudente = 0;
        this.esameAttivo = null;
        ArrayList<Esame> esami = new ArrayList<>();

        esami.add(new Esame("analisi 1"));
        esami.add(new Esame("analisi 2"));
        esami.add(new Esame("Geometria A"));
        esami.add(new Esame("Algebra A"));
        this.setEsami(esami);

    }

    @Override
    @JsonIgnore
    public String getIdFacolta() {
        return "matematica";
    }

    @Override
    public String toString() {
        return "{ "+this.getIdFacolta()+" Numero Docenti: " + this.docenti.size() + ", Numero Studenti: " + this.studenti.size() + " }";
    }
}
