package universita;

import Facolta.Facolta_I;
import Persone.Docente;

public class EsameStudente extends Esame{
    private float voto;
    private Docente docente;

    public EsameStudente(String nomeEsame, Facolta_I facolta, float voto, Docente docente) {
        super(nomeEsame, facolta);
        this.voto = voto;
        this.docente = docente;
    }

    public float getVoto() {
        return voto;
    }

    public Docente getDocente(){
        return this.docente;
    }


    public String toString(){
        return "{ Nome Esame: " + this.getNomeEsame() + ", Facolta: " + this.getFacolta() + ",\nDocente: " + this.docente.toString() + ", voto: " +
                this.voto + " }";
    }
}
