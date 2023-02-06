/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facolta;
import Persone.Docente;
import Persone.Studente;
import universita.Esame;
import universita.EsameAttivo;

import java.util.ArrayList;


/**
 *
 * @author STUDENTE
 */
abstract public class Facolta_C implements Facolta_I{
    protected ArrayList<Studente> studenti; //lista di tutti i studenti della facolta
    protected ArrayList<Docente> docenti; //lista di tutti i docenti
    protected ArrayList<Esame> esamiCompleti; //lista di tutti gli esami della facolta
    protected static int lastDocente;
    protected static int lastStudente;
    protected EsameAttivo esameAttivo;

    @Override
    public Studente getStudente(String id) {
        if(studenti.isEmpty()) return null;

        for(Studente studente : this.studenti){
            if(studente.getId().equals(id)){
                return studente;
            }
        }

        return null;
    }

    @Override
    public Docente getDocente(String id) {
        if(docenti.isEmpty()) return null;

        //System.out.println(this.getIdFacolta());

        for(Docente docente : this.docenti){
            if(docente.getId().equals(id)){
                return docente;
            }
        }

        return null;
    }

    @Override
    public void addDocente(Docente docente) {
        lastDocente++; //aumento questo campo cosi da evitare che docenti diversi abbiano stesso id
        this.docenti.add(docente);
    }

    @Override
    public void addStudente(Studente studente) {
        lastStudente++; //auento questo campo cosi da evitare che studenti diversi abbiamo lo stesso id
        // (con lista.size nn si poteva fare perche ci sono l'id deve essere univoco in tutta l'uni e nn solo nella facolta)
        this.studenti.add(studente);
    }

    @Override
    public ArrayList<Studente> getStudenti() {
        return this.studenti;
    }

    @Override
    public ArrayList<Docente> getDocenti() {
        return this.docenti;
    }

    @Override
    public int getLastDocente(){
        return lastDocente;
    }

    @Override
    public int getLastStudente(){
        return lastStudente;
    }

    @Override
    public EsameAttivo getEsameAttivo() {
        return this.esameAttivo;
    }

    @Override
    public void setEsameAttivo(EsameAttivo esameAttivo){
        this.esameAttivo = esameAttivo;
    }

    @Override
    public Esame getNextEsame() {
        //prendo il prossimo esame

        if(this.esamiCompleti.isEmpty()){
            return null;
        }
        else {
            return this.esamiCompleti.get(0);
        }
    }

    @Override
    public void remoteEsame() {
        //rimuovo il rpossio esame controllo che nn sia null per evitare dei crush (controllo che sicuro rifarò anche nel main perche mi scordo di averlo fatto qui)

        Esame esame  = this.getNextEsame();
        if(esame != null){
            this.esamiCompleti.remove(esame);
        }

    }

    @Override
    public ArrayList<Esame> getEsami() {
        return this.esamiCompleti;
    }
}
