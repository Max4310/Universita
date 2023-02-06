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
public interface Facolta_I {
    public Studente getStudente(String id);

    public Docente getDocente(String id);

    public void addDocente(Docente docente);

    public void addStudente(Studente studente);

    public ArrayList<Studente> getStudenti();

    public ArrayList<Docente> getDocenti();

    public String getIdFacolta();

    public String toString();

    public int getLastDocente();

    public int getLastStudente();

    public EsameAttivo getEsameAttivo();

    public void setEsameAttivo(EsameAttivo esameAttivo);

    public Esame getNextEsame();

    public void remoteEsame();

    public ArrayList<Esame> getEsami();
}
