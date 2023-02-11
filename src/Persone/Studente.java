package Persone;

import Esame.EsameAttivo;
import Esame.EsameStudente;
import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Studente extends Persona{
    private String id;
    private int indexFacolta;
    private ArrayList<EsameStudente> esamiFatti;
    private boolean iscritto;
    public Studente(){

    }
    public Studente(String nome,String cognome, String id){
        super(nome,cognome);
        this.id = id;
        this.esamiFatti = new ArrayList<>();
        this.iscritto = false;
    }

    public Studente(String nome, String cognome) {
        super(nome, cognome);
    }
    
    public String toString(){
        String returnValue = "{ "+super.nome + ", "+super.cognome + " }";

        if(this.id != null){
            returnValue = returnValue.replace("}", ", id: "+ this.id+" }");

        }
        
        return returnValue;
    }

    @JsonGetter
    public String getId(){
        return this.id;
    }

    public void setIdStudente(String idStudente) {
        this.id = idStudente;
    }

    @JsonGetter
    public int getIndexFacolta() {
        return indexFacolta;
    }

    public void setIndexFacolta(int indexFacolta) {
        this.indexFacolta = indexFacolta;
    }

    @JsonGetter
    public boolean isIscritto() {
        return iscritto;
    }

    public void setIscritto(boolean iscritto) {
        this.iscritto = iscritto;
    }

    @JsonGetter
    public ArrayList<EsameStudente> getEsamiFatti() {
        return esamiFatti;
    }

    public void addEsame(EsameStudente esameStudente){
        this.esamiFatti.add(esameStudente);
        this.iscritto = false;
    }

    public boolean isGiaFatto (EsameAttivo esameAttivo){
        if(this.esamiFatti.isEmpty()) return false;

        for(EsameStudente esameStudente : this.esamiFatti){
            if(esameStudente.getNomeEsame().equals(esameAttivo.getNomeEsame())){
                return true;
            }
        }

        return false;
    }

    public void iscrivitiEsame(EsameAttivo esameAttivo){
        this.setIscritto(true);
        esameAttivo.addStudente(this);
    }

    public float faiEsame(EsameAttivo esameAttivo){
        float voto = (float) Math.round(ThreadLocalRandom.current().nextDouble(5.0,30.0)*100)/100;;
        EsameStudente esameStudente = new EsameStudente(esameAttivo.getNomeEsame(), voto);
        esameAttivo.removeStudente(this);

        this.addEsame(esameStudente);
        this.setIscritto(false);

        return voto;
    }


}
