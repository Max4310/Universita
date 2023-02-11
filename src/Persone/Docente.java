package Persone;

import Esame.*;
import Facolta.Facolta_I;
import com.fasterxml.jackson.annotation.JsonGetter;


public class Docente extends Persona {
    private String idDocente;
    private int indexFacolta;

    
    public Docente(String nome, String cognome){
        super(nome,cognome);
    }

    public Docente(){

    }

    public Docente(String nome,String cognome, String id){
        super(nome,cognome);
        this.idDocente = id;
    }
    
    public String toString(){
        return "{ "+super.nome + ", "+super.cognome + ", id: " + this.idDocente +" }";
    }
    @JsonGetter
    public String getId(){
        return this.idDocente;
    }
    
    public void setId(String id){
        this.idDocente = id;
    }

    @JsonGetter
    public int getIndexFacolta() {
        return indexFacolta;
    }

    public void setIndexFacolta(int indexFacolta) {
        this.indexFacolta = indexFacolta;
    }

    public boolean equals(Docente docente){
        return docente.getId().equals(this.idDocente);
    }

    public void postaEsame(Facolta_I facolta, Esame esame){
        facolta.remoteEsame();
        facolta.setEsameAttivo(new EsameAttivo(esame.getNomeEsame(), this));
    }

    public void chiudiEsame(Facolta_I facolta){
        facolta.setEsameAttivo(null);
    }
}
