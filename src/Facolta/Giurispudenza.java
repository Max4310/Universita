package Facolta;

import Esame.Esame;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;

@JsonTypeName("giurisprudenza")
@JsonDeserialize(as = Giurispudenza.class)
public class Giurispudenza extends Facolta_C implements Facolta_I{

    public Giurispudenza(){
        this.studenti = new ArrayList<>();
        this.docenti = new ArrayList<>();
        lastDocente = 0;
        lastStudente = 0;
        this.esameAttivo = null;


        ArrayList<Esame> esami = new ArrayList<>();


        esami.add(new Esame("Scienze penitenziarie"));
        esami.add(new Esame("Criminologia"));
        esami.add(new Esame("Digital marketing"));
        esami.add(new Esame("Scienze politiche e sociali"));

        this.setEsami(esami);


    }

    @Override
    @JsonIgnore
    public String getIdFacolta() {
        return "giurispudenza";
    }

    @Override
    public String toString() {
        return "{ "+this.getIdFacolta()+" Numero Docenti: " + this.docenti.size() + ", Numero Studenti: " + this.studenti.size() + " }";
    }
}
