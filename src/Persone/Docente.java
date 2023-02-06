/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persone;

import Facolta.Facolta_I;

import javax.print.Doc;

/**
 *
 * @author STUDENTE
 */
public class Docente extends Persona {
    private String idDocente;
    private int indexFacolta;

    
    public Docente(String nome, String cognome){
        super(nome,cognome);
    }
    
    public Docente(String nome,String cognome, String id){
        super(nome,cognome);
        this.idDocente = id;
    }
    
    public String toString(){
        return "{ "+super.nome + ", "+super.cognome + ", id: " + this.idDocente +" }";
    }
    
    public String getId(){
        return this.idDocente;
    }
    
    public void setId(String id){
        this.idDocente = id;
    }

    public int getIndexFacolta() {
        return indexFacolta;
    }

    public void setIndexFacolta(int indexFacolta) {
        this.indexFacolta = indexFacolta;
    }

    public boolean equals(Docente docente){
        return docente.getId().equals(this.idDocente);
    }
}
