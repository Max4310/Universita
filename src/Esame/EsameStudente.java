package Esame;

public class EsameStudente extends Esame{
    private float voto;

    public EsameStudente(){

    }
    public EsameStudente(String nomeEsame, float voto) {
        super(nomeEsame);
        this.voto = voto;
    }

    public float getVoto() {
        return voto;
    }


    public String toString(){
        return "{ Nome Esame: " + this.getNomeEsame() + ", voto: " + this.voto + " }";
    }
}
