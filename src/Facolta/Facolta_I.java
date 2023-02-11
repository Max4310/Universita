package Facolta;

import Persone.Docente;
import Persone.Studente;
import Esame.Esame;
import Esame.EsameAttivo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;

/**
 *
 * @author STUDENTE
 */

@JsonDeserialize(as = Facolta_C.class)
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

    public void setLastStudente(int i);
    public void setLastDocente(int i);
}
