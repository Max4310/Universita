/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persone;
import universita.Esame;
import universita.EsameAttivo;
import universita.EsameStudente;

import java.util.ArrayList;

/**
 *
 * @author STUDENTE
 */
public class Studente extends Persona{
    private String idStudente;
    private int indexFacolta;
    private ArrayList<EsameStudente> esamiFatti;
    private boolean iscritto;
    
    public Studente(String nome,String cognome, String id){
        super(nome,cognome);
        this.idStudente = id;
        this.esamiFatti = new ArrayList<>();
        this.iscritto = false;
    }

    public Studente(String nome, String cognome) {
        super(nome, cognome);
    }
    
    public String toString(){
        String returnValue = "{ "+super.nome + ", "+super.cognome + " }";

        if(this.idStudente != null){
            returnValue = returnValue.replace("}", ", id: "+ this.idStudente+" }");

        }

        return returnValue;
    }
    
    public String getId(){
        return this.idStudente;
    }

    public void setIdStudente(String idStudente) {
        this.idStudente = idStudente;
    }

    public int getIndexFacolta() {
        return indexFacolta;
    }

    public void setIndexFacolta(int indexFacolta) {
        this.indexFacolta = indexFacolta;
    }

    public boolean isIscritto() {
        return iscritto;
    }

    public void setIscritto(boolean iscritto) {
        this.iscritto = iscritto;
    }

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


}
